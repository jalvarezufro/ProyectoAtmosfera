package proyecto.atmosfera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto.atmosfera.controlador.ManejoDato;
import proyecto.atmosfera.controlador.RegistroController;
import proyecto.atmosfera.modelo.Registro;


import java.util.ArrayList;

@SpringBootApplication
public class ProyectoAtmosferaApplication {

    public static void main(String[] args) {
      // SpringApplication.run(ProyectoAtmosferaApplication.class, args);

        ManejoDato md = new ManejoDato();
        RegistroController rController = new RegistroController();
        ArrayList<Registro>  l = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        int [] arraymirar = l.get(1).contarValor(100,l,"30/04/2019","MP10");
        for (int i = 0; i < arraymirar.length; i++) {
            System.out.println(arraymirar[i]);
        }



    }

}
