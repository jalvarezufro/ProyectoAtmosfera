package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {

    private String sector;
    private Date fecha;
    private double mp10;
    private double mp25;

    public Registro(String sector, String fecha, String hora, double mp10, double mp25) throws ParseException {
        this.fecha = new SimpleDateFormat("dd/MM/yyyy HH").parse(fecha+" "+hora);
        this.sector = sector;
        this.mp10 = mp10;
        this.mp25 = mp25;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getFecha() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora(){
        return new SimpleDateFormat("HH").format(this.fecha);
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

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
        return "Sector = "+this.sector+", Fecha = "+df.format(this.fecha)+", mp10= "+this.mp10 +", mp2.5= "+mp25+"\n";
    }
}