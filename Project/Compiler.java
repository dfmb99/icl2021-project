import java.io.FileOutputStream;
import java.io.PrintStream;

public class Compiler {

    public static void main(String args[]) {
        Parser parser = new Parser(System.in);
        ASTNode exp;

        try {
            exp = parser.Start();
            CodeBlock c = new CodeBlock();
            exp.compile(c, new EnvironmentComp());
            c.dump(new PrintStream(new FileOutputStream("Compiled.j", false)));
            System.out.print("[Compiler] Generated Compiled.j");
        } catch (Exception e) {
            System.out.println("Syntax Error!");
            e.printStackTrace();
            parser.ReInit(System.in);
        }
    }
}
