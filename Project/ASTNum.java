import exceptions.TypeError;

public class ASTNum implements ASTNode {

    int val;

    public ASTNum(int n) {
        val = n;
    }

    public IValue eval(EnvironmentInt e) {
        return new VInt(val);
    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return new TInt();
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {
        c.emit(String.format("sipush %s", val));
    }
}

