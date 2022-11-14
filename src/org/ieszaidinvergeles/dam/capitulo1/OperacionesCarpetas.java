
package org.ieszaidinvergeles.dam.capitulo1;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;



public class OperacionesCarpetas {


    /**
     * Crea una estructura de carpetas para un proyecto
     *
     * @param ruta carpeta raíz del proyecto
     */
    public static void crearDirectoriosProyecto(String ruta) {
        Path path = Paths.get(ruta, "private", "data");
        Path path1 = Paths.get(ruta, "private", "invoces");
        Path path2 = Paths.get(ruta, "public", "textos");
        Path path3 = Paths.get(ruta, "public", "html", "images");
        Path path4 = Paths.get(ruta, "public", "html", "pages");
        Path path5 = Paths.get(ruta, "public", "html", "web");
        
        try {
            Files.createDirectories(path);
            Files.createDirectories(path1);
            Files.createDirectories(path2);
            Files.createDirectories(path3);
            Files.createDirectories(path4);
            Files.createDirectories(path5);
            
        } catch(FileAlreadyExistsException e){
            // the directory already exists.
        } catch (IOException e) {
            //algo ha salido mal
            //e.printStackTrace();
        }


    }

    /**
     * Cambia el nombre del directorio de origen por el de destino. 
     * Se debe comprobar si existen y permiten realizar esta operación. Imagina,
     * por ejemplo, el caso de que destino ya sea una carpeta. En este caso, 
     * se informa y no se hace nada. 
     * @param origen nombre del directorio a cambiar
     * @param destino nuevo nombre del directorio
     */
    public static void moverDirectorio(String origen, String destino) {
        Path sourcePath = Paths.get(origen);
        Path destinationPath = Paths.get(destino);

        try {
            if(Files.exists(destinationPath, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS})){
            }else{
                Files.move(sourcePath, destinationPath,StandardCopyOption.REPLACE_EXISTING);
            }
            
        } catch (IOException e) {
            //Si el método mover falla
            //e.printStackTrace();
        }


    }

    /**
     * Borra una directorio recursivamente, aunque tenga ficheros o carpetas
     *
     * @param ruta de la carpeta a borrar
     */
    public static void borrarDirectorio(String ruta) {
        Path rootPath = Paths.get(ruta);

        try {
          Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              Files.delete(file);
              return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
              Files.delete(dir);
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
          //e.printStackTrace();
        }

    }

}
