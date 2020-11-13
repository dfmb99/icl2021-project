public class Interpreter {
    /** Main entry point. */
    public static void main(String args[]) {
        Parser parser = new Parser(System.in);
        ASTNode exp;

        while (true) {
            try {
                exp = parser.Start();
                System.out.println( exp.eval( new EnvironmentInt()) );
            } catch (Exception e) {
                System.out.println ("Syntax Error!");
                e.printStackTrace();
                parser.ReInit(System.in);
            }
        }
    }
}
