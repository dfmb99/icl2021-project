import exceptions.TypeError;

class ASTMod implements ASTNode {

    ASTNode lhs, rhs;

    public ASTMod(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);
        if (v1 instanceof VInt && v2 instanceof VInt) {
            return new VInt(((VInt)v1).getVal()  % ((VInt)v2).getVal());
        }
        throw new TypeError("%: arguments must be VInt ");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

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
