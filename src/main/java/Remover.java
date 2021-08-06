/*Para poder encontrar los elementos repetidos de nuestro arreglo lo primero que hacemos es ordenarlo mediante un quicksort que tiene un tiempo de
O(nlogn), una vez ordenado el vector lo que conseguimos es que los elementos repetidos queden uno al lado del otro. Con el arreglo ordenado ahora podemos colocar los que no son repetidos
uno al lado del otro esto nos llevaria un tiempo de O(n), por lo que en total nuestro T(n)=O(nLog(n))+O(n), solo nos quedamos con el mayor por lo que al final nos quedaria que el tiempo es de 
T(n)=O(nLog(n)).
*/
public class Remover <T extends Comparable<? super T>>{
    int remo(T []vector){
        quicksort<T> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector, 0, vector.length-1);//O(nlog(n))
        int tam=vector.length;
        if (tam==1 || tam==0)
            return tam;
        T aux[]=vector;
        int j=0,i;
        for (i=0;i<tam-1;i++){//O(n)
            if (vector[i].compareTo(vector[i+1])!=0){
                aux[j++]=vector[i];
            }
        }
        aux[j++]=vector[tam-1];
        for (i=0;i<j;i++){//O(n)
            vector[i]=aux[i];
        }
        return j;     
        //sumando todo T(n)=O(nLog(n))+2O(n),que tomando el mayor es T(n)=O(nLog(n))
    }
}