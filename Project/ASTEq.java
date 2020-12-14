class ASTEq implements ASTNode {

    IValue eval(Environmnent env) {
        IValue v1 = left.eval(env);
        if (v1 instanceof  VInt) {
            IValue v2 = right.eval(env)
            if (v2 instanceof VInt) {
                return new Vint((VInt)v1).getval()+((VInt)v2).getval())
            }
        throw TypeError("+: argument is not an integer");

        }
    }


}
