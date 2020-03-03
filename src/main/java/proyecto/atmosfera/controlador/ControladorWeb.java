package proyecto.atmosfera.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
@RequestMapping()
public class ControladorWeb {

    /**
     * Inicializador de la página de bienvenida del proyecto.
     * @param model - Clase requerida por SpringBoot.
     * @return Template de la página (.html)
     */
    @RequestMapping("")
    public String index(Model model){
        return "PaginaBienvenidaBootstrap";
    }

    /**
     * Inicializa la página del heatmap, leyendo los archivos de la base de datos y seleccionando un dato por defecto en el proceso.
     * @param model - Clase requerida por SpringBoot.
     * @return Template de la página (.html)
     */
    @RequestMapping("/PaginaGraficoBootstrap")
    public String heatmap(Model model) {
        ManejoDato manejoDato = new ManejoDato();
        ControlRegistro controlRegistro = new ControlRegistro();
        ArrayList<Registro> registros = manejoDato.leerArchivo("src/archivos/Historial_SmartCity_2019.csv");
        ArrayList<Registro> datosFinales = controlRegistro.binarySearch(LocalDate.parse("01/06/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")),registros);
        datosFinales = controlRegistro.sectorAverage(datosFinales);
        model.addAttribute("datosRegistros",datosFinales);
        return "PaginaGraficoBootstrap";
    }
}
