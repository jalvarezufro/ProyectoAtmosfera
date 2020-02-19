package proyecto.atmosfera.manejoArchivos;

import proyecto.atmosfera.modelo.Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManejoDato {

    public ArrayList<Registro> leerArchivo(String ruta) {
        ArrayList<Registro> registros = new ArrayList<Registro>();
        String linea = "";
        int numLineas = 0;
        try {
            FileReader fileReader = new FileReader(new File(ruta));
            BufferedReader buffer = new BufferedReader(fileReader);
            while ((linea = buffer.readLine()) != null) {
                numLineas++;
                if (numLineas > 1) {
                    registros.add(crearRegistro(linea));
                }
            }
            buffer.close();
            fileReader.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return registros;
    }

    /*
    private Registro crearRegistro(String linea) throws ParseException {
        String datos[] = linea.split(";");
        return new Registro(datos[0],datos[1],datos[2],Double.parseDouble(datos[3]),Double.parseDouble(datos[4]));
    }
    */

    private Registro crearRegistro(String linea) throws ParseException {
        String datos[] = linea.split(",");
        return new Registro(datos[0], datos[1],datos[2],Double.parseDouble(datos[3]),Double.parseDouble(datos[4]));
    }
}
