package Voraces;

public class Producto {
    private int nombre;
    private int peso;

    Producto (int nombre, int peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
}
