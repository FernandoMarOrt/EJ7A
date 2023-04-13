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

        listaString.forEach(System.out::println);

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
                tokens = linea.split(":");

                listaString.add(tokens[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaString;
    }

    public static Map<String, Integer> mapAPartirLista(List<String> l) {

        Map<String, Integer> aux = new HashMap<>();

        int repeticionN = 0;
        int repeticionS = 0;
        int repeticionE = 0;
        int repeticionO = 0;

        for (int i = 0; i < l.size(); i++) {

            if (l.get(i).equals("N")) {

                repeticionN++;

            }

            if (l.get(i).equals("S")) {

                repeticionS++;

            }

            if (l.get(i).equals("E")) {

                repeticionE++;

            }

            if (l.get(i).equals("O")) {

                repeticionO++;

            }

        }

        aux.put("N", repeticionN);
        aux.put("S", repeticionS);
        aux.put("E", repeticionE);
        aux.put("O", repeticionO);

        return aux;

    }

}
