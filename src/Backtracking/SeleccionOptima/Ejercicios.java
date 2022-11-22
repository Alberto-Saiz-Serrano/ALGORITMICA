package Backtracking.SeleccionOptima;

public class Ejercicios {
    public static void main(String [] args){
        int [] pesos = new int []{3,7,2}; //Ej 1
        int [] valores1 = new int []{21,37,35}; //Ej 1
        int [] resultado1 = mochilaOptima(pesos, valores1, 10); //Ej 1
        int [] valores2 = new int []{1,10,5}; //Ej 2
        int [] resultado2 = monedaOptima(valores2, 12); //Ej 2
        int [] comienzo = new int []{5,2,4,2,6,0,6,2}; //Ej 1.3
        int [] fin = new int []{9,4,5,5,7,3,8,5}; //Ej 1.3
        boolean [] resultado3 = maxUsoRecurso(comienzo, fin); //Ej 3
        int [] valores4 = new int []{-4,3,5,-5,0,1,8,10,-21}; //Ej 1.4
        boolean [] resultado4 = subcSuma0MaxElem(valores4); //Ej 1.4

        System.out.print("Ej 1: ");
        for(int i = 0; i < resultado1.length; i++){
            System.out.print(resultado1[i] + " ");
        }
        //For each
        /*for(int i:mochilaOptima(pesos, valores, 10)){
            System.out.println(i + " ");
        }
        */

        System.out.print("\nEj 2: ");
        for(int i = 0; i < resultado2.length; i++){
            System.out.print(resultado2[i] + " ");
        }
        //For each
        /*for(int i:monedaOptima(pesos, valores, 10)){
            System.out.println(i + " ");
        }
        */
        System.out.print("\nEj 1.3: ");
        for(int i = 0; i < resultado3.length; i++){
            System.out.print(resultado3[i] + " ");
        }
        //For each
        /*for(int i:subcSuma0MaxElem(valores4)){
            System.out.println(i + " ");
        }
        */
        System.out.print("\nEj 1.4: ");
        for(int i = 0; i < resultado4.length; i++){
            System.out.print(resultado4[i] + " ");
        }
        //For each
        /*for(int i:subcSuma0MaxElem(valores4)){
            System.out.println(i + " ");
        }
        */
    }

    //Ej 1
    public static int [] mochilaOptima(int [] pesos, int [] valores, int maxPeso){
        Entero valorMejor = new Entero(0);
        int [] solucion = new int [pesos.length];
        mochilaOptimaAux(pesos, valores, maxPeso, 0, new int[pesos.length], 0, 0, solucion, valorMejor);
        return solucion;
    }
    private static void mochilaOptimaAux(int [] pesos, int [] valores, int maxPeso, int nivel, int [] solucion, int valorActual, int pesoActual, int [] mejorSolucion, Entero valorMejor){
        if(nivel == pesos.length){
            if(valorActual > valorMejor.getValor()){
                valorMejor.setValor(valorActual);
                for(int i = 0; i < solucion.length; i++){
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {
            for(int c = 0; c < 2; c++){
                if(c == 0 || pesoActual + pesos[nivel] <= maxPeso){
                    solucion[nivel] = c;
                    pesoActual += (pesos[nivel] * c);
                    valorActual += (valores[nivel] * c);
                    mochilaOptimaAux(pesos, valores, maxPeso, nivel + 1, solucion, valorActual, pesoActual, mejorSolucion, valorMejor);
                    solucion[nivel] = 0;
                    pesoActual -= (pesos[nivel] * c);
                    valorActual -= (valores[nivel] * c);
                }
            }
        }
    }

    //Ej 2
    public static int[] monedaOptima(int [] valores, int cambio){
        Entero valorMejor = new Entero(Integer.MAX_VALUE);
        int [] mejorSolucion = new int [valores.length];
        monedaOptimaAux(valores, cambio, 0, new int [valores.length], mejorSolucion, 0, 0, valorMejor);
        return mejorSolucion;
    }
    private static void monedaOptimaAux(int [] valores, int cambio, int nivel, int [] solucion, int [] mejorSolucion, int numMonedas, int valorActual, Entero valorMejor){
        if(valorActual == cambio){
            if(numMonedas < valorMejor.getValor()){
                valorMejor.setValor(numMonedas);
                for(int i = 0; i < mejorSolucion.length; i++){
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else if(nivel < valores.length){
            for(int c = 0; c <= cambio / valores[nivel]; c++){
                if(c == 0 || valorActual + valores[nivel] <= cambio){
                    solucion[nivel] = c;
                    valorActual += (valores[nivel] * c);
                    numMonedas += c;
                    if(numMonedas < valorMejor.getValor()){
                        monedaOptimaAux(valores, cambio, nivel + 1, solucion, mejorSolucion, numMonedas, valorActual, valorMejor);
                    }
                    numMonedas -= c;
                    solucion[nivel] = 0;
                    valorActual -= (valores[nivel] * c);
                }
            }
        }
    }

    //Ej 1.3
    public static boolean [] maxUsoRecurso(int [] comienzo, int [] fin){
        Entero valorMejor = new Entero(0);
        boolean [] mejorSolucion = new boolean [comienzo.length];
        boolean [] solucion = new boolean [comienzo.length];
        maxUsoRecursoAux(comienzo, fin, solucion, mejorSolucion, 0, 0, valorMejor);
        return mejorSolucion;
    }
    private static void maxUsoRecursoAux(int [] comienzo, int [] fin, boolean [] solucion, boolean [] mejorSolucion, int rango, int nivel, Entero rangoMejor){
        if(nivel == comienzo.length){
            if(rango > rangoMejor.getValor()){
                rangoMejor.setValor(rango);
                for(int i = 0; i < solucion.length; i++){
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {
            for(int c = 0; c < 2; c++){
                if(c == 0 || aceptable(solucion, comienzo, fin, nivel)){
                    solucion[nivel] = (c == 1);
                    rango += (fin[nivel] - comienzo[nivel]) * c;
                    maxUsoRecursoAux(comienzo, fin, solucion, mejorSolucion, rango, nivel + 1, rangoMejor);
                    solucion[nivel] = false;
                    rango -= (fin[nivel] - comienzo[nivel]) * c;
                }
            }
        }
    }
    private static boolean aceptable(boolean [] solucion, int [] comienzo, int [] fin, int nivel){
        boolean resul = true;
        int i = 0;

        while(resul && i < nivel){
            if(solucion[i]){
                resul = comienzo[i] >= fin[nivel] || comienzo[nivel] >= fin[i];
            }
            i++;
        }

        return resul;
    }

    //Ej 1.4
    public static boolean [] subcSuma0MaxElem(int [] v){
        boolean [] solucion = new boolean[v.length];
        boolean [] mejorSolucion = new boolean[v.length];
        Entero valor = new Entero(Integer.MIN_VALUE);
        for(int i = 0; i < v.length; i++){
            solucion[i] = false;
            mejorSolucion[i] = false;
        }
        subSuma0MaxElemAux(v, solucion, mejorSolucion, 0, 0, 0, valor);
        return mejorSolucion;
    }
    private static void subSuma0MaxElemAux(int [] valores, boolean [] solucion, boolean [] mejorSolucion, int nivel, int numerosUsados, int suma, Entero valor){
        if(nivel == valores.length){
            if(suma == 0 && numerosUsados > valor.getValor()){
                valor.setValor(numerosUsados);
                for(int i = 0; i < solucion.length; i++){
                    mejorSolucion[i] = solucion[i];
                }
            }
        } else {
            for(int c = 0; c < 2; c++){
                if(c == 1){
                    solucion[nivel] = true;
                    numerosUsados ++;
                }
                suma += (valores[nivel] * c);
                subSuma0MaxElemAux(valores, solucion, mejorSolucion, nivel + 1, numerosUsados, suma, valor);
                if(c == 1){
                    solucion[nivel] = false;
                    numerosUsados--;
                }
                suma -= (valores[nivel] * c);
            }
        }
    }
}
