package org.ieszaidinvergeles.dam.capitulo1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesFicheros {

    /**
     * Crea 10 ficheros en cada carpeta del proyecto. Utiliza para generar los
     * nombres aleatorios el método Utils.generateRandomFileName(7) dónde 7 es
     * la longitud del fichero
     *
     * @param ruta
     */
    public static void crearFicherosProyecto(String ruta) {
        /*Path rootPath = Paths.get(ruta);
        
        try {
          Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Boolean contieneDirectorios=false;
                //recorro lo que contiene y compruebo si no tiene más directorios
                for(int i=0; i<file.getNameCount();i++){
                    if((Boolean)Files.getAttribute(file.getName(i), "isDirectory", LinkOption.NOFOLLOW_LINKS)){
                        contieneDirectorios=true;
                        break;
                    }
                }
                if(!contieneDirectorios){
                    for(int i=0; i<10; i++){
                        Path rutaAuxiliar= Paths.get(ruta, Utils.generateRandomFileName(7));
                        Files.createFile(rutaAuxiliar);
                    }
                }else{
                    
                }
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
          //e.printStackTrace();
        }*/
        
        String [] rutas = new String[]{"private/data", "private/invoces", "public/textos", "public/html/images", "public/html/pages", "public/html/web"};
        
        Path rootPath = Paths.get(ruta);
        
        for(String r : rutas){

            try {
                for(int i = 0; i<10; i++){
                    String nombre=Utils.generateRandomFileName(7);
                    Path rutaACrear= Paths.get(rootPath+"/"+r+"/"+nombre );
                    Files.createFile(rutaACrear);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(OperacionesFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*
        for (int i = 0; i < 10; i++) {
            try {
                Path data = Paths.get(ruta, "private", "data", Utils.generateRandomFileName(7));
                Path invoces = Paths.get(ruta, "private", "invoces", Utils.generateRandomFileName(7));
                Path textos = Paths.get(ruta, "public", "textos", Utils.generateRandomFileName(7));
                Path images = Paths.get(ruta, "public", "html", "images", Utils.generateRandomFileName(7));
                Path pages = Paths.get(ruta, "public", "html", "pages", Utils.generateRandomFileName(7));
                Path web = Paths.get(ruta, "public", "html", "web", Utils.generateRandomFileName(7));
                
                
                Files.createFile(data);
                Files.createFile(invoces);
                Files.createFile(textos);
                Files.createFile(images);
                Files.createFile(pages);
                Files.createFile(web);
            } catch (IOException ex) {
                System.err.println("Error: "+ex.getMessage());
            }
        }*/
        
    }

    /**
     * Mueve los ficheros de la carpeta origen, que cumplan el/los criterio/s, a
     * la carpeta destino
     *
     * @param origen carpeta de origen
     * @param destino carpeta de destino
     * @param criterio condiciones a cumplir por los ficheros
     */
    public static void moverArchivos(String origen, String destino, Predicate<Path> criterio) {
        /*Path sourcePath = Paths.get(origen);
        Path destinationPath = Paths.get(destino);
        
        try {
          Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if(criterio.test(file)){
                    Files.move(file, destinationPath,StandardCopyOption.REPLACE_EXISTING);
                }else{
                    
                }
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
          //e.printStackTrace();
        }*/
        Path rutaOrigen = Paths.get(origen);
        
        try {
            Files.walkFileTree(rutaOrigen, new FileVisitor(){
                @Override
                public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
                    if(criterio.test((Path)file)){
                        Path rutaNuevoArchivo= Paths.get(destino, ((Path)file).getFileName().toString());
                        Files.move((Path)file, rutaNuevoArchivo);
                    }
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
                
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(OperacionesFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Path directorioOrigen = Paths.get(origen);
        Path directorioDestino = Paths.get(destino);

        try {
          Files.walkFileTree(directorioOrigen, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              Path rutaObjetivoArchivo = Paths.get(destino, file.getFileName().toString());
              Files.move(file, rutaObjetivoArchivo);
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
          System.err.println("Error: "+e.getMessage());
        }
        */
        
    }

    /**
     * Busca carpetas y ficheros en ruta, de forma recursiva, que cumplan con
     * las condiciones de criterio
     *
     * @param ruta directorio raíz desde comienza la búsqueda recursiva
     * @param criterio condiciones que deben cumplir los directorios o ficheros
     * @return Lista de rutas
     */
    public static List<Path> buscar(String ruta, Predicate<Path> criterio) {
        Path rootPath = Paths.get(ruta);
        //String fileToFind = File.separator + "README.txt";
        List<Path> rutas = new ArrayList<Path>();

        
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    //String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if (criterio.test(file)) {
                        //System.out.println("file found at path: " + file.toAbsolutePath());
                        rutas.add(file);
                        return FileVisitResult.SKIP_SIBLINGS;//como no puede haber otro hermano con el mismo nombre los salto
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {

        }
        return rutas;
    }
}
