package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Registro {

    private String sector;
    private int dispositivo;
    private String fecha;
    private Date tiempo;
    private String hora;
    private double mp10;
    private double mp25;

    public Registro(String sector, int dispositivo,String fecha, String hora, double mp10, double mp25) throws ParseException {
        this.tiempo = new SimpleDateFormat("dd/MM/yyyy HH").parse(fecha+" "+hora);
        this.fecha = fecha;
        this.hora = hora;
        this.sector = sector;     //sector.substring(0,sector.length()-1); Elimina el espacio al final.
        this.mp10 = mp10;
        this.mp25 = mp25;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    /*
        public String getFecha() {
            return new SimpleDateFormat("dd/MM/yyyy").format(this.fecha);
        }
        */
    public String getFecha() {
        return fecha;
    }
    /*
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*
    public String getHora(){
        return new SimpleDateFormat("HH").format(this.fecha);
    }
    */
    public String getHora() {
        return hora;
    }

    public double getMp10() {
        return mp10;
    }

    public void setMp10(double mp10) {
        this.mp10 = mp10;
    }

    public double getMp25() {
        return mp25;
    }

    public void setMp25(double mp25) {
        this.mp25 = mp25;
    }

    public static ArrayList<Registro> buscarFecha(Date inicio, String sector, ArrayList<Registro> list, Date fin){
        fin = Registro.agregarDia(fin);
        ArrayList<Registro> temp = new ArrayList<>();
        int low = 0, high = list.size(), mid;
        while(low <= high){
            mid = (high+low)/2;
            if(list.get(mid).getTiempo().compareTo(inicio)>0){ //Parte inferior
                high = mid - 1;
            } else if (list.get(mid).getTiempo().compareTo(inicio)<0){ //Parte superior
                low = mid + 1;
            } else {
                while(list.get(mid-1).getTiempo().equals(inicio)){
                    mid--;
                }
                while(!list.get(mid).getTiempo().equals(fin)){
                    temp.add(list.get(mid));
                    mid++;
                }
                return Registro.buscarSector(temp, sector); //Comprobación de sector
            }
        }
        return null;
    }

    private static Date agregarDia(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,1);
        return c.getTime();
    }

    private static ArrayList<Registro> buscarSector (ArrayList<Registro> list, String sector){
        ArrayList<Registro> temp = new ArrayList<>();
        int i = 0;
        while (!list.get(i).getSector().equalsIgnoreCase(sector)){
            i++;
        }
        while(list.get(i).getSector().equalsIgnoreCase(sector)){
            temp.add(list.get(i));
            i++;
        }
        return temp;
    }

    /*
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
        return "Sector = "+this.sector+", Fecha = "+fecha+", hora:"+hora+", mp10= "+this.mp10 +", mp2.5= "+mp25+"\n";
    }
    */
    @Override
    public String
    toString() {
        return "Registro: " + "sector= " + sector + ", dispositivo= " + dispositivo + ", fecha= " + fecha + ", hora= " + hora + ", mp10= " + mp10 + ", mp25= " + mp25 + "\n";
    }

}