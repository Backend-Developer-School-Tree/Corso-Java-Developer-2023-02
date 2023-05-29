public class Contenitore<T> {

    private T myIstanceVar;

    public Contenitore() {
    }

    public Contenitore(T myIstanceVar) {
        this.myIstanceVar = myIstanceVar;
    }

    public T getMyIstanceVar() {
        return myIstanceVar;
    }

    public void setMyIstanceVar(T myIstanceVar) {
        this.myIstanceVar = myIstanceVar;
    }

    @Override
    public String toString() {
        return "Contenitore{" +  "myIstanceVar=" + myIstanceVar + '}';
    }
}
