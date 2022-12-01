package Voraces;

public class Concursante {
    //Ci = {identificador, edad, peso, sexo}
    private int id; //ID del concursante
    private int edad; //1..4:{(1)joven<30; (2)adulto<45; (3)senior<60; (4)anciano≥ 60}
    private int peso; //1..3:{(1)pesado:p≥75kg; (2)medio:63<p<75 kg; (3)ligero:p<63 kg}
    private boolean genero; // true = femenino, false = masculino

    public Concursante(int id, int edad, int peso, boolean genero) {
        this.id = id;
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isGenero() {
        return genero;
    }
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

}
