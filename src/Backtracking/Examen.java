package Backtracking;

import Backtracking.SeleccionOptima.Entero;

public class Examen {
    public static void main(String[] args) {
        int [] pesos = new int []{1,3,2,5,1,4,2,1};
        int [] resultado = distribucionCarga2(pesos, 10);
        System.out.print("Examen: ");
        for(int i = 0; i < resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }

    public static int [] distribucionCarga2(int [] pesos, int pMax){
        int [] solucion = new int [pesos.length];
        int [] mejorSolucion = new int [pesos.length];
        Entero distancia = new Entero(Integer.MAX_VALUE);
        distribucionCarga2Aux(pesos, pMax, 0, solucion, mejorSolucion, 0, 0, distancia);
        return mejorSolucion;
    }
    private static void distribucionCarga2Aux(int [] pesos, int pMax, int nivel, int [] solucion, int [] mejorSolucion, int suma1, int suma2, Entero distancia){
        if(nivel == pesos.length){
            if(Math.abs(suma1 - suma2) < distancia.getValor() && aceptable(solucion)){
                distancia.setValor(Math.abs(suma1 - suma2));
                for(int i = 0; i < solucion.length; i++){
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {
            for(int c = 0; c < 3; c++){
                if( c == 0 || (c == 1) && suma1 + pesos[nivel] <= pMax || (c == 2) && suma2 + pesos[nivel] <= pMax ){
                    solucion[nivel] = c;
                    if(c == 1){
                        suma1 += pesos[nivel];
                    } else if(c == 2){
                        suma2 += pesos[nivel];
                    }
                    distribucionCarga2Aux(pesos, pMax, nivel + 1, solucion, mejorSolucion, suma1, suma2, distancia);
                    solucion[nivel] = 0;
                    if(c == 1){
                        suma1 += pesos[nivel];
                    } else if(c == 2){
                        suma2 += pesos[nivel];
                    }
                }
            }
        }
    }
    private static boolean aceptable(int [] solucion){
        boolean correcto = true;
        int i = 0;
        while(i < solucion.length && correcto){
            if(solucion[i] == 0){
                correcto = false;
            }
            i++;
        }
        return correcto;
    }
}
