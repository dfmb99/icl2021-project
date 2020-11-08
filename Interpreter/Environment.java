import java.util.HashMap;
import java.util.Map;

public class Environment {
	Environment ancestor;
	Environment curr;
	Map<String, Integer> map;

	public Environment() {
		ancestor = null;
		curr = this;
		map = new HashMap<>();
	}

	Environment beginScope() {
		ancestor = curr;
		curr = new Environment();
		curr.map = ancestor.map;
		return curr;
	}

	Environment endScope() {
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