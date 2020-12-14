public interface IType {

    String toString();
    IType typecheck(Env<IType> e); //IType constructors TInt() TBool TRef(IType t)

}