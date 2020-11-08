import java.util.List;

public class ASTDef implements ASTNode {
	List<Token> ids;
	List<ASTNode> init;
	ASTNode body;

	public ASTDef(List<Token> ids, List<ASTNode> init, ASTNode body) {
		this.ids = ids;
		this.init = init;
		this.body = body;
	}

	@Override
	public int eval(Environment e) {
		e.beginScope();
		for(int i= 0; i < ids.size(); i++) {
			e.assoc(ids.get(i).image, init.get(i).eval(e));
		}
		int val = body.eval(e);
		e.endScope();
		return val;
	}
}