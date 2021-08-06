//Integrantes Cesar Joaquin Delgado Diaz,Carlos Mateo Ayala Rumich
public class aleatorio  {//Definimos nuestra clase aleatorio 
    public static void main(String args[]){//El main de nuestro programa
        Integer vector1[];
        Double Mbinario[][]=new Double[20][4];//Matriz para poder imprimir la tabla de tiempos con la busqueda binaria
        Double Mlineal[][]=new Double[20][4];//Matriz para poder imprimir la tabla de tiempos con la busqueda lineal
        int n,i,j=0;//Definicion de atributos de nuestra clase
        double Tbinario,Tlineal;
        for (i=50000;i<=1000000;i+=50000){//Empezamos un ciclo desde 50000 y vamos aumentando de a 50000 para representar los casos de cantidad de numeros que contiene nuestro vector requeridos en el problema
            vector1= new Integer[i];//Creamos nuestro vector que va a contener a i numeros
            cargar_vector(vector1);//Llamamos al metodo que se encarga de cargar numeros aleatorios dentro del rango requerido al vector
            quicksort<Integer> VectorOrdenado= new quicksort<>();//Creamos un objeto de tipo quicksort que nos ayudara en el ordenamiento de nuestro vector 
            VectorOrdenado.qsort(vector1,0,vector1.length-1);//Llamamos al metodo qsort de la clase quicksort que se encarga de ordenar nuestro vector, pasamos como parametros el vector a ser ordenado el 0 indicando la primera posicion y la dimension del vector disminuido en 1
            n=0+(int)(Math.random()*(i-1));//Generamos un numero random entre el rango 0-(i-1)
            Tbinario=binario(vector1,vector1[n]);//Llamamos al metodo binario de la clase aleatorio, esta se encarga de hacer la busqueda binaria del numero n creado anteriormente, dentro del vector1, nos devuelve el tiempo en que le costo encontrar al numero expresado en ns
            Tlineal=lineal(vector1,vector1[n],0,vector1.length-1);//Llamamos al metodo Lineal de la clase aleatorio, esta se encarga de hacer la busqueda lineal del numero n creado anteriormente, dentro del vector1, nos devuelve el tiempo en que le costo encontrar al numero expresado en ns
            cargar_valores(Mbinario,Tbinario,j);//Carga el valor del tiempo que le llevo a la busqueda binaria en una matriz para no perder el resultado
            cargar_valores(Mlineal,Tlineal,j);//Carga el valor del tiempo que le llevo a la busqueda lineal en una matriz para no perder el resultado
            j++;
        }
        //Impresion de la cabeza de la tabla
        System.out.printf("%5s %45s %50s\n","N","Busqueda Binaria","Busqueda lineal");
        System.out.printf("%33s| %5s| %13s| %5s","T(n) en ms","T/N","T/Nlog2(N)","T/N^2");
        System.out.printf("%33s| %5s| %13s| %5s\n","T(n) en ms","T/N","T/Nlog2(N)","T/N^2");
        int aux=50000;
        for (i=0;i<20;i++){
            System.out.printf("%5d %25f %10f %10f %10f",aux,Mbinario[i][0],Mbinario[i][1],Mbinario[i][2],Mbinario[i][3]);
            System.out.printf("%28f %10f %10f %10f\n",Mlineal[i][0],Mlineal[i][1],Mlineal[i][2],Mlineal[i][3]);
            aux+=50000;
        }
        
   //Metodos de nuestra clase aleatorio   
    }
    public static void cargar_valores(Double x[][],double dato,int j){//Metodo que se encarga de cargar los valores obtenidos del tiempo de busqueda
        int tam=x.length;
        x[j][0]=dato;//Cargamos el tiempo en ns
        x[j][1]=dato/tam;//Cargamos el tiempo expresado en T/N
        x[j][2]=dato/(tam*(Math.log(tam)/Math.log(2)));//Cargamos el tiempo expresado en T/(N (log en base 2 de N))
        x[j][3]=dato/(tam*tam);//Cargamos el tiempo expresado en T/N^2
    }
    
    public static void cargar_vector(Integer x[]){//Metodo que se encarga de cargar en el vector numeros aleatorios entre 10000-1000000
        int c;
        for(c=0;c<x.length;c++){
            x[c]= 10000+(int)(Math.random()*1000000);//Generacion del numero aleatorio 
        }
    }
    public static <T extends Comparable<T>> double lineal(T x[],T numero,int inferior, int superior){//Metodo que se encarga de la busqueda lineal, en este metodo heredamos de Comparable<T> para poder realizar las comparaciones entre objetos genericos 
        int bandera=0;
        double t1, t2;
        t1 = System.nanoTime();//Tiempo de inicio de metodo
        while (bandera==0){
            for (int i = inferior; i <= superior; i++) {
                if (x[i].compareTo(numero) == 0){
                    bandera=1;
                }
            }
        }
        t2 = System.nanoTime();//Tiempo de fin del metodo
        return (t2-t1)*Math.pow(10,-6);//Retornamos el tiempo que se demoro el metodo en encontrar el numero requerido
    }
    public static <T extends Comparable<T>> double binario(T x[],T numero){//Metodo encargado de realizr la busqueda binaria, de nuevo heredamos de Comparable<T> para poder utilizar las comparaciones entre objetos genericos
        int ini=0;//Iniciamos en la primera posicion del vector
        int fin=x.length-1;//Ultima posicion del vector
        long t1, t2;
        double aux;
        t1 = System.nanoTime();//Tiempo en el que inicia nuestro metodo
        while (ini<=fin){
            int medio=ini+(fin-ini)/2;//asignamos un medio para dividir nuestro vector en la mitad para agilizar la busqueda
            if (x[medio].compareTo(numero)==0){//Preguntamos si el numero es nuestro medio
                t2 = System.nanoTime();//Tiempo en el que encontro el numero
                aux=(t2-t1)*Math.pow(10,-6);//Calculamos el tiempo requerido para la busqueda
                return aux;//Retornamos el tiempo caluclado
            }else{
                if (x[medio].compareTo(numero)<0){//Si es menor seguimos la busqueda en la parte izquierda del vector
                    ini=medio+1;
                }else{//Si es mayor seguimos la busqueda en la parte derecha del vector
                    fin=medio-1;
                }
            }
        }
        return -1;//Si retorna -1 El numero no fue encontrado
    }
}


