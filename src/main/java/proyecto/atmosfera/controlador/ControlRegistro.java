package proyecto.atmosfera.controlador;

import proyecto.atmosfera.modelo.Registro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

}
