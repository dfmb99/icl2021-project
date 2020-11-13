import java.io.PrintStream;
import java.util.Arrays;

class CodeBlock{
	String code[];
	int pos;

	public CodeBlock() {
		this.code = new String[100];
		this.pos = 0;
	}

	public void emit(String bytecode)
	{
		code[pos]=bytecode;
		pos++;
	}

	public void dump(PrintStream f)
	{	begin(f);
		for(int i = 0; i < pos; i++) {
			f.println("       " + code[i]);
		}
		end(f);
	}

	private void begin(PrintStream f) {
		f.print(".class public Demo\n" +
				".super java/lang/Object\n" +
				"\n" +
				";\n" +
				"; standard initializer\n" +
				".method public <init>()V\n" +
				"   aload_0\n" +
				"   invokenonvirtual java/lang/Object/<init>()V\n" +
				"   return\n" +
				".end method\n" +
				"\n" +
				".method public static main([Ljava/lang/String;)V\n" +
				"       ; set limits used by this method\n" +
				"       .limit locals  10\n" +
				"       .limit stack 256\n" +
				"\n" +
				"       ; setup local variables:\n" +
				"\n" +
				"       ;    1 - the PrintStream object held in java.lang.System.out\n" +
				"       getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
				"\n" +
				"       ; place your bytecodes here\n" +
				"       ; START\n");
	}

	private void end(PrintStream f) {
		f.print("       ; END\n" +
				"\n" +
				"\n" +
				"       ; convert to String;\n" +
				"       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n" +
				"       ; call println \n" +
				"       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n" +
				"\n" +
				"       return\n" +
				"\n" +
				".end method");
	}

}