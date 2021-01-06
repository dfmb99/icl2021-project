import exceptions.TypeError;

public class ASTNeg implements ASTNode{
    ASTNode n;

    public ASTNeg(ASTNode n) {
        this.n = n;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v = n.eval(env);
        if (v instanceof VBool) {
            return new VBool(!((VBool) v).getVal());
        }
        throw new TypeError("~, argument must be VBool");
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}
