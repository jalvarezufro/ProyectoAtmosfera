package proyecto.atmosfera.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LectorArchivo {

	private Path ruta;
	private final static String AMANECER = "/Amanecer";
	private final static String CENTRO = "/Centro";
	private final static String EL_CARMEN = "/El Carmen";
	private final static String LABRANZA = "/Labranza";
	private final static String PEDRO_VALDIVIA = "/Pedro de Valdivia";
	private final static String PONIENTE = "/Poniente";
	private final static String PUEBLO_NUEVO = "/Pueblo Nuevo";
	private final static String SANTA_ROSA = "/Santa Rosa";
	private final static String UNIVERSIDAD = "/Universidad";
	private final static String TEMUCO = "/Temuco";
	private final static String ABRIL = "/Abril.csv";
	private final static String AGOSTO = "/Agosto.csv";
	private final static String JULIO = "/Julio.csv";
	private final static String JUNIO = "/Junio.csv";
	private final static String MAYO = "/Mayo.csv";

	public Path getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = Paths.get(ruta);
	}

	public String[][] leerArchivo() throws IOException{
		String datos = new String(Files.readAllBytes(ruta));
		return separarDatos(datos);
	}

	/**
	 * Tomo un texto donde cada linea representa un  y la separa en los objetos que puede crear
	 * y en los atributos de cada registro.
	 * @param datos - Conjunto de atributos de registro.
	 */
	private String[][] separarDatos(String datos) {
		String[] registros = datos.split("\n");
		String[][] attriRegistros = new String[registros.length][4];
		for (int i = 0; i < registros.length; i++) {
			attriRegistros[i] = registros[i].split(",");
		}
		return attriRegistros;
	}

	public void selecMes() {
		// TODO - implement LectorArchivo.selecMes
		throw new UnsupportedOperationException();
	}

	public void selecDia() {
		// TODO - implement LectorArchivo.selecDia
		throw new UnsupportedOperationException();
	}

	public void selecSector() {
		// TODO - implement LectorArchivo.selecSector
		throw new UnsupportedOperationException();
	}

}