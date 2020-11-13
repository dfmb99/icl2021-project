import java.util.HashMap;
import java.util.Map;

public class EnvironmentComp {
    EnvironmentComp ancestor;
    EnvironmentComp curr;
    Map<String, Integer> map;

    public EnvironmentComp() {
        ancestor = null;
        curr = this;
        map = new HashMap<>();
    }

    EnvironmentComp beginScope() {
        ancestor = curr;
        curr = new EnvironmentComp();
        curr.map = ancestor.map;
        return curr;
    }

    EnvironmentComp endScope() {
        curr = ancestor;
        return curr;
    }

    void assoc(String id, int val) {
        curr.map.put(id, val);
    }

    int find(String id) {
        return curr.map.get(id);
    }
}
