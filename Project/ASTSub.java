import exceptions.TypeError;

public class ASTSub implements ASTNode {

    ASTNode lhs, rhs;


    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = lhs.eval(env);
        if (v1 instanceof VInt) {
            IValue v2 = rhs.eval(env);
            if (v2 instanceof VInt) {
                return new VInt(((VInt) v1).getVal() - ((VInt) v2).getVal());
            }
        }
        throw new TypeError("- : argument is not an integer");
    }


    public ASTSub(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    public void compile(CodeBlock c, EnvironmentComp e) {
        lhs.compile(c, e);
        rhs.compile(c, e);
        c.emit("isub");
    }
}

