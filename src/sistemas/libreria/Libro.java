package sistemas.libreria;

import productos.Producto;

public class Libro extends Producto {
    Editorial editorial;

    public Libro(String nombre, int precio, Editorial editorial) {
        super(nombre, precio);
        this.editorial=editorial;
    }

    public Libro() {
        super("La isla encantada", 500);
        this.editorial=Editorial.KAPELUSZ;

    }

    public Libro(Editorial editorial) {
        super();
        this.editorial = editorial;

    }


    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

}


