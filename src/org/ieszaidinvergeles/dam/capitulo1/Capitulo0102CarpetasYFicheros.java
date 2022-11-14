package org.ieszaidinvergeles.dam.capitulo1;


import java.util.Random;
import java.util.stream.Stream;

public class Capitulo0102CarpetasYFicheros {

    public static void main(String[] args) {
        /*
        <root>
            ├── private
            │	├─ data
            │	└─ invoces
            │
            └── public
                    ├─ textos
                    └─ html
                        ├─ images
                        ├─ pages
                        └─ web        
         */
        //Para probar el generador de nombres: 
//	Stream.iterate(0, n -> n + 1)
//                .limit(10)
//                .forEach(x -> 
//                    System.out.println(Utils.generateRandomFileName(x+2))
//                );

        String ruta = "MiProyecto";
        OperacionesCarpetas.crearDirectoriosProyecto(ruta);
        //OperacionesCarpetas.borrarDirectorio(ruta);
        //OperacionesCarpetas.moverDirectorio(ruta, "MiProyecto2");

//        OperacionesFicheros.crearFicherosProyecto(ruta);
        OperacionesFicheros.moverArchivos(ruta + "/private/data", ruta+"/public", 
                f -> f.getFileName().toString().startsWith("m"));

/*        OperacionesFicheros.buscar(ruta, fichero -> fichero.getFileName().toString().endsWith("pdf"))
                .stream()
                //.forEach(t -> {System.out.println(t.getFileName().toString());});
                .forEach(System.out::println);
*/        

    }

}
