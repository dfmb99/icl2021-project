public class ASTDiv implements ASTNode {

    private ASTNode lhs, rhs;

    public ASTDiv(ASTNode l, ASTNode r)
    {
        lhs = l; rhs = r;
    }
    public int eval(Environment e) {
        int v1 = lhs.eval(e);
	    int v2 = rhs.eval(e);
	    return v1/v2;
    }
}