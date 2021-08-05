public class aleatorio  {
    public static void main(String args[]){
        Integer vector1[];
        Double Mbinario[][]=new Double[20][4];
        Double Mlineal[][]=new Double[20][4];
        int n,i,j=0;
        double Tbinario,Tlineal;
        for (i=50000;i<=1000000;i+=50000){
            vector1= new Integer[i];
            cargar_vector(vector1);
            quicksort<Integer> VectorOrdenado= new quicksort<>();
            VectorOrdenado.qsort(vector1,0,vector1.length-1);
            n=0+(int)(Math.random()*(i-1));
            Tbinario=binario(vector1,vector1[n]);
            Tlineal=lineal(vector1,vector1[n],0,vector1.length-1);
            cargar_valores(Mbinario,Tbinario,j);
            cargar_valores(Mlineal,Tlineal,j);
            j++;
        }
        System.out.printf("%5s %45s %50s\n","N","Busqueda Binaria","Busqueda lineal");
        System.out.printf("%33s| %5s| %13s| %5s","T(n) en ms","T/N","T/Nlog2(N)","T/N^2");
        System.out.printf("%33s| %5s| %13s| %5s\n","T(n) en ms","T/N","T/Nlog2(N)","T/N^2");
        int aux=50000;
        for (i=0;i<20;i++){
            System.out.printf("%5d %25f %10f %10f %10f",aux,Mbinario[i][0],Mbinario[i][1],Mbinario[i][2],Mbinario[i][3]);
            System.out.printf("%28f %10f %10f %10f\n",Mlineal[i][0],Mlineal[i][1],Mlineal[i][2],Mlineal[i][3]);
            aux+=50000;
        }
        
        
    }
    public static void cargar_valores(Double x[][],double dato,int j){
        int tam=x.length;
        x[j][0]=dato;
        x[j][1]=dato/tam;
        x[j][2]=dato/(tam*(Math.log(tam)/Math.log(2)));
        x[j][3]=dato/(tam*tam);
    }
    public static void cargar_vector(Integer x[]){
        int c;
        for(c=0;c<x.length;c++){
            x[c]= 1+(int)(Math.random()*10);
        }
    }
    public static <T extends Comparable<T>> double lineal(T x[],T numero,int inferior, int superior){
        long t1, t2;
        t1 = System.currentTimeMillis();
        for (int i = inferior; i <= superior; i++) {
	    if (x[i].compareTo(numero) == 0){
                t2 = System.currentTimeMillis();
                return (t2 - t1);
            }
	}
	return -1;
    }
    public static <T extends Comparable<T>> double binario(T x[],T numero){
        int ini=0;
        int fin=x.length-1;
        long t1, t2;
        double aux;
        t1 = System.nanoTime();
        while (ini<=fin){
            int medio=ini+(fin-ini)/2;
            if (x[medio].compareTo(numero)==0){
                t2 = System.nanoTime();
                aux=(t2-t1)*Math.pow(10,-6);
                return aux;
            }else{
                if (x[medio].compareTo(numero)<0){
                    ini=medio+1;
                }else{
                    fin=medio-1;
                }
            }
        }
        return -1;
    }
}


