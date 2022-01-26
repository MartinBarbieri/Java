package sistemas.libreria;

import personas.Persona;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cliente extends Persona {
    HashMap<Libro, Integer> compras;

    public Cliente() {
        super();
        this.compras=new HashMap<>();
    }

    public Cliente(HashMap<Libro, Integer> compras) {
        super("Martin","Barbieri", 44668756);
        this.compras = compras;
    }

    public HashMap<Libro, Integer> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<Libro, Integer> compras) {
        this.compras = compras;
    }

    public void agregarCompra(Libro libro1, int cantUnidades){
        compras.put(libro1, cantUnidades );
    }

    public HashSet<Libro> librosComprados(){
        HashSet<Libro> libroComprado = new HashSet<>();
        for (Map.Entry<Libro, Integer> obtenerLibro : compras.entrySet()) {
            libroComprado.add(obtenerLibro.getKey());
        }
        return libroComprado;
    }

    public int obtenerCantidadDeCadaLibro(Libro libro){
        int  cantidadLibrosComprado=0;
                for (Map.Entry<Libro, Integer> obtenerLibro : compras.entrySet()) {
                    if(obtenerLibro.getKey()==libro){
                        cantidadLibrosComprado=obtenerLibro.getValue();
                    }

            }
        return cantidadLibrosComprado;
    }



    public void mostrarLibroYCantidadPorCliente(){
       HashSet<Libro> librosComprados=librosComprados();
        for (Libro libro1: librosComprados){
            System.out.println("El cliente "+ getNombre()+" " + getApellido()+" ha comprado "+ obtenerCantidadDeCadaLibro(libro1) + " ejemplares de: " + libro1.getNombre() );
        }
    }



}
