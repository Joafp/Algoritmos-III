public class EjercicioII {
    public static void main(String [] args){
        Integer vector[]={1,2};
        quicksort<Integer> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector, 0, vector.length-1);
        Remover<Integer> VectorSinduplicados= new Remover<>();
        int tam=VectorSinduplicados.remo(vector);
        for (int i=0;i<tam;i++){
            System.out.println(vector[i]);
        }
    }
}
