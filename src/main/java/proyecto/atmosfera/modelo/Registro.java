package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Registro {

    public Registro() {

    }

    private String sector;

    public Registro(String sector, int dispositivo, String fecha, String hora, double mp10, double mp25) {
        this.sector = sector;
        this.dispositivo = dispositivo;
        this.fecha = fecha;
        this.hora = hora;
        this.mp10 = mp10;
        this.mp25 = mp25;
    }

    private int dispositivo;
    private String fecha;
    private String hora;
    private double mp10;
    private double mp25;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
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

    public void setHora(String hora) {
        this.hora = hora;
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

    public String[][] contarValor(double limite, ArrayList<Registro> lista, String date, String mp) {
        int[]temporal =new int[24];
        String[][] contador = new String[24][2];
        for (int i = 0; i < 24; i++) {
            int next=i+1;
            contador[i][0]=i+":00 - "+ next +":00";

        }
        date = date.replace("/", "-");
        if (mp.equals("MP10")) {

            for (int i = 0; i < lista.size(); i++) {

                if (date.equals(lista.get(i).getFecha())) {

                    if (lista.get(i).getMp10() > limite) {

                        String[] temp = lista.get(i).getHora().split(":");
                        int horaTemp = Integer.parseInt(temp[0]);
                        temporal[horaTemp] = temporal[horaTemp]+1;

                    }
                }
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (date.equals(lista.get(i).fecha)) {
                    if (lista.get(i).getMp25() > limite) {
                        String[] temp = lista.get(i).hora.split(":");
                        int horaTemp = Integer.parseInt(temp[0]);
                        temporal[horaTemp] = temporal[horaTemp]+1;
                    }
                }
            }
        }
        for(int i=0;i<24;i++){
            contador[i][1]= String.valueOf(temporal[i]);
        }
        return contador;
    }

    @Override
    public String
    toString() {
        return "Registro: " + "sector= " + sector + ", dispositivo= " + dispositivo + ", fecha= " + fecha + ", hora= " + hora + ", mp10= " + mp10 + ", mp25= " + mp25 + "\n";
    }
}