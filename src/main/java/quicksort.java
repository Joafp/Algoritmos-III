public class quicksort <T extends Comparable<? super T>>{
    void qsort(T []vector,int ini,int fin){
        if (ini>=fin){
           return;
        }else{
            int centro=(ini+fin)/2;
            if (vector[centro].compareTo(vector[ini])<0){
               intercambiar(vector,ini,centro);
            }
            if (vector[fin].compareTo(vector[ini])<0){
                intercambiar(vector,ini,fin);
            }
            if (vector[fin].compareTo(vector[centro])<0){
                intercambiar(vector,centro,fin);
            }
            intercambiar(vector,centro,fin-1);
            T pivote=vector[fin-1];
            int pospivote=particion(vector,ini,fin,pivote);
            qsort(vector,ini,pospivote);
            qsort(vector,pospivote+1,fin);
        }
    }
    private int particion(T[] array, int startIndex, int endIndex,T pivotValue)
    {
        startIndex--;
        endIndex++;
        while (true)
        {
            do startIndex++; while (array[startIndex].compareTo(pivotValue) < 0) ;
            do endIndex--; while (array[endIndex].compareTo(pivotValue) > 0) ;
            if (startIndex >= endIndex) return endIndex;
            T temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
    void intercambiar(T []vector,int a,int b){
        T aux=vector[a];
        vector[a]=vector[b];
        vector[b]=aux;
    }
}