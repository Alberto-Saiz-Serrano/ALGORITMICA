package Voraces;

public class Conjunto {
    private int[] contenido;

    public Conjunto(int[] contenido) {
        this.contenido = new int[contenido.length];
        for (int i = 0; i < contenido.length; i++) this.contenido[i] = contenido[i];
    }

    public int longitud() {
        return this.contenido.length;
    }

    public int get(int posicion) {
        return contenido[posicion];
    }
}
