package Voraces;

public class Estudiante {
    private String nombre, apellidos; //nombre apellidos alumno
    private boolean genero; //false = masculino, true = femenino
    private double nota; //nota media de primaria

    public Estudiante(String nombre, String apellidos, boolean genero, double nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isGenero() {
        return genero;
    }
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
}
