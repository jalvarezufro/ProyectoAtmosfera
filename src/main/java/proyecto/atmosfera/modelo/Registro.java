package proyecto.atmosfera.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {

	private String sector;
	private Date fecha;
	private int mp10;
	private int mp25;
	private final String formato = "dd/MM/yy HH";

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Date getFecha() {
		return fecha;
	}

	/**
	 * Usando SimpleDateFormat transforma un string con el formato correcto a un clase date.
	 * @param f - Fecha en el formato "dd/MM/yy HH"
	 * @throws ParseException
	 */
	public void setFecha(String f) throws ParseException {
		fecha = new SimpleDateFormat(formato).parse(f);
	}

	public int getMp10() {
		return this.mp10;
	}

	public void setMp10(int mp10) {
		this.mp10 = mp10;
	}

	public int getMp25() {
		return this.mp25;
	}

	public void setMp25(int mp25) {
		this.mp25 = mp25;
	}

	/**
	 * Constructor de un objeto registro.
	 * @param s - String con el sector donde se tomo la muestra
	 * @param f - String con la fecha y hora de cuando se tomo la muestra, tiene el formato "dd/MM/yy HH"
	 * @param m1 - Entero con la cantidad de material particulado de 10x10^-6m.
	 * @param m2 - Entero con la cantidad de material particulado de 2.5x10^-6m.
	 */
	public Registro(String s, String f, int m1, int m2) throws ParseException {
		this.sector = s;
		this.fecha = new SimpleDateFormat(formato).parse(f);
		this.mp10 = m1;
		this.mp25 = m2;
	}

}