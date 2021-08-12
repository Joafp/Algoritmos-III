
package arbol;
//Autores Carlos Mateo Ayala Rumich
//Cesar Joaquin Delgado Díaz
public class principal {
    public static void main(String[] args) {
      //En los siguientes dos vectores guardamos las claves y los datos de nuestros nodos de prueba, a  cada posicion "k" del vector_clave le corresponde el dato de la posicion "k" del vector_dato 
      Integer vector_claves[]={12,25,1,45,4,5,6,7,78,8,2,10};
      String vector_datos[]={"hola","nose","que","poner","aguante","flamengo","gana","dos","a","cero","jaj","xd"};
      estructura<Integer,String> a1= new estructura<Integer,String>();
      for ( int k=0; k < vector_claves.length; k++ ){//En terminos de BIG O el t(n) de este for es O=n,lineal.La unica que no es constante en esta clase principal
         a1.insertar( vector_claves[k],vector_datos[k]);
        }
      try{
          String resultado=a1.buscar(50);
          System.out.println(" Se encontro la clave buscada el contenido es:  "+resultado);
        }
        catch(noEncontrado e){
           System.out.println("No se encontro la clave buscada");
        }
    
    }
    //Teniendo en cuenta todas las observaciones anteriores (las constantes las obvie ya que no influyen en el resultado) el coste asintotico en terminos de BIG O denuestro programa seria O=n; Lineal.
}
