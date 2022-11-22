package Backtracking;

public class Ejercicios {

    public static void main(String [] srg){
        Booleano exito1 = new Booleano(false);
        Booleano exito2 = new Booleano(false);
        Booleano exito3 = new Booleano(false);
        int [] solucion1 = new int[3]; //Ej 1
        int [] vector1 = new int[] {13, 11, 7}; //Ej 1
        int [] vector2 = new int[] {3,3,6,3,3}; //Ej 1.1
        int [] vector3 = new int []{4,2,5,5,1,8}; //Ej 1.2
        int [][] tablero1 = new int[6][6]; //Ej 2
        int [] damas = new int[4]; //Ej 3
        /*
        subconjuntosSumaBack(vector1, 20, solucion1, 0, exito1); //Ej 1
        viajeCaballero(tablero1, 2, 0, 0, exito2); //Ej 2
        reinas(damas, 0, exito3); //Ej 3
        */
        System.out.println("Ej 1: " + exito1.getValor());
        System.out.println("Ej 2: " + exito2.getValor());
        System.out.println("Ej 3: " + exito3.getValor());
        System.out.println("Ej 1.1: " + hayRepartoEquitativo(vector2)); //Ej 1.1
        System.out.println("Ej 1.2: " + dosSubconjuntos(vector3,10)); //Ej 1.2

    }

    //Ej 1
    public static void subconjuntosSumaBack(int [] vector, int num, int [] solucion, int nivel, Booleano exito){
        if(nivel == vector.length){
            if(suma(solucion, vector, nivel) == num){
                exito.setValor(true);
            }
        } else {
            int c = 0;
            while(!exito.getValor() && c < 2){
                if(c == 0 || suma(solucion, vector, nivel) + vector[nivel] <= num){
                    solucion[nivel] = c;
                    nivel += 1;
                    subconjuntosSumaBack(vector, num, solucion, nivel, exito);
                    if(!exito.getValor()){
                        nivel -= 1;
                        solucion[nivel] = 0;
                    }
                }
                c++;
            }

        }
    }
    private static int suma(int [] solucion, int [] vector, int nivel){
        int suma = 0;
        for(int i = 0; i < nivel; i++){
            if(solucion[i] == 1){
                suma += vector[i];
            }
        }
        return suma;
    }

    //Ej 2
    public static void viajeCaballero(int [][] tablero, int numMov, int x, int y, Booleano exito){
        if(numMov > (tablero.length*tablero.length)){
            exito.setValor(true);
        } else {
            int c = 0, u, v;
            int [] dx = new int[]{-1,2,-2,-2,-1,1,2,2,1};
            int [] dy = new int[]{-2,-1,1,2,2,1,-1,-2};
            while(!exito.getValor() && c < 8){
                u = x + dx[c];
                v = y + dy[c];
                if(u >= 0 && u < tablero.length && v >= 0 && v < tablero.length && tablero[u][v] == 0){
                    tablero[u][v] = numMov;
                    numMov++;
                    viajeCaballero(tablero, numMov, u, v, exito);
                    if(!exito.getValor()){
                        numMov--;
                        tablero[u][v] = 0;
                    }
                }
                c++;
            }
        }
    }

    //Ej 3
    public static void reinas(int [] damas, int fila, Booleano exito){
        if(fila == damas.length){
            exito.setValor(true);
        } else {
            int c = 0;
            while((!exito.getValor()) && (c < damas.length)){
                if(aceptable(damas, fila, c)){
                    damas[fila] = c;
                    fila++;
                    reinas(damas, fila, exito);
                    if(!exito.getValor()){
                        fila--;
                    }
                }
                c++;
            }
        }
    }
    private static boolean aceptable(int [] damas, int fila, int c){
        boolean resultado = true;
        int i = 0;
        while(resultado && i < fila){
            resultado = (damas[i] != c) && (Math.abs(damas[i] - c) != Math.abs(i - fila));
            i++;
        }
        return resultado;
    }

    //Ej 1.1
    public static boolean hayRepartoEquitativo(int [] bienes){
        Booleano exito = new Booleano(false);
        int suma = 0, num;

        for(int i = 0; i < bienes.length; i++){
            suma += bienes[i];
        }
        if(suma % 3 == 0){
            num = suma / 3;
            hayRepartoEquitativoAux1(bienes, new int [3], num, 0, exito);
            hayRepartoEquitativoAux2(bienes, new int []{num, num, num}, 0, exito);
        }

        return exito.getValor();
    }
    private static void hayRepartoEquitativoAux1(int [] bienes, int [] sumas, int num, int nivel, Booleano exito){
        if((nivel == bienes.length)){
            if((sumas[0] == num) && (sumas[1] == num) && (sumas[2] == num)){
                exito.setValor(true);
            }
        } else {
            int c = 0;

            while(!exito.getValor() && c < 3){
                if(sumas[c] + bienes[nivel] <= num){
                    sumas[c] += bienes[nivel];
                    hayRepartoEquitativoAux1(bienes, sumas, num, nivel + 1, exito);
                    if(!exito.getValor()){
                        sumas[c] -= bienes[nivel];
                    }
                }
                c++;
            }
        }
    }
    private static void hayRepartoEquitativoAux2(int [] bienes, int [] sumas, int nivel, Booleano exito){
        if((nivel == bienes.length)){
            if((sumas[0] == 0) && (sumas[1] == 0) && (sumas[2] == 0)){
                exito.setValor(true);
            }
        } else {
            int c = 0;

            while(!exito.getValor() && c < 3){
                if(sumas[c] - bienes[nivel] >= 0){
                    sumas[c] -= bienes[nivel];
                    hayRepartoEquitativoAux2(bienes, sumas, nivel + 1, exito);
                    if(!exito.getValor()){
                        sumas[c] += bienes[nivel];
                    }
                }
                c++;
            }
        }
    }


    //Ej 1.2
    public static boolean dosSubconjuntos(int [] v, int vObjetivo){
        Booleano exito = new Booleano(false);
        dosSubconjuntosAux(v, vObjetivo, 0, 0, 0, exito);

        return exito.getValor();
    }
    private static void dosSubconjuntosAux(int [] v, int vObjetivo, int suma1, int suma2, int nivel, Booleano exito){
        if(suma1 == vObjetivo && suma2 == vObjetivo){
            exito.setValor(true);
        } else if(nivel < v.length){
            int c = 0;

            while(!exito.getValor() && c < 3){
                if(c == 1 && suma1 + v[nivel] <= vObjetivo){
                    suma1 += v[nivel];
                } else if(c == 2 && suma2 + v[nivel] <= vObjetivo){
                    suma2 += v[nivel];
                }
                dosSubconjuntosAux(v, vObjetivo, suma1, suma2, nivel + 1, exito);
                if(!exito.getValor()){
                    if(c == 1){
                        suma1 -= v[nivel];
                    } else if(c == 2){
                        suma2 -= v[nivel];
                    }
                }
                c++;
            }
        }

    }

}
