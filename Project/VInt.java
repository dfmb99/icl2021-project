
class VInt implements IValue {

    int v;

    public VInt(int v0) { v = v0; }

    public int getVal() {
        return v;
    }

    @Override
    public IValue eval(EnvironmentInt e) {
        return null;
    }
}