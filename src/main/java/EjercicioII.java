import  javax.swing.JOptionPane;
public class EjercicioII {
    public static void main(String [] args){
       // Integer vector1[]={1,2,4,5,6,1,1,4,6,10,12,5,6,12};/*resultado esperado /*{1,2,4,5,6,10,12}*/  //Casos de prueba
        //Integer vector2[]={14,4,45,4,5,54,2,12,45,57,78,45,54,4,5,2,1,1,45};/*resultado esperado{1,2,4,5,12,14,45,54,57,78}*/
       
        String a1;
        int n;
        Integer vector[];
        a1=JOptionPane.showInputDialog("Introduzca la cantidad de numeros que desea tener");//Pedimos al usuario que ingrese la cantidad de elementos que desea tener en el vector
        n=Integer.parseInt(a1);//Lo convertimos a entero
        vector=new Integer[n];//Dimensionamos nuestro vector
        cargar_vector(vector);//cargamos el vector con numeros aleatorios
        imprimir_vector(vector);//Mostramos en pantalla el vector generado;
        quicksort<Integer> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector, 0, vector.length-1);//Llamamos al metodo qsort de quicksort para realizar el ordenamiento del vector
        System.out.print("\n");
        imprimir_vector(vector);
         System.out.print("\n");
        Remover<Integer> VectorSinduplicados= new Remover<>();
        int tam=VectorSinduplicados.remo(vector);//Llamaos al metodo remo de la clase remover para eliminar los duplicados
        for (int i=0;i<tam;i++){
            System.out.println(vector[i]);
        }
        
        //En caso de descomentar el vector1, eliminar /* y */
        /*
        quicksort<Integer> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector1, 0, vector1.length-1);//Llamamos al metodo qsort de quicksort para realizar el ordenamiento del vector
        Remover<Integer> VectorSinduplicados= new Remover<>();
        int tam=VectorSinduplicados.remo(vector1);//Llamaos al metodo remo de la clase remover para eliminar los duplicados
        for (int i=0;i<tam;i++){
            System.out.println(vector1[i]);
        }
        */
        //En caso de descomentar el vector2, eliminar /* y */
        /*
        quicksort<Integer> VectorOrdenado= new quicksort<>();
        VectorOrdenado.qsort(vector2, 0, vector2.length-1);//Llamamos al metodo qsort de quicksort para realizar el ordenamiento del vector
        Remover<Integer> VectorSinduplicados= new Remover<>();
        int tam=VectorSinduplicados.remo(vector2);//Llamaos al metodo remo de la clase remover para eliminar los duplicados
        for (int i=0;i<tam;i++){
            System.out.println(vector2[i]);
        }
        */
    }
    
    public static void cargar_vector(Integer x[]){//En este metodo cargamos los numeros en nuestro vector
        int c;
        for(c=0;c<x.length;c++){
            x[c]= 1+(int)(Math.random()*9);
        }
    }
    public static void imprimir_vector(Integer x[]){//aEn este metodo mostramos en pantalla el vector generado 
        int c;
        for(c=0;c<x.length;c++){
            System.out.print(x[c]+ "\t");
        }
    }
    
}
