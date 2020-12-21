public class Bind {

    private int depth;
    private ASTNode node;
    private String slot;

    public Bind(int depth, ASTNode node, String slot) {
        this.depth = depth;
        this.node = node;
        this.slot = slot;
    }

    public int getDepth() {
        return depth;
    }

    public ASTNode getNode() {
        return node;
    }

    public String getSlot() {
        return slot;
    }
}
