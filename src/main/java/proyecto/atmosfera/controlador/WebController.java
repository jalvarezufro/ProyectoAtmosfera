package proyecto.atmosfera.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.manejoArchivos.ManejoRegistro;
import proyecto.atmosfera.modelo.Registro;

import java.util.ArrayList;

@Controller
@RequestMapping()
public class WebController {

    @RequestMapping("")
    public String index(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        String [][] arraymirar = ListaRegistros.get(1).contarValor("100",ListaRegistros,"30/04/2019","MP10");
        model.addAttribute("registros", ListaRegistros);
        model.addAttribute("array", arraymirar);
        return "index";
    }

    @RequestMapping("/tabla")
    public String tabla(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        model.addAttribute("registros", ListaRegistros);
        return "tablaRegistros";
    }

    @RequestMapping("/chartIndex")
    public String chartIndex(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        model.addAttribute("registros", ListaRegistros);
        return "chartIndex";
    }

    @RequestMapping("/chartIndex2")
    public String chartIndex(Model model, @RequestParam(name="limite", required=false) String limite, @RequestParam(name="dia", required=false) String dia) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        model.addAttribute("registros", ListaRegistros);

        //mandar array de ints
        model.addAttribute("limite",limite);
        model.addAttribute("dia",dia);
        int[] pasados= ListaRegistros.get(0).getIntSuperados((ListaRegistros.get(0).contarValor(limite,ListaRegistros,dia,"MP10")));
        model.addAttribute("pasados",pasados );
        return "chartIndex2";
    }




}
