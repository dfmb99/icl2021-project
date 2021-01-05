import exceptions.TypeError;

class ASTWhile implements ASTNode {

    ASTNode lhs, rhs;

    public ASTWhile(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        while (((VBool)lhs.eval(env)).getVal()) {
            rhs.eval(env);
        }
        return new VVoid();
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e) {

    }
}

