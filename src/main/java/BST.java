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


   /* Agregar un dato al arbol */ 
   public void agregar (T dato)
   {
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
            else { /* Reemplazar por manejo de excepcion!! */
                    System.out.println("No existe en el arbol!!! " + dato);
            return null;	  
            }	 
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
        if (raiz.dato.compareTo(dato)==0){
            System.out.println("Se elimino la raiz");
            raiz=null;
            return;
        }
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
        if (actual==null){
            System.out.println("No se encuentra lo que se quiere eliminar");
            return;
        }else{
            if (actual.izq==null && actual.der==null){
                if (anterior.izq==actual){
                    anterior.izq=null;
                }else{
                    anterior.der=null;
                }
                actual=null;
            }else if (actual.izq!=null && actual.der==null){
                if (anterior.izq==actual){
                    anterior.izq=actual.getizq();
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
                NodoBST sucesor=null;
                NodoBST padresucesor=null;
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
                if (actual.izq!=null && sucesor!=actual.izq){
                    sucesor.izq=actual.izq;
                }
                if (actual.der!=null&&  sucesor!=actual.der){
                    sucesor.der=actual.der;
                }
                if (sucesor.der==null){
                    if (anterior.izq==actual){
                        anterior.izq=sucesor;
                    }else{
                        anterior.der=sucesor;
                    }
                }else{
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
                }
            }
        }
        
   }
   //encontrar el sucesor
    public NodoBST encontrarsucesor(NodoBST n){
        NodoBST aux=raiz;
        if (n.der!=null){
           return valorminimo(n.der); 
        }
        NodoBST sucesor=null;
        while (aux!=null){
            if (n.dato.compareTo(aux.dato)<0){
                sucesor=aux;
                aux=aux.getizq();
            }else if(n.dato.compareTo(aux.dato)>0){
                aux=aux.getder();
            }else{
                break;
            }
        }
       return sucesor;
    }
    private NodoBST valorminimo(NodoBST n){
        NodoBST aux=n;
        while (aux.izq!=null){
            aux=aux.izq;
        }
        return aux;
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

