import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
public class BST <T extends Comparable> implements Iterable <T>{
    //Parte a del ejercicio
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
    public T buscar(T valor){//Para buscar no aplicamos la forma recursiva sino la iterativa
        if (raiz.elemento.compareTo(valor)==0){
            return valor;//si es la raiz podemos retornar directamente
        }else{
            nodo actual=raiz;
            while (actual!=null){//mientras no sea nulo seguimos el cilo, si es que en algun momento el nodo es nulo es pq el elemento no se encuentra en el arbol
                if (actual.elemento.compareTo(valor)>0){
                    actual=actual.izq;//atctualizamos el nodo en caso de que sea menor o mayor
                }else if(actual.elemento.compareTo(valor)<0){
                    actual=actual.der;
                }else{
                    return valor;
                }
            }
        }
        return null;
    }
    public void agregar(T v){//Para agregar tambien usamos un metodo iterativo
        nodo nuevo=new nodo(v);
        if (raiz==null){//en caso de que la raiz este vacia añadimos directamente
            raiz=nuevo;
            return;
        }
        nodo anterior=null;// nos servira en el momento de asignar si es hijo izq o der del padre
        nodo actual=raiz;
        //ciclo donde encontramos el lugar donde tiene que ubicarse el nodo
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
    //para imprimor usamos un inorder
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
    //Parte b del ejercicio
    //Para poder usar la estructura del arbol en un for each lo que hicimos fue implementar iterable a nuestra clase
    @Override
    //El iterator que nos servira en el for each
    public Iterator <T> iterator(){
        Iterator aux=new BSTIterator(raiz);
        return aux;
    }
    //Para poder hacer la clase del Iterator nos ayudamos de esta pagina https://medium.com/algorithm-problems/binary-search-tree-iterator-19615ec585a
    protected class BSTIterator implements Iterator <T> {
        Stack<nodo> stack = new Stack<nodo>();//para nuestra conveniencia usamos un stack
        public BSTIterator(nodo root) {
            enviarizq(root);// añadimos al stack
        }
        @Override
        public boolean hasNext(){// en caso de que nuestra stack ya este vacio
            if(stack.empty()){
                return false;
            }return true;
        }
        @Override
        public T next(){// para comprobar que sigue teniendo elementos nuestro stack
            nodo node = stack.pop();
            enviarizq(node.der);
            return node.elemento;
        }
        private void enviarizq(nodo node){
            if (node != null){
                stack.push(node);
                enviarizq(node.izq);
            }
        }
    }
    //Parte c del ejercicio
    //Creamos un inorder que añade elementos en un arraylist estos elementos se guardan de forma ordenada
    void inorderañadir(nodo raiz,ArrayList aux){
        if (raiz!=null){
            inorderañadir(raiz.izq,aux);
            aux.add(raiz.elemento);
            inorderañadir(raiz.der,aux);
        }
    } 
    //Para poder retornar un iterable debemos usar un array list
    public Iterable <T> iteratorClaves(T min,T max){
        //En caso de que la clave minima es mayor debe lanzar un error
        if (min.compareTo(max)>0){
            System.out.println("La clave minima es menor a la maxima");
            return null;
        }
        ArrayList<T> aux= new ArrayList<T>();
        inorderañadir(raiz,aux);
        int pos1=aux.indexOf(min);
        int pos2=aux.indexOf(max);
        ArrayList<T> aux2= new ArrayList<T>();//Nuestro segundo array contiene solo los elementos desde la clave minima hasta la maxima
        for (int i=pos1;i<=pos2;i++){
            aux2.add(aux.get(i));
        }
        return aux2;
    }
}







