public class ASTId implements ASTNode {
	private String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public int eval(EnvironmentInt e) {
		return e.find(id);
	}

	public IType typecheck(Environmnent<IType> tenv) {
		return tenv.find(id);
	}



	@Override
	public void compile(CodeBlock c, EnvironmentComp e) {
		Bind b = e.find(id);
		int depth = e.depth();
		c.emit("aload_0");
		while(b.getDepth() != depth -1) {
			depth--;
			c.emit(String.format("getfield frame_%d/sl Lframe_%d;", depth, depth-1));
		}
		c.emit(String.format("getfield frame_%d/%s I", depth-1, b.getSlot()));
	}
}