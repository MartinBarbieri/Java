package sistemas.mascotas;

import elementos.tiempo.Fecha;

import java.util.HashSet;

public class Tortuga extends Mascota {

    public Tortuga(String nombreMascota, String nombreDueño, Fecha fechaDeNacimiento, HashSet<Fecha> controles, String raza) {
        super(nombreMascota, nombreDueño, fechaDeNacimiento, controles);
    }

    @Override
    public String saludarMascota(){
        return "No tiene saludo";
    }

    @Override
    public String tipoMascota(){
        return "TORTUGA";
    }
}
