import exceptions.TypeError;

class ASTWhile implements ASTNode {

    ASTNode lhs, rhs, condition, expression;


    public ASTWhile(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        while (((VBool)lhs.eval(env)).getVal()) {
            rhs.eval(env);
        }
        return new VVoid();
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {
        int startLabel = c.CountLabels(2);
        String label1 = "L" + startLabel;
        String label2 = "L" + startLabel+1;

        c.emit(label1 + ":");
        condition.compile(c,e,eType);
        c.emit("ifeq" + label2);
        expression.compile(c,e,eType);
        c.emit("pop");
        c.emit("goto" + label1);
        c.emit(label2 + ":");
    }


    public IType typecheck(Environment<IType> env) throws TypeError{
        IType t = condition.typecheck(env);
        if(t instanceof TBool)
            return null;
        throw new TypeError("While condition not a boolean");
    }
}

