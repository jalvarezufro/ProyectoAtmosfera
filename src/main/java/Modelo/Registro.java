package Modelo;

/**
 *
 * @author JAVIER
 */
public class Registro {
    String sector;
    String dipositivo;
    String fecha;
    String hora;
    int mp10;
    int mp25;
    int humedad;
    int temp;

    public Registro(String sector, String dipositivo, String fecha, String hora, int mp10, int mp25, int humedad, int temp) {
        this.sector = sector;
        this.dipositivo = dipositivo;
        this.fecha = fecha;
        this.hora = hora;
        this.mp10 = mp10;
        this.mp25 = mp25;
        this.humedad = humedad;
        this.temp = temp;
    }

    public Registro(String sector, String dipositivo, String fecha, String hora, int mp10, int mp25) {
        this.sector = sector;
        this.dipositivo = dipositivo;
        this.fecha = fecha;
        this.hora = hora;
        this.mp10 = mp10;
        this.mp25 = mp25;
        this.humedad = -1;
        this.temp = -1;
    }



    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDipositivo() {
        return dipositivo;
    }

    public void setDipositivo(String dipositivo) {
        this.dipositivo = dipositivo;
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

    public int getMp10() {
        return mp10;
    }

    public void setMp10(int mp10) {
        this.mp10 = mp10;
    }

    public int getMp25() {
        return mp25;
    }

    public void setMp25(int mp25) {
        this.mp25 = mp25;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }





}
