public class ASTSub implements ASTNode {

ASTNode lhs, rhs;


    public IValue eval(EnvironmentInt e) {
        IValue v1 = lhs.eval(e);
        if (v1 instanceof VInt) {
            IValue v2 = rhs.eval(e)
            if (v2 instanceof VInt) {
                return new Vint((VInt) v1).sub(v2);
            }
            throw TypeError("- : argument is not an integer");
        }
    }



    public IType typecheck(Environmnent<ITtype> tenv) {

        IType t1 = lhs.typecheck(tenv);
        if (t1 instanceof TInt) {
            IType v2 = rhs.typecheck(tenv)
            if (v2 instanceof TInt) {
                return new TInt()
            }
            throw TypeError(" +:argument is not an integer");
        }
    }
    
        public ASTSub(ASTNode l, ASTNode r)
        {
		lhs = l; rhs = r;
        }

        public void compile(CodeBlock c, EnvironmentComp e)
        {
                lhs.compile(c,e);
                rhs.compile(c,e);
                c.emit("isub");
        }
}

