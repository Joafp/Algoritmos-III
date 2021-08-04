//Joa x Margaret dasd
public class aleatorio  {
    public static void main(String args[]){
       Integer vector1[];
       int tamano,posicion,posicion2;
       tamano=50000;
       vector1= new Integer[tamano];
       int n=10000+(int)(Math.random()*1000000);
       System.out.println(n);
       cargar_vector(vector1);
       quicksort<Integer> VectorOrdenado= new quicksort<>();
       VectorOrdenado.qsort(vector1,0,vector1.length-1);
       posicion=binario(vector1,n);
       posicion2=lineal(vector1,n,0,vector1.length-1);
       System.out.println("Se encontro en " + posicion);
       System.out.println("Se encontro en " + posicion2);
    }
    public static void cargar_vector(Integer x[]){
        int c;
        for(c=0;c<x.length;c++){
            x[c]= 10000+(int)(Math.random()*1000000);
        }
    }
    public static <T extends Comparable<T>> int lineal(T x[],T numero,int inferior, int superior){
        long t1, t2;
        t1 = System.currentTimeMillis();
        for (int i = inferior; i <= superior; i++) {
	    if (x[i].compareTo(numero) == 0){
                t2 = System.currentTimeMillis();
                System.out.println("Tiempo de busqueda lineal : " + (t2 - t1) + "ms");
                return i;
            }
	}
        t2 = System.currentTimeMillis();
        System.out.println("Tiempo de busqueda lineal : " + (t2 - t1) + "ms");
	return -1;
    }
    public static <T extends Comparable<T>> int binario(T x[],T numero){
        int ini=0;
        int fin=x.length-1;
        long t1, t2;
        t1 = System.nanoTime();
        while (ini<=fin){
            int medio=ini+(fin-ini)/2;
            if (x[medio].compareTo(numero)==0){
                t2 = System.nanoTime();
                System.out.println("Tiempo de busqueda binaria: " +(t2-t1)*Math.pow(10,-6) + " ms");
                return medio;
            }else{
                if (x[medio].compareTo(numero)<0){
                    ini=medio+1;
                }else{
                    fin=medio-1;
                }
            }
        }
        t2 = System.nanoTime();
        System.out.println("Tiempo de busqueda binaria: " + (t2-t1)*Math.pow(10,-6) + " ms");
        return -1;
    }
}


