import exceptions.TypeError;

public class ASTPrint implements ASTNode {

    ASTNode n;

    public ASTPrint(ASTNode n) {
        this.n = n;
    }

    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = n.eval(env);
        if (v1 instanceof VInt) {
            System.out.print(((VInt) v1).getVal());
        } else if(v1 instanceof VBool) {
            System.out.print(((VBool) v1).getVal());
        } else if (v1 instanceof VMCell) {
            System.out.print(((VMCell) v1).getVal());
        }
        return new VVoid();
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
        return null;
    }

}


