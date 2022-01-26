package sistemas.mascotas;

import elementos.tiempo.Fecha;

import java.util.HashSet;

public class Perro extends MascotasConRaza {
    String saludo;

    public Perro(String nombreMascota, String nombreDueño, Fecha fechaDeNacimiento, HashSet<Fecha> controles, String raza) {
        super(nombreMascota, nombreDueño, fechaDeNacimiento, controles, raza);
        this.saludo = "GUAU";
    }

    public Perro(String nombremascota, String nombreDueño, String raza) {
        super(nombremascota,nombreDueño, raza);
        this.saludo="GUAU";
    }

    @Override
    public String saludarMascota(){
        return this.saludo;
    }

    @Override
    public String tipoMascota(){
        return "PERRO";
    }

}
