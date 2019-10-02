package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {

	public Registro(){

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

	@Override
	public String
	toString() {
		return "Registro: " + "sector= " + sector + ", dispositivo= " + dispositivo + ", fecha= " + fecha  + ", hora= " + hora +  ", mp10= " + mp10 + ", mp25= " + mp25 + "\n" ;
	}
}