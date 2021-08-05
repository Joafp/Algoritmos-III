public class Remover <T extends Comparable<? super T>>{
    int remo(T []vector){
        quicksort<T> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector, 0, vector.length-1);
        int i=0,j=0;
        while (i<vector.length-1){
            vector[j]=vector[i];
            while (vector[i].compareTo(vector[i+1])==0){
                i+=1;
            }
            i+=1;
            j+=1;
        }
        return j;
    }
}