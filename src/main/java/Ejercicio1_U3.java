public class Ejercicio1_U3 {
    public static void main(String [] args){
        BST<String> t = new BST<String>();
        String [] A = { "hola", "amor", "roma", "barco", "mesa", "musica", "zapato", "amigo"};
        for ( int k=0; k < A.length; k++ )
            t.agregar( A[k]);
        t.imprimir();
        String k = t.buscar("zapato");
        System.out.println();
        if ( k != null )
            System.out.println("Si existe!! " + k);
        else
            System.out.println("No existe!!");
    }
}
