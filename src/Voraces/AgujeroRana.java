package Voraces;

public class AgujeroRana {
    private int valor; //valor de la sección/casilla de la mesa
    private int cantidad; //número de discos utilizados
    AgujeroRana (int valor, int cantidad){
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
