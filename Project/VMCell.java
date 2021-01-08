
class VMCell implements IValue {

    IValue v;

    public VMCell(IValue v0) {
        v = v0;
    }

    public IValue getVal() {
        return v;
    }

    public void set(IValue v0) {
        v = v0;
    }

    @Override
    public IValue eval(EnvironmentInt e) {
        return null;
    }
}