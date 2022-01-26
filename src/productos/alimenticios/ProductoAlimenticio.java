package productos.alimenticios;


import productos.Producto;

import java.util.ArrayList;

public class ProductoAlimenticio extends Producto {

    private String fechaElaboracion;
    private String fechaVencimiento;
    private int peso;

    public ProductoAlimenticio(String nombre, int precio, String fechaElaboracion, String fechaVencimiento, int peso) {
        super(nombre, precio);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.peso = peso;
    }

    public ProductoAlimenticio(){
        super("fideos", 76);
        fechaElaboracion ="12-07-2019";
        fechaVencimiento ="20-01-2020";
        peso=3;
    }


    public String getFechaElaboracion() {
        return fechaElaboracion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getPeso() {
        return peso;
    }

    public void setFechaElaboracion(String fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean mayor5kg (){
        return this.peso>=5;
    }
    public boolean esProductoVencido(String fechaActual){

        int anioDeVencimiento = this.extraerAnio(fechaVencimiento);
        int mesDeVencimiento = this.extraerMes(fechaVencimiento);
        int diaDeVencimiento = this.extraerDia(fechaVencimiento);

        int anioActual = this.extraerAnio(fechaActual);
        int mesActual = this.extraerMes(fechaActual);
        int diaActual = this.extraerDia(fechaActual);

        boolean estaVencido = anioActual > anioDeVencimiento ||
                anioActual == anioDeVencimiento && mesActual > mesDeVencimiento ||
                anioActual == anioDeVencimiento && mesActual == mesDeVencimiento &&  diaActual > diaDeVencimiento;

        return estaVencido;
    }

    //métodos auxiliares
    public int extraerAnio(String fecha){
        String anioString = "" + fecha.charAt(6) + fecha.charAt(7) +
                fecha.charAt(8) + fecha.charAt(9);
        int anio = parseStringToInt(anioString);
        return anio;
    }

    public int extraerMes(String fecha){
        String mesString = "" + fecha.charAt(3) + fecha.charAt(4);
        int mes = parseStringToInt(mesString);
        return mes;
    }

    public int extraerDia(String fecha){
        String diaString = "" + fecha.charAt(0) + fecha.charAt(1);
        int dia = parseStringToInt(diaString);
        return dia;
    }

    public int parseCharToInt(char numeroComoChar){
        int numeroCorrespondiente = 0;
        switch (numeroComoChar){
            case '0':
                numeroCorrespondiente = 0;
                break;
            case '1':
                numeroCorrespondiente = 1;
                break;
            case '2':
                numeroCorrespondiente = 2;
                break;
            case '3':
                numeroCorrespondiente = 3;
                break;
            case '4':
                numeroCorrespondiente = 4;
                break;
            case '5':
                numeroCorrespondiente = 5;
                break;
            case '6':
                numeroCorrespondiente = 6;
                break;
            case '7':
                numeroCorrespondiente = 7;
                break;
            case '8':
                numeroCorrespondiente = 8;
                break;
            case '9':
                numeroCorrespondiente = 9;
        }
        return numeroCorrespondiente;
    }

    public int obtenerAnioComoInt(int m, int c, int d, int u){
        int anio = m * 1000 + c * 100 + d * 10 + u;
        return anio;
    }

    public int obtenerMesODiaComoInt(int d, int u){
        int mes = d * 10 + u;
        return mes;
    }

    public int parseStringToInt(String numeroComoString){
        ArrayList<Integer> numeros = new ArrayList<>();
        int numeroConvertido = 0;

        for (int i = 0; i < numeroComoString.length(); i++) {
            char numeroComoChar = numeroComoString.charAt(i);
            int numero = parseCharToInt(numeroComoChar);
            numeros.add(numero);
        }

        numeroConvertido = parseArrayToInt(numeros);
        return numeroConvertido;
    }

    public int parseArrayToInt(ArrayList<Integer> numeros){
        int cantidadDeNumeros = numeros.size();
        int numeroBuscado = 0;

        if (cantidadDeNumeros == 4){
            numeroBuscado = obtenerAnioComoInt(numeros.get(0),numeros.get(1),numeros.get(2),numeros.get(3));
        }else{
            numeroBuscado = obtenerMesODiaComoInt(numeros.get(0),numeros.get(1));
        }
        return numeroBuscado;
    }

    public static void main (String[] argum){
        ProductoAlimenticio p1=new ProductoAlimenticio();
        System.out.println("El producto supera los 5kg? "+ p1.mayor5kg() ); ;
        System.out.println(true == p1.esProductoVencido("25-06-2019"));
    }

}
