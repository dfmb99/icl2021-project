import exceptions.TypeError;

public interface ASTNode {

    IValue eval(EnvironmentInt e) throws TypeError;
    void compile(CodeBlock c, EnvironmentComp e);
}

