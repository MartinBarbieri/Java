package excepciones;

public class Nombre extends NullPointerException {
    String mensaje;

    public Nombre() {
        mensaje="Nombre no valido";
    }

    public String getMensaje() {
        return mensaje;
    }
}
