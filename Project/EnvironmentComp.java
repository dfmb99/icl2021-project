import java.util.HashMap;
import java.util.Map;

public class EnvironmentComp implements Environment<Bind> {
    EnvironmentComp ancestor;
    EnvironmentComp curr;
    Map<String, Bind> map;
    int depth;

    public EnvironmentComp() {
        ancestor = null;
        curr = this;
        map = new HashMap<>();
        depth = 0;
    }

    @Override
    public Environment	beginScope() {
        ancestor = curr;
        curr = new EnvironmentComp();
        curr.map = ancestor.map;
        depth++;
        return curr;
    }

    @Override
    public Environment	endScope(){
        curr = ancestor;
        depth--;
        return curr;
    }

    @Override
    public int	depth() {
        return depth;
    }

    @Override
    public void assoc(String id, Bind b) {
        curr.map.put(id, b);
    }

    @Override
    public Bind find(String id) {
        return curr.map.get(id);
    }
}