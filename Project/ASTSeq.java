import exceptions.TypeError;

public class ASTSeq implements ASTNode{

    ASTNode lhs, rhs;

    public ASTSeq(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt e) throws TypeError {
        lhs.eval(e);
        return rhs.eval(e);
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}
