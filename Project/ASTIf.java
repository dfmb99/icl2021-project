import exceptions.TypeError;

import java.util.Objects;

class ASTIf implements ASTNode {

    ASTNode cond, th, el;

    public ASTIf(ASTNode cond, ASTNode th, ASTNode el) {
        //condition node
        this.cond = cond;
        //then node
        this.th = th;
        //else node
        this.el = el;
    }

    @Override
    public IValue eval(EnvironmentInt env) throws TypeError {
        IValue v1 = cond.eval(env);
        IValue v3 = null;
        if (el != null) {
            v3 = el.eval(env);
        }
        if ( ((VBool)v1).getVal() ) {
            // condition is true
            return th.eval(env);
        } else {
            // condition is false
            return Objects.requireNonNullElseGet(v3, () -> new VVoid());
        }
    }

    @Override
    public void compile(CodeBlock c, EnvironmentComp e, Environment<IType> eType) throws TypeError {

    }

    @Override
    public IType typecheck(Environment<IType> env) throws TypeError {
            IType t1 = cond.typecheck(env);
            if (t1 instanceof  TBool) {
                IType tt = th.typecheck(env);
                IType te = el.typecheck(env);
                if (tt.equals(te)) return te;
                throw new TypeError("if: mismatch in then / else branch types");
            }
            throw new TypeError("if: condition is non boolean");
        }
    }
