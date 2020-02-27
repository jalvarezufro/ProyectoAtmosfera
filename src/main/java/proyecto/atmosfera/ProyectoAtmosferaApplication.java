package proyecto.atmosfera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyecto.atmosfera.controlador.ControlRegistro;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.modelo.Registro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@SpringBootApplication
public class ProyectoAtmosferaApplication {

    public static void main(String[] args) {SpringApplication.run(ProyectoAtmosferaApplication.class, args);}
}
