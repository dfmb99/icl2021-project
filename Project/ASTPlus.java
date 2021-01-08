import exceptions.TypeError;

public class ASTPlus implements ASTNode {

    ASTNode lhs, rhs;

    public ASTPlus(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    public IValue eval(EnvironmentInt e) throws TypeError {
        IValue v1 = lhs.eval(e);
        if (v1 instanceof VInt) {
            IValue v2 = rhs.eval(e);
            if (v2 instanceof VInt) {
                return new VInt(((VInt)v1).getVal() +((VInt)v2).getVal());
            }
        }
        throw new TypeError("+: argument is not an integer");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {
        lhs.compile(c, e, eType);
        rhs.compile(c, e, eType);
        c.emit("iadd");
    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        IType t1 = lhs.typecheck(env);
        if (t1 instanceof TInt) {
            IType v2 = rhs.typecheck(env);
            if (v2 instanceof TInt) {
                return new TInt();
            }
        }
        throw new TypeError("+: argument is not an integer");
    }


}