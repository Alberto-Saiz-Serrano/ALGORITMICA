package Voraces;

public class Diana {
    private int valor; //valor de la sección de la Diana
    private int modo; //modo de juego
    private int cantidad; //número de dardos utilizados
    Diana (int valor, int cantidad, int modo){
        this.valor = valor;
        this.modo = modo;
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getModo() {
        return modo;
    }
    public void setModo(int modo) {
        this.modo = modo;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
