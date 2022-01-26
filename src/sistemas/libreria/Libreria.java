package sistemas.libreria;

import elementos.tiempo.Dia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Libreria {
    ArrayList<Libro> librosVendidos;
    HashSet<Editorial> editorialesConDescuento;
    HashSet<Cliente> clientesQueHayanComprado;
    HashMap<Dia, Integer> cantidadDeLibrosPorDía;


    public Libreria() {
        this.librosVendidos = new ArrayList<>();
        this.editorialesConDescuento=new HashSet<>();
        this.clientesQueHayanComprado=new HashSet<>();
        this.cantidadDeLibrosPorDía = new HashMap<>();
        cantidadDeLibrosPorDía.put(Dia.LUNES, 0);
        cantidadDeLibrosPorDía.put(Dia.MARTES, 0);
        cantidadDeLibrosPorDía.put(Dia.MIERCOLES, 0);
        cantidadDeLibrosPorDía.put(Dia.JUEVES, 0);
        cantidadDeLibrosPorDía.put(Dia.VIERNES, 0);
        cantidadDeLibrosPorDía.put(Dia.SABADO, 0);
        cantidadDeLibrosPorDía.put(Dia.DOMINGO, 0);
    }

    public ArrayList<Libro> getLibrosVendidos() {
        return librosVendidos;
    }

    public void setLibrosVendidos(ArrayList<Libro> librosVendidos) {
        this.librosVendidos = librosVendidos;
    }

    public HashSet<Editorial> getEditorialesConDescuento() {
        return editorialesConDescuento;
    }

    public void setEditorialesConDescuento(HashSet<Editorial> editorialesConDescuento) {
        this.editorialesConDescuento = editorialesConDescuento;
    }

    public HashSet<Cliente> getClientesQueHayanComprado() {
        return clientesQueHayanComprado;
    }

    public void setClientesQueHayanComprado(HashSet<Cliente> clientesQueHayanComprado) {
        this.clientesQueHayanComprado = clientesQueHayanComprado;
    }

    public HashMap<Dia, Integer> getCantidadDeLibrosPorDía() {
        return cantidadDeLibrosPorDía;
    }

    public void setCantidadDeLibrosPorDía(HashMap<Dia, Integer> cantidadDeLibrosPorDía) {
        this.cantidadDeLibrosPorDía = cantidadDeLibrosPorDía;
    }

    public void agregarLibroVendido(Libro libro, String dia){
        librosVendidos.add(libro);
        String diaDeLaSemana= dia.toUpperCase();
        int ventaRealizada=0;
        for (Map.Entry<Dia, Integer> cantidadPorDia : cantidadDeLibrosPorDía.entrySet()) {
            if(cantidadPorDia.getKey().equals(diaDeLaSemana)){
                cantidadDeLibrosPorDía.put(cantidadPorDia.getKey(), cantidadPorDia.getValue()+1);
            }
            break;
        }

    }

    public void agregarEditorialesConDescuento (Editorial editorial) {
        editorialesConDescuento.add(editorial);
    }

    public HashMap<Editorial, Integer> librosVendidosSegunEditorial(){
        HashMap<Editorial, Integer> cantidadLibrosPorEditorial=new HashMap<>();
        int cantidad=0;
        Editorial editorialAComparar;
        for (int i=0;i<librosVendidos.size();i++){
            editorialAComparar=getLibrosVendidos().get(i).getEditorial();
            for (Libro libro1: librosVendidos) {
                if (editorialAComparar==libro1.getEditorial()){
                    cantidad++;
                }
            }
            cantidadLibrosPorEditorial.put(editorialAComparar,cantidad);
            cantidad=0;

        }
        return cantidadLibrosPorEditorial;
    }

    public Editorial editorialConMasLibrosVendidos(){
        int mayorCantidadDeVentas=0;
        Editorial editorialConMasVentas = null;
        HashMap<Editorial, Integer> cantidadVendidosPorEditorial=librosVendidosSegunEditorial();
        for (Map.Entry<Editorial, Integer> editorialYCantidad : cantidadVendidosPorEditorial.entrySet()) {
            if(editorialYCantidad.getValue()>mayorCantidadDeVentas){
                editorialConMasVentas=editorialYCantidad.getKey();
                mayorCantidadDeVentas=editorialYCantidad.getValue();
            }
        }
        return editorialConMasVentas;

    }


    public void gastoDelClientePorLibrosComprados(Cliente cliente1){
        HashSet<Libro> librosComprados =cliente1.librosComprados();
        for (Libro libro1 : librosComprados ){
           if(editorialesConDescuento.contains(libro1.getEditorial())){
               int nuevoPrecio=libro1.getPrecio()/2;
               libro1.setPrecio(nuevoPrecio);
           }
        }
        sumaTotal(librosComprados, cliente1);
    }

    public void sumaTotal(HashSet<Libro> librosComprados, Cliente cliente1){
        int suma=0;
        for(Libro libro : librosComprados){
           suma=suma+libro.getPrecio()*cliente1.obtenerCantidadDeCadaLibro(libro);
        }
        System.out.println("Ha gastado un total de: "+suma);
    }



}

