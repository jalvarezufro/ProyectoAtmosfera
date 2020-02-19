package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

    public Registro(String sector,String fecha, String hora, double mp10, double mp25) throws ParseException {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

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

    @Override
    public String
    toString() {
        return "Registro: " + "sector= " + sector + ", fecha= " + fecha + ", hora= " + hora + ", mp10= " + mp10 + ", mp25= " + mp25 + "\n";
    }

}