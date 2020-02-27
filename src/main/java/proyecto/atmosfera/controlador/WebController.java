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
public class WebController {

    /*@RequestMapping("")
    public String index(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        String [][] arraymirar = ListaRegistros.get(1).contarValor(100,ListaRegistros,"30/04/2019","MP10");
        model.addAttribute("registros", ListaRegistros);
        model.addAttribute("array", arraymirar);
        return "index";
    }
    */

    @RequestMapping("")
    public String index(Model model){
        return "PaginaBienvenidaBootstrap";
    }


    @RequestMapping("/PaginaGraficoBootstrap")
    public String heatmap(Model model) {
        ManejoDato manejoDato = new ManejoDato();
        ControlRegistro controlRegistro = new ControlRegistro();
        ArrayList<Registro> registros = manejoDato.leerArchivo("src/archivos/Historial_SmartCity_2019.csv");
        ArrayList<Registro> datosFinales = controlRegistro.binarySearch(LocalDate.parse("01/06/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy")),registros);
        model.addAttribute("datosRegistros",datosFinales);
        return "PaginaGraficoBootstrap";
    }
}
