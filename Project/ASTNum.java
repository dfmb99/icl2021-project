public class ASTNum implements ASTNode {

    int val;

    public IValue eval(EnvironmentInt e) { return new VInt(val); }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {
        c.emit(String.format("sipush %s", val));
    }

    public ASTNum(int n)
        {
	    val = n;
        }

}

