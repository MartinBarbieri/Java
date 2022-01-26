package sistemas.mascotas;

public class Pez extends Mascota  {
    int vidas;

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Pez(String nombreMascota, String nombreDueño) {
        super(nombreMascota, nombreDueño);
        this.vidas = 10;
    }

    @Override
    public String saludarMascota(){
        this.vidas=vidas--;
        String respuesta;
        if (vidas==0){
            respuesta="El pez ha muerto";
        }
        else {
            respuesta="El pez tiene una vida menos";
        }
    return respuesta;
    }

    @Override
    public String tipoMascota(){
        return "PEZ";
    }
}
