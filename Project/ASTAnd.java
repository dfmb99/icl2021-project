import exceptions.TypeError;

class ASTAnd implements ASTNode {

    ASTNode lhs, rhs;

    public ASTAnd(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);
        if (v1 instanceof VBool && v2 instanceof VBool) {
            return new VBool(((VBool)v1).getVal()  && ((VBool)v2).getVal());
        }
        throw new TypeError("&&: arguments must be VBool ");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        IType t1 = lhs.typecheck(env);
        if (t1 instanceof  TInt) {
            IType v2 = rhs.typecheck(env);
            if (v2 instanceof VInt) {
                return new TInt();
            }
        }
        throw new TypeError("+: argument are not compatible");
    }
}


