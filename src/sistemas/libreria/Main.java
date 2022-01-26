package sistemas.libreria;
import java.util.HashMap;

public class Main {
    public static void main(String[] argum){
    Libreria Yenny=new Libreria();
    Libro l1=new Libro();
    Libro l2=new Libro();
    Libro l3=new Libro();
    Libro l4=new Libro( "La isla secreta",335, Editorial.SUR);
    Libro l5=new Libro("Cuando las piedras hablaban",335,Editorial.SUDAMERICANA);
    Libro l6=new Libro("Despues de mí",335,Editorial.ALIANZA);
    Libro l7=new Libro("¿Qué hay detrás? ",335,Editorial.ELATENEO);
    Libro l8=new Libro("Una vez más",335,Editorial.ELATENEO);
    Libro l9=new Libro("Los juegos del hambre",335,Editorial.INTERZONA);
    Libro l10=new Libro("Ahora se fueron",335,Editorial.ALIANZA);
    Cliente c1=new Cliente();
    c1.agregarCompra(l1,3);
    c1.agregarCompra(l10,1);
    Yenny.agregarLibroVendido(l1,"20-03-2020");
    Yenny.agregarLibroVendido(l2, "20-03-2020");
    Yenny.agregarLibroVendido(l3, "23-06-2021");
    Yenny.agregarLibroVendido(l4,"05-07-2021");
    Yenny.agregarLibroVendido(l5,"15-11-2021");
    Yenny.agregarLibroVendido(l6,"03-08-2021");
    Yenny.agregarLibroVendido(l7,"17-01-2022");
    Yenny.agregarLibroVendido(l8,"14-05-2021");
    Yenny.agregarLibroVendido(l9,"01-10-2021");
    Yenny.agregarLibroVendido(l10,"23-02-2021");
    Yenny.agregarEditorialesConDescuento(Editorial.KAPELUSZ);
    HashMap<Editorial, Integer> cantidadVendidosPorEditorial=Yenny.librosVendidosSegunEditorial();
    System.out.println(cantidadVendidosPorEditorial.entrySet());
    Editorial editorialConMasVentas=Yenny.editorialConMasLibrosVendidos();
    System.out.println("Editorial con más ventas: "+editorialConMasVentas);
    c1.mostrarLibroYCantidadPorCliente();
    Yenny.gastoDelClientePorLibrosComprados(c1);

    }
}
