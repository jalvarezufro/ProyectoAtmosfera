package proyecto.atmosfera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto.atmosfera.controlador.ManejoDato;
import proyecto.atmosfera.controlador.RegistroController;
import proyecto.atmosfera.modelo.ListaRegistro;
import proyecto.atmosfera.modelo.Registro;

import java.util.ArrayList;

@SpringBootApplication
public class ProyectoAtmosferaApplication {

    public static void main(String[] args) {
       // SpringApplication.run(ProyectoAtmosferaApplication.class, args);
        ManejoDato md = new ManejoDato();
        RegistroController rController = new RegistroController();
        ArrayList<Registro>  l = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        for (int i = 0; i <100 ; i++) {
            System.out.println(l.get(i).toString());
        }
    }

}
