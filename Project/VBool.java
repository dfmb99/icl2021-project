public class VBool implements IValue{
    boolean v;

    public VBool(boolean v0) { v = v0; }

    public boolean getVal() {
        return v;
    }

    @Override
    public IValue eval(EnvironmentInt e) {
        return null;
    }
}
