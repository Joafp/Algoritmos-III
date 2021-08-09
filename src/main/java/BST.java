public class BST <T extends Comparable<? super T >> {       
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
    public nodo getraiz(){
        return raiz;
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
    public void imprimirprofundidad(nodo aux,int cont){
        if (aux==null){
            return;
        }else{
            imprimirprofundidad(aux.der,cont+1);
            for (int i=0;i<cont;i++){
                System.out.print("  ");
            }
            System.out.println(aux.elemento);
            imprimirprofundidad(aux.izq,cont+1);
        }
    }
}
