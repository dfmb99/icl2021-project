import java.util.HashMap;
import java.util.Map;

public class EnvironmentType implements Environment<IType> {
    EnvironmentType ancestor;
    EnvironmentType curr;
    Map<String, IValue> map;
    int depth;

    public EnvironmentType() {
        ancestor = null;
        curr = this;
        map = new HashMap<>();
        depth = 0;
    }

    @Override
    public Environment beginScope() {
        return null;
    }

    @Override
    public Environment endScope() {
        return null;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public void assoc(String id, IType bind) {

    }

    @Override
    public IType find(String id) {
        return null;
    }
}
