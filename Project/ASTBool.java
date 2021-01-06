public class ASTBool implements ASTNode {

    boolean val;

    public ASTBool(boolean n)
    {
        val = n;
    }

    public IValue eval(EnvironmentInt e) {
        return new VBool(val);
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}