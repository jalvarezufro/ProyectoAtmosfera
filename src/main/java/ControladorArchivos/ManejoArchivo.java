package ControladorArchivos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JAVIER
 */
public class ManejoArchivo {

    public static String readFile(String fileName) {
        Path file = Paths.get(fileName);
        String data = "";
        try {
            data = new String(Files.readAllBytes(file));
        } catch (Exception e) {
            System.out.println("The file could not be read.");
        }
        return data;
    }

    //Metodo generico que captura un archivo de texto y lo sobreescribe con otro texto.
    public static void writeFile(String fileName, String data) {
        Path file = Paths.get(fileName);
        try {
            Files.write(file, data.getBytes());
        } catch (Exception e) {
            System.out.println("The file could not be written");
        }

    }

    public static String [] separarRegistros(String registroTotal){
        String [] registrosSeparados = registroTotal.split(",,");
        return registrosSeparados;
    }


}
