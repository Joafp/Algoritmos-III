//Integrantes Joaquin Delgado, Carlos Ayala
public class U3_Ejercicio6 {
    public static void main (String []arg){
        Integer [] v={21,10,71,15,13,16,71,28};
        BST<Integer> t=new BST<>();
        for (int i=0;i<v.length;i++){
            t.agregar(v[i]);
        }
        t.imprimir();
        System.out.println(t.conthojas());
        t.eliminar(15);
        t.imprimir();
        System.out.println(t.encontrarsucesor(t.getraiz(),null,10));
        
    }
}
