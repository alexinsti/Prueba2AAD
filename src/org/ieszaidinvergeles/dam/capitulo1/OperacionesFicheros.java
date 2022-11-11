
package org.ieszaidinvergeles.dam.capitulo1;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;


public class OperacionesFicheros {

    /**
     * Crea 10 ficheros en cada carpeta del proyecto. Utiliza para generar los
     * nombres aleatorios el método Utils.generateRandomFileName(7) dónde 7 es
     * la longitud del fichero
     *
     * @param ruta
     */
    public static void crearFicherosProyecto(String ruta) {


    }

    /**
     * Mueve los ficheros de la carpeta origen, que cumplan el/los criterio/s, 
     * a la carpeta destino
     * @param origen carpeta de origen 
     * @param destino carpeta de destino
     * @param criterio condiciones a cumplir por los ficheros 
     */
    public static void moverArchivos(String origen, String destino, Predicate<Path> criterio) {


    }
    
    /**
     * Busca carpetas y ficheros en ruta, de forma recursiva, que cumplan con 
     * las condiciones de criterio
     * @param ruta directorio raíz desde comienza la búsqueda recursiva
     * @param criterio condiciones que deben cumplir los directorios o ficheros
     * @return Lista de rutas 
     */
    public static List<Path> buscar(String ruta, Predicate<Path> criterio){
        return null; //Cambiar esta línea de código
    }
}
