package Voraces;

public class Partido {
    String nombre;
    int diputados;
    float orientacion;

    Partido(String nombre, int diputados, float orientacion){
        this.nombre = nombre;
        this.diputados = diputados;
        this.orientacion = orientacion;
    }

    float Perjuicio(Partido p2){
        return (Math.abs(this.getOrientacion() - p2.getOrientacion()) / 9);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiputados() {
        return diputados;
    }
    public void setDiputados(int diputados) {
        this.diputados = diputados;
    }

    public float getOrientacion() {
        return orientacion;
    }
    public void setOrientacion(float orientacion) {
        this.orientacion = orientacion;
    }
}

