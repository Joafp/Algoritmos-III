package arbol;

/**
 *
 * @author BICHO
 */
public class estructura<K extends Comparable,D extends Comparable>{
    nodo raiz;
    
    public estructura(){
        raiz=null;
    }
    private class nodo<K,D>{
        public K clave;
        public D dato;
        public nodo izquierda,derecha,padre;
    }
    public D buscar (K llave)throws noEncontrado{
        nodo aux=raiz;
        D resultado = null;
        boolean encontrado=false;
        while((aux != null)  &&  (encontrado==false)){//En terminos de BIG O, El peor caso que nos podriamos encontrar en este ciclo while seria cuando el arbol tenga forma de lista enlazada y la clave que estamos buscando
            //No se encuentre en nuestro arbol, en ese caso estariamos haciendo en total n comparaciones, siendo n la cantidad de nodos existentes en el arbol, por lo tanto O=(n) lineal
            if(llave.compareTo(aux.clave)==0){
                encontrado=true;
                resultado=(D) aux.dato;
            }
            else{
                if(llave.compareTo(aux.clave)>0){
                    aux=aux.derecha;
                }
                else{
                    aux=aux.izquierda;
                }
            }
        }
        if(encontrado==true){
            return resultado;
        }
        throw new noEncontrado();
    }
    public void insertar(K llave, D dato){
      nodo<K,D> n= new nodo<K,D>();
      n.clave=llave;
      n.dato=dato;
      if(raiz==null){
           raiz=n;
        }
       else{
           nodo aux=raiz;
           while(aux != null){//En el peor de los casos estariamos preguntando (n-1) veces para encontrar el null, teniendo en cuenta que n seria el nodo que queremos insertar y que el arbol se genere en forma de una lista enlazada
              //Entonces tenemos que el t(n)=n-1 por ende O=n, es lineal
              n.padre=aux;
              if(n.clave.compareTo(aux.clave)>0){
                 aux=aux.derecha;
                }
               else{
                  aux=aux.izquierda;
                }
            }
          if(n.clave.compareTo(n.padre.clave)<0){
             n.padre.izquierda=n;
            }
           else{
              n.padre.derecha=n;
            }
        }
    }
}
