public class ASTId implements ASTNode {
	private String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public int eval(Environment e) {
		return e.find(id);
	}
}