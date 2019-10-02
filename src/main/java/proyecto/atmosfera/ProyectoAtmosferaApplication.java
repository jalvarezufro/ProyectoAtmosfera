package proyecto.atmosfera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.manejoArchivos.ManejoRegistro;
import proyecto.atmosfera.modelo.Registro;


import java.util.ArrayList;

@SpringBootApplication
public class ProyectoAtmosferaApplication {

    public static void main(String[] args) {
      SpringApplication.run(ProyectoAtmosferaApplication.class, args);

        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro>  l = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        String [][] arraymirar = l.get(1).contarValor(100,l,"30/04/2019","MP10");
        for (int i = 0; i < arraymirar.length; i++) {
            System.out.println(arraymirar[i][1]);
        }


    }

}
