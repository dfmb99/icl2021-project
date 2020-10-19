class Environment {
	Environment beginScope();

	Environment endScope();

	void assoc(String id, int val);

	int find();
}