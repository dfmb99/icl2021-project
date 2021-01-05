import exceptions.TypeError;

class ASTEq implements ASTNode {

    ASTNode lhs, rhs;

    public ASTEq(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            return new VBool(((VInt)v1).getVal()  == ((VInt)v2).getVal());
        } else if (v1 instanceof VBool && v2 instanceof VBool) {
            return new VBool(((VBool) v1).getVal() == ((VBool) v2).getVal());
        } else if (v1 instanceof VMCell && v2 instanceof VMCell) {
            return new VBool(v1 == v2);
        }
        throw new TypeError("=: arguments have different types");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}
