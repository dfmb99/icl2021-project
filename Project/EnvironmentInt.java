import java.util.HashMap;
import java.util.Map;

public class EnvironmentInt {
	EnvironmentInt ancestor;
	EnvironmentInt curr;
	Map<String, Integer> map;

	public EnvironmentInt() {
		ancestor = null;
		curr = this;
		map = new HashMap<>();
	}

	EnvironmentInt beginScope() {
		ancestor = curr;
		curr = new EnvironmentInt();
		curr.map = ancestor.map;
		return curr;
	}

	EnvironmentInt endScope() {
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