package TDA;

public class Nodo<T>{
    protected T val;

    public Nodo(T val){
        this.val = val;
    }

    public T getVal(){
        return val;
    }
    public void setVal(T val){ this.val = val;}
}
