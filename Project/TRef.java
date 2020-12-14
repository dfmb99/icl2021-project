public class TRef implements IType {

    IType tr;

    TRef(IType t) { tr = t; }
    IType getreftype() { return tr;}
}