package Voraces;

import java.util.ArrayList;

public class Grupo {
    // Un Grupo es un conjunto de N estudiantes
    private ArrayList<Estudiante> alumnos;
    private int maxAlumnos, numAlumnos;

    public Grupo(ArrayList<Estudiante> alumnos, int maxAlumnos, int numAlumnos) {
        this.alumnos = alumnos;
        this.maxAlumnos = maxAlumnos;
        this.numAlumnos = numAlumnos;
    }

    public int getAlumnosRestantes(){
        return maxAlumnos - numAlumnos;
    }

    public ArrayList<Estudiante> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(ArrayList<Estudiante> alumnos) {
        this.alumnos = alumnos;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }
    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }
}

