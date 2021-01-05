import java.util.HashMap;
import java.util.Map;

	public class EnvironmentInt implements Environment<IValue> {
	EnvironmentInt ancestor;
	EnvironmentInt curr;
	Map<String, IValue> map;
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
	public Environment<IValue> endScope() {
		curr = ancestor;
		depth--;
		return curr;
	}

	@Override
	public int depth() {
		return depth;
	}

	@Override
	public void assoc(String id, IValue bind) {
		curr.map.put(id, bind);
	}

	@Override
	public IValue find(String id) {
		return curr.map.get(id);
	}
}