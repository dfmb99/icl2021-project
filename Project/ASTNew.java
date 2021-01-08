import exceptions.TypeError;

class ASTNew implements ASTNode {

    ASTNode n;

    public ASTNew(ASTNode n) {
        this.n = n;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        return new VMCell(n.eval(env));
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return null;
    }

}