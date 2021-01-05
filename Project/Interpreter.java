import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interpreter {
    /**
     * Main entry point.
     */
    public static void main(String args[]) throws FileNotFoundException {
        if (args.length < 1) {
            System.out.println("Missing argument: name of file to interpret");
        }

        Parser parser = new Parser(new FileInputStream(new File(args[0])));
        ASTNode exp;

        try {
            exp = parser.Start();
            exp.eval(new EnvironmentInt());
        } catch (Exception e) {
            System.out.println("Syntax Error!");
            e.printStackTrace();
        }

    }
}
