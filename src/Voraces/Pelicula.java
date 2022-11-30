package Voraces;

public class Pelicula {
    private String titulo;
    private String director;
    private int duracionMin;
    private Hora horaComienzo;

    public Pelicula(String titulo, String director, int duracionMin, Hora horaComienzo){
        this.titulo = titulo;
        this.director = director;
        this.duracionMin = duracionMin;
        this.horaComienzo = horaComienzo;
    }
    public String getTitulo() {
        return titulo;
    }

    public int getFin(){
        return getInicio() + this.duracionMin;
    }

    public int getInicio(){
        return this.horaComienzo.transformaAMinutos();
    }
}
