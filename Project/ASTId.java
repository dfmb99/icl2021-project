import exceptions.TypeError;

public class ASTId implements ASTNode {
    private String id;

    public ASTId(String id) {
        this.id = id;
    }

    @Override
    public IValue eval(EnvironmentInt e) {
        return e.find(id);
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {
        Bind b = e.find(id);
        int depth = e.depth();
        c.emit("aload_0");
        while (b.getDepth() != depth - 1) {
            depth--;
            c.emit(String.format("getfield frame_%d/sl Lframe_%d;", depth, depth - 1));
        }
        c.emit(String.format("getfield frame_%d/%s I", depth - 1, b.getSlot()));
    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return env.find(id);
    }
}