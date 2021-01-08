import exceptions.TypeError;

class ASTAssign implements ASTNode {  // E1 := E2

    ASTNode lhs, rhs;

    public ASTAssign(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = lhs.eval(env);
        if (v1 instanceof VMCell) {
            IValue v2 = rhs.eval(env);
            ((VMCell) v1).set(v2);
            return v2;
        }
        throw new TypeError("assignment :=, lhs is not a reference");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return null;
    }

}