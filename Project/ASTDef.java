import exceptions.TypeError;

import java.util.List;

public class ASTDef implements ASTNode {
	List<Token> ids;
	List<ASTNode> init;
	ASTNode body;
	//List<Bind> bindings; //each Bind a pair (String, ASTNode)

	public ASTDef(List<Token> ids, List<ASTNode> init, ASTNode body) {
		this.ids = ids;
		this.init = init;
		this.body = body;
	}

	@Override
	public IValue eval(EnvironmentInt e) throws TypeError {
		e.beginScope();
		for(int i= 0; i < ids.size(); i++) {
			e.assoc(ids.get(i).image, init.get(i).eval(e));
		}
		IValue val = body.eval(e);
		e.endScope();
		return val;
	}

	@Override
	public void compile(CodeBlock c, EnvironmentComp e){
		e.beginScope();
		int depth = e.depth -1;
		String frameName = "frame_" + depth ;
		//creates new frame file
		c.newFrame(depth, ids.size());
		c.emit(String.format("new %s", frameName));
		c.emit("dup");
		c.emit(String.format("invokespecial %s/<init>()V", frameName));
		c.emit("dup");
		c.emit("aload_0");
		if (depth == 0)
			c.emit(String.format("putfield %s/sl Ljava/lang/Object;", frameName));
		else
			c.emit(String.format("putfield %s/sl Lframe_%d;", frameName, depth - 1));;

		c.emit("dup");
		c.emit("astore_0");
		for(int i= 0; i < ids.size(); i++) {
			String slot = "v"+i;
			e.assoc(ids.get(i).image, new Bind(depth, init.get(i), slot));
			c.emit("dup");
			init.get(i).compile(c, e);
			c.emit(String.format("putfield %s/%s I", frameName, slot));
		}
		c.emit("pop");
		body.compile(c, e);
		e.endScope();
	}
}