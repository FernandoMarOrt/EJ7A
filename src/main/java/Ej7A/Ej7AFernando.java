/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Ej7A;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Ej7AFernando {

    public static void main(String[] args) {

        List<String> listaString = sacarListaFichero("localizaciones.txt");
        Map<String, String> listaMap = mapLista(listaString);

        System.out.println("Fichero Original");
        ServiciosFicheros.leerFichero("localizaciones.txt");

        System.out.println("Primera lista:");
        listaString.forEach(System.out::println);

        System.out.println("");
        System.out.println("MAP:");
        System.out.println(listaMap.toString());
        System.out.println("");

        ServiciosFicheros.generarFichero("contadorLocalizaciones.txt", listaMap);
        ServiciosFicheros.leerFichero("contadorLocalizaciones.txt");
    

    }

    public static List<String> sacarListaFichero(String nomFichero) {

        List<String> listaString = new ArrayList<>();
        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(": ");

                listaString.add(tokens[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaString;
    }

    public static Map<String, String> mapLista(List<String> listaString) {

        Map<String, String> listaMap = new HashMap<>();

        //Contadores de N,S,E,O
        int contadorN = 0;
        int contadorS = 0;
        int contadorE = 0;
        int contadorO = 0;

        for (int i = 0; i < listaString.size(); i++) {

            //Si en la lista coincide alguno de los caracteres suma 1 al contador
            if (listaString.get(i).equals("N")) {

                contadorN++;

            } else if (listaString.get(i).equals("S")) {

                contadorS++;

            } else if (listaString.get(i).equals("E")) {

                contadorE++;

            } else if (listaString.get(i).equals("O")) {

                contadorO++;

            }

        }

        String aux1 = String.valueOf(contadorN);
        String aux2 = String.valueOf(contadorS);
        String aux3 = String.valueOf(contadorE);
        String aux4 = String.valueOf(contadorO);

        listaMap.put("N", aux1);
        listaMap.put("S", aux2);
        listaMap.put("E", aux3);
        listaMap.put("O", aux4);

        return listaMap;

    }

}
