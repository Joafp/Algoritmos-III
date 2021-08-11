import java.util.Iterator;
import java.util.Stack;
public class BST <T extends Comparable> implements Iterable <T>{
    class nodo  {
        T elemento;
        nodo izq,der;
        public nodo(T elem){
            elemento=elem;
            izq=der=null;
        }
     }    
    nodo raiz;
    BST(){
        raiz=null;
    }
    public T buscar(T valor){
        if (raiz.elemento.compareTo(valor)==0){
            return valor;
        }else{
            nodo actual=raiz;
            while (actual!=null){
                if (actual.elemento.compareTo(valor)>0){
                    actual=actual.izq;
                }else if(actual.elemento.compareTo(valor)<0){
                    actual=actual.der;
                }else{
                    return valor;
                }
            }
        }
        return null;
    }
    public void agregar(T v){
        nodo nuevo=new nodo(v);
        if (raiz==null){
            raiz=nuevo;
            return;
        }
        nodo anterior=null;
        nodo actual=raiz;
        while (actual!=null){
            if (actual.elemento.compareTo(v)>0){
                anterior=actual;
                actual=actual.izq;
            }else if(actual.elemento.compareTo(v)<0){
                anterior=actual;
                actual=actual.der;
            }
        }
        if (anterior.elemento.compareTo(v)>0){
            anterior.izq=nuevo;
        }else{
            anterior.der=nuevo;
        }   
    }
    public void imprimir(){
        inorder(raiz);
    }
    void inorder(nodo raiz){
        if (raiz!=null){
            inorder(raiz.izq);
            System.out.print(raiz.elemento+" ");
            inorder(raiz.der);
        }
    }
    @Override
    public Iterator <T> iterator(){
        Iterator aux=new BSTIterator(raiz);
        return aux;
    }
    protected class BSTIterator implements Iterator <T> {
        Stack<nodo> stack = new Stack<nodo>();
        public BSTIterator(nodo root) {
            pushToLeft(root);
        }
        @Override
        public boolean hasNext(){
            if(stack.empty()){
                return false;
            }return true;
        }
        @Override
        public T next(){
            nodo node = stack.pop();
            pushToLeft(node.der);
            return node.elemento;
        }
        private void pushToLeft(nodo node){
            if (node != null){
                stack.push(node);
                pushToLeft(node.izq);
            }
        }
    }
}







