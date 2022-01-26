package sistemas.mascotas;

public class Pajarito extends Mascota  {
    String saludo;

    public Pajarito(String nombreMascota, String nombreDueño) {
        super(nombreMascota, nombreDueño);
        this.saludo = "pio";
    }


    @Override
    public String saludarMascota(){
        return this.saludo;
    }

    @Override
    public String tipoMascota(){
        return "PAJARITO";
    }
}
