package sistemas.mascotas;
import excepciones.Nombre;
import java.util.HashSet;
import java.util.Scanner;

public class ABM {
    HashSet<Mascota> mascotas;
    HashSet<String> nombresDuenios;

    public ABM() {
        this.mascotas = new HashSet<>();
        this.nombresDuenios=new HashSet<>();
    }

    public HashSet<Mascota> getMascotas() {
        return mascotas;
    }

    public void ingresarNombresValidos(String...nombresValidos){
        for (String nombre: nombresValidos) {
            nombresDuenios.add(nombre);
        }

    }

    public boolean nombreValido(String nombreDuenio){
        if(nombresDuenios.contains(nombreDuenio)){
            return true;
        }
        else {
            throw new Nombre();
        }
    }

    public void setMascotas(HashSet<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String pasarAMayuscula(String palabra){
        String palabraEnMayuscula=palabra.toUpperCase();
        return palabraEnMayuscula;
    }

    public boolean verificarExistenciaMascota(String nombreMascota){
        for (Mascota mascota: mascotas) {
            if(mascota.nombreMascota==nombreMascota){
                return true;
            }
        }
        return false;
    }

    public void altaMascota (String nombreMascota, String nombreDueño, String tipoDeMascota, String raza) throws Nombre{
        try{
            if(nombreValido(nombreDueño)) {
                String tipoMascota = pasarAMayuscula(tipoDeMascota);
                if (tipoMascota.equals( "PERRO")) {
                    Mascota m1 = new Perro(nombreMascota, nombreDueño, raza);
                    mascotas.add(m1);
                } else if (tipoMascota .equals("GATO")) {
                    Mascota m1 = new Gato(nombreMascota, nombreDueño, raza);
                    mascotas.add(m1);
                } else if (tipoMascota .equals( "PAJARITOS")) {
                    Mascota m1 = new Pajarito(nombreMascota, nombreDueño);
                    mascotas.add(m1);
                } else if (tipoMascota .equals("Peces")) {
                    Mascota m1 = new Pez(nombreMascota, nombreDueño);
                    mascotas.add(m1);
                }
            }
        }
        catch (Nombre ex){
            System.out.println(ex.getMensaje());
        }
    }

    public void bajaMascota(Mascota mascotaABorrar){
        mascotas.remove(mascotaABorrar);
    }

    public void mostrarmenu(){
        System.out.println("Ingrese el numero acorde a lo que quiere modificar");
        System.out.println("1-Nombre de la mascota");
        System.out.println("2-Nombre del dueño");
        System.out.println("3-Nivel de alegria");
        System.out.println("4-Vidas");
        System.out.println("5-Salir");
    }
    public void mensajeDeError(){
        System.out.println("No se encuentra la mascota");
    }

    public void mensajeDeExito(){
        System.out.println("Se han realizado los cambios correctamente");
    }

    public void mensajeDeErrorPeces(){
        System.out.println("Solo los peces tienen vidas, NO tienen alegría");
    }

    public String ingresarNuevoNombre(){
        Scanner respuestaUsuario = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre");
        String respuestaNombres=respuestaUsuario.nextLine();
        return respuestaNombres;
    }
    public int ingresarNumero(){
        Scanner respuestaUsuario = new Scanner(System.in);
        int respuestaNumero=respuestaUsuario.nextInt();
        return respuestaNumero;
    }
    public boolean modificarNombreMascota (Mascota  mascotaAModificar, String respuestaNombre){
        if(mascotas.contains(mascotaAModificar)){
            mascotaAModificar.setNombreMascota(respuestaNombre);
            return true;
        }
        return false;
    }
    public boolean modificarNombreDueño (Mascota  mascotaAModificar, String respuestaNombre){
        if(mascotas.contains(mascotaAModificar)){
            mascotaAModificar.setNombreDueño(respuestaNombre);
            return true;
        }
        return false;
    }

    public boolean verificarSiEsPez(String nombreMascota){
        for (Mascota mascota: mascotas) {
            if(mascota.nombreMascota==nombreMascota && mascota.tipoMascota() == "PEZ"){ //Verifico si está la mascota
                return true;
            }
        }
        return false;
    }

    public void  modificarVidasPeces(Mascota mascotaAModificar, int numeroNuevo) {
        Pez p = (Pez) mascotaAModificar;
        p.setVidas(numeroNuevo);
    }

    public void modificarAlegria(Mascota mascotaAModificar, int numeroNuevo){
        mascotaAModificar.setAlegria(numeroNuevo);
    }

    public void modificarMascota(String nombreMascota){
        Mascota mascotaAModificar = null;
        if(verificarExistenciaMascota(nombreMascota)) {
            for(Mascota mascota: mascotas){
                if(mascota.getNombreMascota().equals(nombreMascota)){
                    mascotaAModificar = mascota;
                }
            }
            String respuestaNombres;
            int numeroIngresado;
            mostrarmenu();
            Scanner respuestaUsuario = new Scanner(System.in);
//            System.out.println("ingrese un numero acorde a lo que quiere modificar");
            int opcion = ingresarNumero();
            switch (opcion) {
                case 1:
                    respuestaNombres = ingresarNuevoNombre();
                    if (modificarNombreMascota(mascotaAModificar, respuestaNombres)) {
                        mensajeDeExito();
                        modificarMascota(nombreMascota);
                    } else {
                        mensajeDeError();
                    }

                    break;
                case 2:
                    respuestaNombres = ingresarNuevoNombre();
                    if (modificarNombreDueño(mascotaAModificar, respuestaNombres)) {
                        mensajeDeExito();
                        modificarMascota(nombreMascota);

                    } else {
                        mensajeDeError();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nivel de Alegria");
                    numeroIngresado = ingresarNumero();
                    if (mascotas.contains(mascotaAModificar)) {
                        if (verificarSiEsPez(mascotaAModificar.getNombreMascota())) {
                            mensajeDeErrorPeces();
                        } else {
                            modificarAlegria(mascotaAModificar, numeroIngresado);
                            modificarMascota(nombreMascota);

                        }
                    } else {
                        mensajeDeError();
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nivel de vida");
                    numeroIngresado = ingresarNumero();
                    if (mascotas.contains(mascotaAModificar)) {
                        if (verificarSiEsPez(mascotaAModificar.getNombreMascota())) {
                            modificarVidasPeces(mascotaAModificar, numeroIngresado);
                            mensajeDeExito();
                            modificarMascota(nombreMascota);

                        } else {
                            mensajeDeErrorPeces();
                        }
                    } else {
                        mensajeDeError();
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("No ingreso ninguna de las opciones anteriores");
                    break;
            }
        }
        else{
            System.out.println("La mascota no ha sido ingresada");
        }
    }

    public int nivelDeAlegria(Mascota mascotaASaludar) {
        int nivelAlegria = 0;
        for (Mascota mascota : mascotas) {
            if (mascota.nombreMascota.equals(mascotaASaludar.nombreMascota)) {
                nivelAlegria = mascota.alegria;
                break;
            }
        }
        return nivelAlegria;
    }

    public void saludar(String nombreUsuario,String nombreMascota){
        int vecesDelSaludo;
       String saludo;
       String tipoMascota;
        for (Mascota mascota: mascotas) {
            tipoMascota=mascota.tipoMascota();
            if(verificarExistenciaMascota(nombreMascota) && mascota.getNombreMascota()==nombreMascota){ //Verifico si está la mascota
                vecesDelSaludo=nivelDeAlegria(mascota);
                for (int i = 0; i <vecesDelSaludo ; i++) { //Cuantas veces imprimira el saludo de acuerdo al nivel de alegria
                    if (mascota.nombreDueño == nombreUsuario) { //Y es el dueño quien saluda
                        System.out.print(mascota.saludarMascota());
                        System.out.print(" ");
                        if (mascota.saludarMascota() == "El pez ha muerto") {
                            mascotas.remove(mascota);
                            i=vecesDelSaludo;
                        }
                    } else {// Si no es el dueño quien saludo
                        if (tipoMascota != "PAJARITO") { //Si es un pajaro no entra ya que no tienen que saludar
                            saludo = mascota.saludarMascota().toUpperCase();
                            System.out.print(saludo + "!");
                            System.out.print(" ");

                        }
                        if (tipoMascota == "PEZ") { //Saluda al pez alguien que no es el dueño
                            mascotas.remove(mascota);
                            i=vecesDelSaludo;
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        ABM veterinaria=new ABM();
        veterinaria.ingresarNombresValidos("Maria","Pedro","Micaela","Mariana","Roque","Magali","Nadia","Melina","Ana","Vicente","Juana","Chiara","Agustin","Ezequiel","Luca","Marco","Valentina","Milagros","Giuiana","Sofia");
        veterinaria.altaMascota("Fifi","Pedro","Perro", "Ovejero");
        veterinaria.altaMascota("Michifuz","Mariana","Gato", "Siamés");
        veterinaria.altaMascota("Pio","Nadia","Pajaritos", "");
        System.out.print("Fifi saluda a Pedro: ");
        veterinaria.saludar("Pedro","Fifi");
        System.out.println("");
        System.out.print("¿Pio es un pez? ");
        System.out.println(veterinaria.verificarSiEsPez("Pio"));
        System.out.print("Fifi saluda a Micaela: ");
        veterinaria.saludar("Micaela","Fifi");
        System.out.print("Michifuz saluda a Mariana: ");
        veterinaria.saludar("Mariana","Michifuz");
        System.out.println("");
        veterinaria.modificarMascota("Fifi");



    }

}
