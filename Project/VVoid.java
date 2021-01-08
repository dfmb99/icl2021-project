public class VVoid implements IValue{

    public VVoid() { }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public IValue eval(EnvironmentInt e) {
        return null;
    }
}
