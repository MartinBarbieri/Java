package sistemas.mascotas;

import elementos.tiempo.Fecha;

import java.util.HashSet;

public class Gato extends MascotasConRaza  {
    String saludo;

    public Gato(String nombreMascota, String nombreDueño, String raza) {
        super(nombreMascota, nombreDueño,  raza);
        this.saludo = "MIAU";
    }

    @Override
    public String saludarMascota(){
        return this.saludo;
    }

    @Override
    public String tipoMascota(){
        return "GATO";
    }
}
