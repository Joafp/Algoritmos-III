//Integrantes Joaquin Delgado, Carlos Ayala
public class BST<T extends Comparable>
{
   private class NodoBST { 
        T dato = null;
        NodoBST izq = null;
        NodoBST der = null;
            
        public NodoBST (T dato)
       {
          this.dato = dato;
       }
        public NodoBST getizq(){
            return this.izq;
        }
        public NodoBST getder(){
            return this.der;
        }
   }  
   private NodoBST raiz = null;
   public NodoBST getraiz(){
       return this.raiz;
   }

   /* Agregar un dato al arbol */ 
   public void agregar (T dato)
   {
      if (buscar(dato)!=null){
          System.out.println("El "+dato+" ya existe en el arbol");
          return;
      }
      raiz = priv_agregar (raiz, dato);
   }

   /*
    * Retorna el "nodo" donde se encuentra el primer dato
    * que dice ser igual a parametro dado.
    * La comparacion se realiza via "compareTo()" de la interfaz Comparable.
    */
   public  NodoBST buscar (T dato)
   {
        NodoBST nodo = priv_buscar(raiz,dato);
            if ( nodo != null ) 
                return nodo;
          return null;	 
   }

   /*
    * Imprime el arbol en recorrido infijo o simetrico.
    */
   public void imprimir()
   {
      System.out.println();
      priv_imprimir (raiz);
      System.out.println();
   }
   public void eliminar(T dato){
       eliminar_iterativo(dato);
   }
   //Eliminar Iterativo
   private void eliminar_iterativo(T dato){
        //Para eliminar la raiz solo hay que ponerla nula
        if (raiz.dato.compareTo(dato)==0){
            System.out.println("Se elimino la raiz");
            raiz=null;
            return;
        }
        //En caso de que no sea la raiz lo que debemos de hacer es ver si lo que queremos eliminar se encuentra en nuestro arbol
        NodoBST actual=raiz;
        NodoBST anterior=null;
        boolean bandera=false;
        while (actual!=null && bandera==false){
            if (actual.dato.compareTo(dato)>0){
                anterior=actual;
                actual=actual.getizq();
            }else if(actual.dato.compareTo(dato)<0){
                anterior=actual;
                actual=actual.getder();
            }else{
                bandera=true;
            }
        }
        //En caso de que actual fuera null significa que el elemento no se encuentra en el arbol
        if (actual==null){
            System.out.println("No se encuentra lo que se quiere eliminar");
            return;
        }else{
            //Una vez encontrado el nodo debemos de analizar los siguientes casos
            //Primer caso es que el nodo sea una hoja, cuando pasa esto simplemente eliminamos el nodo
            if (actual.izq==null && actual.der==null){
                if (anterior.izq==actual){
                    anterior.izq=null;
                }else{
                    anterior.der=null;
                }
                actual=null;
            }else if (actual.izq!=null && actual.der==null){//El sigueinte caso es que el nodo tenga un hijo izq o derecho
                if (anterior.izq==actual){
                    anterior.izq=actual.getizq();//Simplemente vemos si el nodo es hijo izq o der del padre y ahora decimos que el hijo del nodo es hijo del padre
                }else{
                    anterior.der=actual.getizq();
                }
                actual=null;
            }else if(actual.izq==null && actual.der!=null){
                if (anterior.izq==actual){
                    anterior.izq=actual.getder();
                }else{
                    anterior.der=actual.getder();
                }
                actual=null;
            }else{
                //Por ultimo nos queda el caso donde el nodo tiene 2 hijos, en nuestro caso nosotros decidimos reemplazar el nodo por su sucesor
                NodoBST sucesor=null;
                NodoBST padresucesor=null;
                //Pirmero encontramos el sucesor
                if (actual.der!=null){ 
                    sucesor=actual;
                    while (sucesor.izq!=null){
                        padresucesor=sucesor;
                        sucesor=sucesor.izq;
                    }
                }else{
                    NodoBST x=raiz;
                    while (x!=null){
                        if (actual.dato.compareTo(x.dato)<0){
                            sucesor=x;
                            x=x.getizq();
                        }else if(actual.dato.compareTo(x.dato)>0){
                            x=x.getder();
                        }else{
                            break;
                        }
                    }
                }
                //En caso de que el sucesor no tenga ningun hijo simplemente cambiamos los punteros para que ahora el padre del nodo que queremos eliminar apunto al sucesor
                if (sucesor.der==null){
                    if (anterior.izq==actual){
                        anterior.izq=sucesor;
                    }else{
                        anterior.der=sucesor;
                    }
                    //Le cambiamos los nodos hijos del que queremos eliminar al sucesor
                    if (actual.izq!=null && sucesor!=actual.izq){
                        sucesor.izq=actual.izq;
                    }
                    if (actual.der!=null&&  sucesor!=actual.der){
                        sucesor.der=actual.der;
                    }
                }else{
                    //En caso de que el sucesor tenga hijos le asignamos esos hijos al padre del sucesor
                    if (padresucesor.izq==sucesor){
                        padresucesor.izq=sucesor.der;
                    }else{
                        padresucesor.der=sucesor.der;
                    }
                    if (anterior.izq==actual){
                        anterior.izq=sucesor;
                    }else{
                        anterior.der=sucesor;
                    }
                     //Le cambiamos los nodos hijos del que queremos eliminar al sucesor
                    if (actual.izq!=null && sucesor!=actual.izq){
                        sucesor.izq=actual.izq;
                    }
                    if (actual.der!=null&&  sucesor!=actual.der){
                        sucesor.der=actual.der;
                    }
                }
              
            }
        }
        
   }
   //encontrar el sucesor
    public T encontrarsucesor(NodoBST n,NodoBST suce,T dato){
        NodoBST aux=private_encontrarsucesor(n,suce,dato);
        return aux.dato;
    }
    public boolean lleno(NodoBST n){
        return private_lleno(n);
    } 
    private boolean private_lleno(NodoBST n){//Para ver si el nodo esta lleno recorremos recursivamente el arbol
        if (n==null){
            return true;
        }
        if (n.izq==null && n.der==null){
            return true;
        }
        if (n.izq!=null && n.der!=null){
            return private_lleno(n.izq) && private_lleno(n.der);
        }
        return false;
    }
    public int contnodos(NodoBST n){
        return private_contnodos(n);
    }
    private int private_contnodos(NodoBST n){
        if (n==null){
            return 0;
        }
        return 1+contnodos(n.izq)+ contnodos(n.der);//Para el contador de nodo recorremos los nodos y sumamos 1 cada vez que encontramos un nodo y 0 si es un nodo null
    }
    public boolean completo(NodoBST n,int pos,int cantidad){
        if (n==null){
            return true;
        }
        if (pos>=cantidad){
            return false;
        }
        return completo(n.izq,2*pos+1,cantidad) && completo(n.der,2*pos+2,cantidad);//Para ver si esta completo tenemos pondremos posiciones a los nodos, el nodo raiz es 0 sus hijos son 1 y 2
                                                                                    //Los hijos de 1 seran 3 y 4 y de 2 5 y 6, asi sucesivamente si es que encontramos un una posicion que es mayor que la cantidad de nodos
                                                                                    //es por que el arbol no esta completo
    }
    private NodoBST private_encontrarsucesor(NodoBST n,NodoBST suce,T dato){
        if (n==null){
            return suce;
        }
        if (n.dato.compareTo(dato)==0){//Para encontrar el sucesor simplemente vemos si nuestro nodo tiene surarbol derecho, en caso de que tenga buscamos el valor minimo
            if (n.der!=null){
                return valorminimo(n.der);
            }
        }else if(dato.compareTo(n.dato)<0){
            suce=n;
            return private_encontrarsucesor(n.izq,suce,dato);
        }else{
            return private_encontrarsucesor(n.der,suce,dato);
        }
        return suce;    
    }
    public T encontrarpredecesor(NodoBST n,NodoBST prede,T dato){
        NodoBST aux=private_encontrarpredecesor(n,prede,dato);
        return aux.dato;
    }
    public NodoBST private_encontrarpredecesor(NodoBST n,NodoBST prede,T dato){
            if (n==null){
                return prede;
            }
            if (n.dato.compareTo(dato)==0){//Para el predecesor hacemos lo mismo solo que buscamos el valor maximo
                if (n.izq!=null){
                    return valormaximo(n.izq);
                }
            }else if(dato.compareTo(n.dato)<0){
                return private_encontrarpredecesor(n.izq,prede,dato);
            }else{
                prede=n;
                return private_encontrarpredecesor(n.der,prede,dato);//En caso de que el valor que buscamos es mayor que nuestro nodo, buscamos el prede de la derecaha
            }
            return prede; 
    }
    private NodoBST valorminimo(NodoBST n){//Simplemente un recorrido de la parte izq de un subarbol
        NodoBST aux=n;
        while (aux.izq!=null){
            aux=aux.izq;
        }
        return aux;
    }
    private NodoBST valormaximo(NodoBST n){//Recorrido de la parte derecha de un subarbol
        while(n.der!=null){
            n=n.getder();
        }
        return n;
    }
    //Agregar recursivo
   private NodoBST priv_agregar (NodoBST n_actual, T dato)
   {
      if ( n_actual == null )
         return ( new NodoBST(dato) );
      
     int comparacion = dato.compareTo (n_actual.dato);
	 
	 if ( comparacion < 0 ) 
	 	n_actual.izq = priv_agregar(n_actual.izq,dato);
	 else
		n_actual.der = priv_agregar(n_actual.der,dato);
		 
	 return n_actual;
	 
   }
   //Agregar Iterativo
    private void priv_agregar_iterativo(T v){//Para agregar tambien usamos un metodo iterativo
        NodoBST nuevo=new NodoBST(v);
        if (raiz==null){//en caso de que la raiz este vacia añadimos directamente
            raiz=nuevo;
            return;
        }
        NodoBST anterior=null;// nos servira en el momento de asignar si es hijo izq o der del padre
        NodoBST actual=raiz;
        //ciclo donde encontramos el lugar donde tiene que ubicarse el nodo
        while (actual!=null){
            if (actual.dato.compareTo(v)>0){
                anterior=actual;
                actual=actual.izq;
            }else if(actual.dato.compareTo(v)<0){
                anterior=actual;
                actual=actual.der;
            }
        }
        if (anterior.dato.compareTo(v)>0){
            anterior.izq=nuevo;
        }else{
            anterior.der=nuevo;
        }   
    }
    //Eliminar iterativo
   /* Imprime en in-orden */
   private void priv_imprimir (NodoBST n_actual)
   {
      if ( n_actual != null )
      {
         priv_imprimir (n_actual.izq);
         System.out.print (n_actual.dato + " ");
         priv_imprimir (n_actual.der);
      }
   }
    public int conthojas(){
        return private_conthojas(raiz);
    }
   private int private_conthojas(NodoBST aux){
       int cantidad=0;
        if (aux.izq==null && aux.izq==null){
           cantidad=1;
        }else{
            if (aux.izq!=null){
                cantidad=cantidad+private_conthojas(aux.izq);
            }
            if (aux.der!=null){
                cantidad=cantidad+private_conthojas(aux.der);
            }
        }
        return cantidad;
   }

   private NodoBST priv_buscar (NodoBST n_actual, T dato)
   {
        if ( n_actual == null )      // dato no se encuentra en el arbol
           return null;

       int comparacion = dato.compareTo (n_actual.dato);

           if ( comparacion == 0 )      // dato == n_actual.dato 
             return n_actual;
           else if ( comparacion < 0 )  // dato < n_actual.dato, puede estar a la izquierda
             return priv_buscar(n_actual.izq,dato);
       else	                      // dato > n_actual.dato, puede estar a la derecha
             return priv_buscar(n_actual.der,dato);
	      
   }
   
   public int lci ()  {
	    return lci(raiz,0);
   }
   
   private int lci ( NodoBST nodo, int nivel) {
	 if ( nodo == null ) 
	return 0;
        else 
	  return nivel + lci(nodo.izq, nivel+1) + lci (nodo.der, nivel+1);
   }
   
}

