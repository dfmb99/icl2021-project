import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Environment {
	Environment ancestor;
	Environment curr;
	Map<String, Integer> map;
	Stack<> stack;


	public Environment() {
		ancestor = null;
		curr = this;
		map = new HashMap<>();
		stack = new Stack<>();
	}

	Environment beginScope() {
		ancestor = curr;
		curr = new Environment();
		curr.map = ancestor.map;
		stack.push(curr);
		return curr;
	}

	Environment endScope() {
		curr = ancestor;
		stack.pop(curr);
		return curr;
	}

	void assoc(String id, int val) {
		curr.map.put(id, val);
	}

	int find(String id) {
		return curr.map.get(id);
	}
}