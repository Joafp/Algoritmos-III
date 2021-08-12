
public class Ejercicio1_U3 {
    public static void main(String [] args){
        BST<String> t = new BST<>();
        String [] A = { "hola", "amor", "roma", "barco", "mesa", "musica", "zapato", "amigo"};
        for ( int k=0; k < A.length; k++ )
            t.agregar( A[k]);
        t.imprimir();
        String k = t.buscar("zapato");
        System.out.println();
        for (String s:t){
            System.out.printf("%s ",s);
        }
        if ( k != null )
            System.out.println("\nSi existe!! " + k);
        else
            System.out.println("No existe!!");
        Iterable<String> aux=t.iteratorClaves("barco", "mesa");
        for (String s:aux){
            System.out.printf("%s ", s);
        }
    }
}
