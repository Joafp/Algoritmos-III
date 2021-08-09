public class U3_Ejercicio2 {
    public static void main(String []args){
        Integer []aux={10,15,7,8,6,2,11,12};
        BST <Integer> v=new BST<Integer>();
        for (int k=0;k<aux.length;k++){
            v.agregar(aux[k]);
        }
        v.imprimirprofundidad(v.getraiz(), 0);
        
    }
}
