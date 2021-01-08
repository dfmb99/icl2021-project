import exceptions.TypeError;

public class ASTDeref implements ASTNode{
    ASTNode n;

    public ASTDeref(ASTNode n) {
        this.n = n;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v = n.eval(env);
        if (v instanceof VMCell) {
            return ((VMCell) v).getVal();
        }
        throw new TypeError("!, not a valid reference");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return null;
    }

}
