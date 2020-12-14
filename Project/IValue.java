
public interface IValue {

    String toString();
    IValue eval(Env<IValue> e); //IValue constructors VInt(n) VBool(t) VMCell(value)

}



