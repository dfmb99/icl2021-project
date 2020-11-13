public class ASTId implements ASTNode {
	private String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public int eval(EnvironmentInt e) {
		return e.find(id);
	}

	@Override
	public void compile(CodeBlock c, EnvironmentComp e) {

	}
}