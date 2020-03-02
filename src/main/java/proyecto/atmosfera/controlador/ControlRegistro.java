package proyecto.atmosfera.controlador;

import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class ControlRegistro {

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

    public ArrayList<Registro> sectorAverage(ArrayList<Registro> list) {
        ArrayList<Registro> finalData = new ArrayList<>();  //Array list que será entregado.
        Registro base = list.get(0);    //Creo una referencia a la base de la fecha y hora a promediar.
        int count = 0;  //Contador de cuantas horas y fechas coinciden.
        double mp10Sum = 0, mp25Sum = 0;    //Acumuladores de las sumas.
        for (Registro i : list) {   //Bucle que recorre el arraylist
            if(i.getFecha().equals(base.getFecha()) && i.getHora().equalsIgnoreCase(base.getHora())){   //Comparacion del registro con la base
                mp10Sum = mp10Sum + i.getMp10();    //Suma de mps
                mp25Sum = mp25Sum + i.getMp25();
                count++;    //Aumento del contador.
            } else {    //Al encontrarse un dato distinto a la base.
                mp10Sum = mp10Sum/count;    //Calcula el promedio con la suma y la veces.
                mp25Sum = mp25Sum/count;
                finalData.add(new Registro("Todos los sectores", base.getFecha(), base.getHora(), mp10Sum, mp25Sum)); //Crea un registro en final data con el promedio.
                base = i;   //Cambia la base a el nuevo dato a comparar.
                mp10Sum= base.getMp10();    //Comienza la suma siguiente
                mp25Sum = base.getMp25();
                count = 1;  //Reinicia el contador.
            }
        }
        mp10Sum = mp10Sum/count;    //Calcula el promedio del útimo grupo
        mp25Sum = mp25Sum/count;
        finalData.add(new Registro("Todos los sectores", base.getFecha(), base.getHora(), mp10Sum, mp25Sum)); //Crea el último registro de finalData.
        return finalData;
    }

    public ArrayList<Registro> searchBySector( ArrayList<Registro> list, String sector) {

        ArrayList<Registro> datosFinales = new ArrayList<>();
        for(int i =0; i<list.size()-1; i++){
            if(list.get(i).getSector().trim().equals(sector)){
                datosFinales.add(list.get(i));
            }
        }
        return datosFinales;
    }

    public ArrayList<Registro> escogerMetodo(String fechaInicio, ArrayList<Registro> list,String sector) {
        ArrayList<Registro> datosFinales = new ArrayList<>();
        if(sector.trim().equals("todos los sectores")) {
            datosFinales = binarySearch(LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy")), datosFinales);
            datosFinales = sectorAverage(datosFinales);

        }else{
            datosFinales = searchBySector(list, sector);
            datosFinales = binarySearch(LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy")), datosFinales);


        }



    return datosFinales;
    }
}
