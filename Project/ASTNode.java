public interface ASTNode {

    int eval(EnvironmentInt e);
    void compile(CodeBlock c, EnvironmentComp e);
}

