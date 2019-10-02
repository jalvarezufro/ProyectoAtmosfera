package proyecto.atmosfera.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.applet.Applet;

@Controller
@RequestMapping()
public class RegistroControllerWeb {

    @RequestMapping("/index")
    public String index(Model model) {
        ManejoDato md = new ManejoDato();
        RegistroController rController = new RegistroController();
        model.addAttribute("registros", rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv")));
        return "index";
    }

    @RequestMapping()
    public String principal(Model model){
        return "Pagina1";
    }


}
