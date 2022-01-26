package sistemas.libreria;

public enum Cuaderno {
    TIPO1(24,150),TIPO2(48,300), TIPO3(98,500) ;
    private int cantidadHojas;
    private int precio;
    private Cuaderno(int cantidadHojas, int precio){
        this.cantidadHojas=cantidadHojas;
        this.precio=precio;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
