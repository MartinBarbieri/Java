package sistemas.mascotas;

import elementos.tiempo.Fecha;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Mascota {
    String nombreMascota;
    String nombreDueño;
    Fecha fechaDeNacimiento;
    HashSet<Fecha> controles;
    int alegria;


    public Mascota(String nombreMascota, String nombreDueño) {
        this.nombreMascota = nombreMascota;
        this.nombreDueño = nombreDueño;
        this.alegria=1;
    }

    public Mascota(String nombreMascota, String nombreDueño, Fecha fechaDeNacimiento, HashSet<Fecha> controles) {
        this.nombreMascota = nombreMascota;
        this.nombreDueño = nombreDueño;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.controles = controles;
    }

    public abstract String saludarMascota();

    public void alimentarMascota(){
        this.alegria=alegria++;
    }

    public String tipoMascota(){
        return "No hay mascotas cargadas";
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Fecha fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public HashSet<Fecha> getControles() {
        return controles;
    }

    public void setControles(HashSet<Fecha> controles) {
        this.controles = controles;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    public int visitasPorAnio(int anio){
        int cantidadVisitas=0;
        for (Fecha anioPorControl : controles) {
            if(anioPorControl.getAnio()==anio){
                cantidadVisitas++;
            }
        }
        return cantidadVisitas;
    }

    public boolean visitasObligatorias(int anio){
        boolean cumplioConLasVisitas;
        String tipoMascota=tipoMascota();
        Integer cantidadDeVisitas=visitasPorAnio(anio);
        if (tipoMascota=="PERRO" && cantidadDeVisitas>3){
            cumplioConLasVisitas=true;
        }
        else{
            cumplioConLasVisitas=false;
        }
        if (tipoMascota=="GATO" && cantidadDeVisitas>1){
            cumplioConLasVisitas=true;
         }
         else{
            cumplioConLasVisitas=false;
         }
         if (tipoMascota=="TORTUGA" && cantidadDeVisitas>0){
             cumplioConLasVisitas=true;
         }
         else{
             cumplioConLasVisitas=false;
         }
         return cumplioConLasVisitas;
     }

    public int calcularEdad(int anioActual){
        Integer anioNacimiento=getFechaDeNacimiento().getAnio();
        Integer edad= anioActual-anioNacimiento;
        return edad;
    }
    public int cantidadDeControlesMinimo (int edad){
        int controlesMinimos=0;
        String tipoMascota=tipoMascota();
        if (tipoMascota=="PERRO" ){
            controlesMinimos=4*edad;
        }
        if (tipoMascota=="GATO" ){
            controlesMinimos=2*edad;
        }
        if (tipoMascota=="TORTUGA"){
            controlesMinimos=edad;
        }
        return controlesMinimos;
    }

    public boolean asistenciaPerfecta(int anio){
        int controlesRealizados=controles.size();
        int controlesMinimos=cantidadDeControlesMinimo(calcularEdad(anio));
        if (controlesRealizados>= controlesMinimos){
            return true;
        }
        else{
            return false;
        }
    }
}
