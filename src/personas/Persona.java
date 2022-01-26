package personas;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private int telefono;
    private String direccion;
    private String ocupacion;

    public Persona(){
        nombre="Tomas";
        apellido="Guirro";
        edad=17;
        dni=44351131;
        telefono=1123445634;
        direccion="Cabezon 2449";
    }

    public Persona(String nombre){
        this.nombre = nombre;
        edad=17;
        dni=44351131;
        telefono=1123445634;
        direccion="Cabezon 2449";
    }

    public Persona(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }


    public Persona(String nombre, String apellido, int  edad, int dni, int telefono, String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad=edad;
        this.dni=dni;
        this.telefono=telefono;
        this.direccion=direccion;
    }

    public Persona(String nombre, String apellido,String ocupacion,int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ocupacion = ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public boolean esMayorDeEdad(int edad){
        boolean esMayor= edad>=18;
        return esMayor;

    }

    public boolean sonLaMismaPersona(Persona p1){
        boolean sonLaMismaPersona = this.getDni() == p1.getDni();

        return sonLaMismaPersona;
    }

    public boolean tienenLaMismaEdad(Persona p1){
        boolean MismaEdad = this.getEdad() == p1.getEdad();

        return MismaEdad;
    }
}
