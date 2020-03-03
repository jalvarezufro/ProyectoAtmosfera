package proyecto.atmosfera.manejoArchivos;

import proyecto.atmosfera.modelo.Registro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManejoDato {

    /**
     * Método que lee la base de datos principal del proyecto (.csv)
     * @param ruta - String con la ruta donde se encuentra el erchivo dentro del programa.
     * @return ArrayList con todos los datos leidos en el .csv
     */
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

    /**
     * Método que crea un registro usando una linea del archivo .csv
     * @param linea - String con los datos separados por comas que contiene todo lo necesario para la creacion de un registro.
     * @return Regristro creado.
     */
    private Registro crearRegistro(String linea){
        String datos[] = linea.split(",");
        return new Registro(datos[0], LocalDate.parse(datos[1],DateTimeFormatter.ofPattern("dd/MM/yyyy")),datos[2],Double.parseDouble(datos[3]),Double.parseDouble(datos[4]));
    }
}
