/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Ej7A;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class PRUEBA {

    public static void main(String[] args) {
        
        List<String> listaString = sacarListaArchivo("localizaciones.txt");
        
        listaString.forEach(System.out::println);
        
        
        
    }
    
    public static List<String> sacarListaArchivo(String nomFichero) {
        List<String> listaString = new ArrayList<>();

        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                
                linea = datosFichero.nextLine();
               
                tokens = linea.split("[N][S][O][E]");
    

                listaString.add(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaString;
    }
    
}
