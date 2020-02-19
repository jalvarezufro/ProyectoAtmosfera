package proyecto.atmosfera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto.atmosfera.controlador.ControlRegistro;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;

import java.util.ArrayList;

@SpringBootApplication
public class ProyectoAtmosferaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ProyectoAtmosferaApplication.class, args);

        ManejoDato manejoDato = new ManejoDato();
        ControlRegistro controlRegistro = new ControlRegistro();
        ArrayList<Registro> registros = manejoDato.leerArchivo("src/archivos/Historial_SmartCity_2019.csv");
        ArrayList<Registro> datosFinales = controlRegistro.binarySearch("18/04/2019",registros);
        for (int i = 0; i < datosFinales.size(); i++) {
            System.out.println(datosFinales.get(i).toString());
        }
    }
}
