package sistemas.mascotas;

import elementos.tiempo.Fecha;

import java.util.HashSet;

public class MascotasConRaza extends Mascota {
    String raza;

    public MascotasConRaza(String nombreMascota, String nombreDueño, Fecha fechaDeNacimiento, HashSet<Fecha> controles, String raza) {
        super(nombreMascota, nombreDueño, fechaDeNacimiento, controles);
        this.raza = raza;
    }

    public MascotasConRaza(String nombreMascota, String nombreDueño, String raza){
        super(nombreMascota,nombreDueño);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String saludarMascota(){
        return null;
    }

}
