
public class U3_Ejercicio3 {
   public static void main ( String [] args ) {
      BST <Integer,String>t = new BST<>();
	  String [] aux={"amor","hola","quetal"};
	  for ( int k=0; k < aux.length; k++ )
	    t.agregar( k,aux[k]);
            t.imprimir();	  
   }   
}
