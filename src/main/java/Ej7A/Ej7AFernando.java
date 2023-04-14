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

        List<String> listaString = pasarFicheroLista("localizaciones.txt");
        Map<String, String> listaMap = mapLista(listaString);

        System.out.println("Primera lista:");
        listaString.forEach(System.out::println);

        System.out.println("");
        System.out.println("MAP:");
        System.out.println(listaMap.toString());
        System.out.println("");

        ServiciosFicheros.generarFichero("contadorLocalizaciones.txt", listaMap);
        ServiciosFicheros.leerFichero("contadorLocalizaciones.txt");

    }

    public static List<String> pasarFicheroLista(String nomFichero) {

        List<String> listaString = new ArrayList<>();
        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                listaString.add(datosFichero.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaString;
    }

    public static List<String> filtrarLista(List<String> listaString) { //CAMBIAR ESTO 

        List<String> filtrarLista = new ArrayList<>();

        for (int i = 0; i < listaString.size(); i++) {

            filtrarLista.add(String.valueOf(listaString.get(i).charAt(5)));

        }

        return filtrarLista;
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
