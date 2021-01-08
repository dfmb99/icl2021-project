public class TRef implements IType {

    IType tr;

    public TRef(IType t) { tr = t; }
    public IType getreftype() { return tr;}

}
