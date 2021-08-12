public class BST<Key extends Comparable,T>
{
    private class NodoBST { 
        Key llave = null;
        T dato=null;
        NodoBST izq = null;
        NodoBST der = null;
        public NodoBST (Key llave,T dato)
        {
            this.dato = dato;
            this.llave=llave;
     
        }
    }
   
   private NodoBST raiz = null;


   /* Agregar un dato al arbol */ 
   public void agregar (Key llave,T dato)
   {
      raiz = priv_agregar (raiz,llave,dato);
   }

   /*
    * Retorna el "nodo" donde se encuentra el primer dato
    * que dice ser igual a parametro dado.
    * La comparacion se realiza via "compareTo()" de la interfaz Comparable.
    */
   public T buscar (Key llave)
   {
        NodoBST nodo = priv_buscar(raiz,llave);
            if ( nodo != null ) 
	     return nodo.dato;
            else { /* Reemplazar por manejo de excepcion!! */
                System.out.println("No existe en el arbol!!! " + llave);
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


   private NodoBST priv_agregar (NodoBST n_actual, Key llave,T dato)
   {
      if ( n_actual == null )
         return ( new NodoBST(llave,dato) );

     int comparacion = llave.compareTo (n_actual.llave);
	 
	 if ( comparacion < 0 ) 
	 	n_actual.izq = priv_agregar(n_actual.izq,llave,dato);
	 else
		n_actual.der = priv_agregar(n_actual.der,llave,dato);
		 
	 return n_actual;
	 
   }


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


   private NodoBST priv_buscar (NodoBST n_actual,Key llave)
   {
        if ( n_actual == null )      // dato no se encuentra en el arbol
         return null;
        int comparacion = llave.compareTo (n_actual.dato);
	 if ( comparacion == 0 )      // dato == n_actual.dato 
	   return n_actual;
	 else if ( comparacion < 0 )  // dato < n_actual.dato, puede estar a la izquierda
	   return priv_buscar(n_actual.izq,llave);
        else	                      // dato > n_actual.dato, puede estar a la derecha
	   return priv_buscar(n_actual.der,llave);     
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
   
   /*
     Un ejemplo de uso sencillo de uso de la clase BST
   */   
 
}
