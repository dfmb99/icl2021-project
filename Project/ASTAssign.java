class ASTAssign implements ASTNode {  // E1 := E2


    IValue eval(Environmnent env) {

        IValue v1 = left.eval(env);
        if (v1 instanceof  VMCell) {
            v2 = right.eval(env):
            ((VMCell)v1).set(v2);
            return v2;

        }
        throw TypeError("assignment := : lhs is not a reference");
    }