public class ASTMult implements ASTNode {

ASTNode lhs, rhs;

        public int eval(EnvironmentInt e)
        { 
	int v1 = lhs.eval(e);
	int v2 = rhs.eval(e);
        return v1*v2; 
	}
    
        public ASTMult(ASTNode l, ASTNode r)
        {
		lhs = l; rhs = r;
        }

        public void compile(CodeBlock c, EnvironmentComp e)
        {
                lhs.compile(c,e);
                rhs.compile(c,e);
                c.emit("imul");
        }     
}

