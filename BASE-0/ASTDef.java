public class ASTDef implements ASTNode {
	String id;
	ASTNode init;
	ASTNode body;
	//List<Bind> bindings; //each bind a pair (String, ASTNode)

	public ASTDef(String id, ASTNode init, ASTNode body) {
		this.id = id;
		this.init = init;
		this.body = body;
	}

	@Override
	public int eval(Environment e) {
		int val = init.eval(e);
		e.beginScope();
		e.assoc(id, val);
		val = body.eval(e);
		e.endScope();
		return val;
	}
}