package proyecto.atmosfera.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.atmosfera.modelo.Registro;

import java.applet.Applet;
import java.util.ArrayList;

@Controller
@RequestMapping()
public class RegistroControllerWeb {

    @RequestMapping("/index")
    public String index(Model model) {
        ManejoDato md = new ManejoDato();
        RegistroController rController = new RegistroController();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        int [] arraymirar = ListaRegistros.get(1).contarValor(100,ListaRegistros,"30/04/2019","MP10");
        model.addAttribute("registros", ListaRegistros);
        model.addAttribute("array", arraymirar);
        return "pagina1";
    }

    @RequestMapping("/tabla")
    public String tabla(Model model) {
        ManejoDato md = new ManejoDato();
        RegistroController rController = new RegistroController();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        model.addAttribute("registros", ListaRegistros);
        return "tablaRegistros";
    }

    @RequestMapping()
    public String principal(Model model){
        return "Pagina1";
    }


}
