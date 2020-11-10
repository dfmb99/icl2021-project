class CodeBlock{
	String code[];
	int pos;

	public void emit(String bytecode)
	{
		code[pos]=bytecode;
		pos++;
	}

	public void dump(PrintStream f)
	{

	}

}