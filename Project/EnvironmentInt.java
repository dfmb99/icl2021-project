import java.util.HashMap;
import java.util.Map;

	public class EnvironmentInt implements Environment<Integer> {
	EnvironmentInt ancestor;
	EnvironmentInt curr;
	Map<String, Integer> map;
	int depth;

	public EnvironmentInt() {
		ancestor = null;
		curr = this;
		map = new HashMap<>();
		depth = 0;
	}

	@Override
	public EnvironmentInt beginScope() {
		ancestor = curr;
		curr = new EnvironmentInt();
		curr.map = ancestor.map;
		depth++;
		return curr;
	}

	@Override
	public Environment endScope() {
		curr = ancestor;
		depth--;
		return curr;
	}

	@Override
	public int depth() {
		return depth;
	}

	@Override
	public void assoc(String id, Integer bind) {
		curr.map.put(id, bind);
	}

	@Override
	public Integer find(String id) {
		return curr.map.get(id);
	}
}