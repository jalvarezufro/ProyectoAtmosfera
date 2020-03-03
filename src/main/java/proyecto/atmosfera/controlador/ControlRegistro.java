package proyecto.atmosfera.controlador;

import proyecto.atmosfera.modelo.Registro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ControlRegistro {

    /**
     * Método de busqueda de tipo binaria que entrega el grupo de datos que cumplen con el lapso de tiempo designado.
     * @param fechaInicio - LocalDate con la fecha inicial del grupo.
     * @param list - Lista completa con los registros.
     * @return ArrayList de los registros que cumplen la descripción.
     */
    public ArrayList<Registro> binarySearch(LocalDate fechaInicio, ArrayList<Registro> list) {
        ArrayList<Registro> datosFinales = new ArrayList<>();
        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (list.get(mid).getFecha().compareTo(fechaInicio) > 0) {
                high = mid - 1;
            } else if (list.get(mid).getFecha().compareTo(fechaInicio) < 0) {
                low = mid + 1;
            } else {
                while ((mid > 0) && list.get(mid - 1).getFecha().equals(fechaInicio)) {
                    mid--;
                }
                int count = 0;
                while ((mid<list.size()-1)  && (count < 7)) { //para que entregue el arraylist semanal
                    if (!list.get(mid).getFecha().equals(list.get(mid+1).getFecha())) {
                        count++;
                    }
                    datosFinales.add(list.get(mid));
                    mid++;
                }
                return datosFinales;
            }
        }
        return null;
    }

    /**
     * Con un grupo de datos en un rango de tiempo calcula el promedio de todos los datos con la misma fecha y hora sin importar su sector.
     * @param list - ArrayList acotado en el lapso de tiempo establecido previamente.
     * @return ArrayList de los Promedios de los datos con similitud de hora y fecha.
     */
    public ArrayList<Registro> sectorAverage(ArrayList<Registro> list) {
        ArrayList<Registro> finalData = new ArrayList<>();
        Registro base = list.get(0);
        int count = 0;
        double mp10Sum = 0, mp25Sum = 0;
        for (Registro i : list) {
            if(i.getFecha().equals(base.getFecha()) && i.getHora().equalsIgnoreCase(base.getHora())){
                mp10Sum = mp10Sum + i.getMp10();
                mp25Sum = mp25Sum + i.getMp25();
                count++;
            } else {
                mp10Sum = mp10Sum/count;
                mp25Sum = mp25Sum/count;
                finalData.add(new Registro("Temuco", base.getFecha(), base.getHora().substring(0, base.getHora().length() -3), Math.floor(mp10Sum*100)/100, Math.floor(mp25Sum*100)/100));
                base = i;
                mp10Sum= base.getMp10();
                mp25Sum = base.getMp25();
                count = 1;
            }
        }
        mp10Sum = mp10Sum/count;
        mp25Sum = mp25Sum/count;
        finalData.add(new Registro("Temuco", base.getFecha(), base.getHora().substring(0, base.getHora().length() -3), Math.floor(mp10Sum*100)/100, Math.floor(mp25Sum*100)/100));
        return finalData;
    }

    /**
     * Agrupación de los datos de un
     * @param list - ArrayList acotado en el lapso de tiempo establecido previamente.
     * @param sector - String con el sector a separar.
     * @return ArrayList con los datos de un solo sector.
     */
    public ArrayList<Registro> searchBySector( ArrayList<Registro> list, String sector) {
        ArrayList<Registro> datosFinales = new ArrayList<>();
        for(int i =0; i<list.size()-1; i++){
            if(list.get(i).getSector().trim().equals(sector)){
                datosFinales.add(list.get(i));
            }
        }
        return datosFinales;
    }

    /**
     * Algoritmo encargado de seleccionar las busquedas a razón de los sectores y fechas.
     * @param fechaInicio - LocalDate con la fecha inicial del grupo.
     * @param list - Lista completa con los registros.
     * @param sector - String con el sector a separar.
     * @return ArrayList con los datos pedidos para hacer el heatmap.
     */
    public ArrayList<Registro> escogerMetodo(String fechaInicio, ArrayList<Registro> list,String sector) {
        ArrayList<Registro> datosFinales;
        if (sector.trim().equals("todos los sectores")) {
            datosFinales = binarySearch(LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy")), list);
            datosFinales = sectorAverage(datosFinales);
        } else {
            datosFinales = binarySearch(LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy")), list);
            datosFinales = searchBySector(datosFinales, sector);
        }
        return datosFinales;
    }
}
