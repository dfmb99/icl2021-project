import exceptions.TypeError;

public class ASTMinus implements ASTNode{
    ASTNode n;

    public ASTMinus(ASTNode n) {
        this.n = n;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v = n.eval(env);
        if (v instanceof VInt) {
            return new VInt(-((VInt) v).getVal());
        }
        throw new TypeError("-, expression must be VInt");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}
