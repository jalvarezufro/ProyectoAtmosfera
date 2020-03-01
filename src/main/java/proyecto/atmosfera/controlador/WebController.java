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

    @RequestMapping("/tabla")
    public String tabla(Model model) {
        ArrayList<Registro> ListaRegistros = new ManejoDato().leerArchivo("src\\main\\resources\\Historial_SmartCity_2019.csv");
        model.addAttribute("registros", ListaRegistros);
        return "tablaRegistros";
    }

    @RequestMapping("/home")
    public String index(Model model){
        return "PaginaBienvenidaBootstrap";
    }


    @RequestMapping("/PaginaGraficoBootstrap")
    public String heatmap(){
        //ArrayList<Registro> registros = new ArrayList<>();
        /*
        registros.add(new Registro("amanecer", "20/11/19","00:00",10.0,56.0));
        registros.add(new Registro("amanecer",1,"20/11/19","01:00",24.0,26.0));
        registros.add(new Registro("amanecer",1,"20/11/19","02:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"20/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"21/11/19","00:00",98.0,23.0));
        registros.add(new Registro("amanecer",1,"21/11/19","01:00",136.0,25.0));
        registros.add(new Registro("amanecer",1,"21/11/19","02:00",176.0,23.0));
        registros.add(new Registro("amanecer",1,"21/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"21/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"22/11/19","00:00",78.0,14.0));
        registros.add(new Registro("amanecer",1,"22/11/19","01:00",138.0,26.0));
        registros.add(new Registro("amanecer",1,"22/11/19","02:00",214.0,43.0));
        registros.add(new Registro("amanecer",1,"22/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"22/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"23/11/19","00:00",78.0,14.0));
        registros.add(new Registro("amanecer",1,"23/11/19","01:00",138.0,26.0));
        registros.add(new Registro("amanecer",1,"23/11/19","02:00",214.0,43.0));
        registros.add(new Registro("amanecer",1,"23/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"23/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"24/11/19","00:00",78.0,14.0));
        registros.add(new Registro("amanecer",1,"24/11/19","01:00",138.0,26.0));
        registros.add(new Registro("amanecer",1,"24/11/19","02:00",214.0,43.0));
        registros.add(new Registro("amanecer",1,"24/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"24/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"25/11/19","00:00",78.0,14.0));
        registros.add(new Registro("amanecer",1,"25/11/19","01:00",138.0,26.0));
        registros.add(new Registro("amanecer",1,"25/11/19","02:00",214.0,43.0));
        registros.add(new Registro("amanecer",1,"25/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"25/11/19","23:00",76.0,12.0));

        registros.add(new Registro("amanecer",1,"26/11/19","00:00",78.0,14.0));
        registros.add(new Registro("amanecer",1,"26/11/19","01:00",138.0,26.0));
        registros.add(new Registro("amanecer",1,"26/11/19","02:00",214.0,43.0));
        registros.add(new Registro("amanecer",1,"26/11/19","03:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","04:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","05:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","06:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","07:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","08:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","09:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","10:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","11:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","12:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","13:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","14:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","15:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","16:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","17:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","18:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","19:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","20:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","21:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","22:00",76.0,12.0));
        registros.add(new Registro("amanecer",1,"26/11/19","23:00",76.0,12.0));
        */
        //model.addAttribute("datosRegistros",registros);
        return "PaginaGraficoBootstrap";
    }
}
