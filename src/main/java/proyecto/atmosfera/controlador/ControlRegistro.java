package proyecto.atmosfera.controlador;

import proyecto.atmosfera.modelo.Registro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ControlRegistro {

    public ArrayList<Registro> binarySearch(String fechaInicio, ArrayList<Registro> list){
        ArrayList<Registro> datosFinales = new ArrayList<>();
        int low = 0;
        int high=list.size()-1;
        int mid;
        while(low<=high){
            mid= low + high / 2;
            if(list.get(mid).getFecha().compareTo(fechaInicio)<0){
                high = mid - 1;
            }else if(list.get(mid).getFecha().compareTo(fechaInicio)>0){
                low = mid + 1;
            }else{
                while(list.get(mid-1).getFecha().equals(fechaInicio)){
                    mid--;
                }
                int count=0;
                while(count<7){
                    if(!list.get(mid).getFecha().equals(list.get(mid).getFecha())){
                        count++;
                    }
                    mid++;
                    datosFinales.add(list.get(mid));
                    return datosFinales;
                }
            }
        }
        return null;
    }

}
