package proyecto.atmosfera.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;
import java.util.ArrayList;

@RestController
public class ControladorPeticion {

    /**
     * Método que se encarga de recibir la peticipón y cumplirla, generando el grupo de datos necesarios para hacer un nuevo heatmap.
     * @param fecha - String con la peticion de fecha
     * @param sector - String con la petición del sector
     * @return  ArrayList con los datos pedidos.
     */
    @RequestMapping(value= "/obtenerFechaInicio", method = RequestMethod.GET)
    public ArrayList<Registro> enviarDatos(@RequestParam(name = "fechaInicio", required = true) String fecha,@RequestParam(name = "sector", required = true) String sector) {
        ManejoDato manejoDato = new ManejoDato();
        ControlRegistro controlRegistro = new ControlRegistro();
        ArrayList<Registro> registros = manejoDato.leerArchivo("src/archivos/Historial_SmartCity_2019.csv");
        ArrayList<Registro> datosFinales = controlRegistro.escogerMetodo(fecha,registros,sector);
        return datosFinales;
    }

}
