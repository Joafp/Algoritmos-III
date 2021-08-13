public class U3_Ejercicio6 {
    public static void main (String []arg){
        String [] v={"Hola","Chau","Que tal","Todo bien","Alo","HEHE","Que"};
        BST<String> t=new BST<>();
        for (int i=0;i<v.length;i++){
            t.agregar(v[i]);
        }
        t.imprimir();
        System.out.println(t.conthojas());
        t.eliminar("Alo");
        t.imprimir();
        
    }
}
