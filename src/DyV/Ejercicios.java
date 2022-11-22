package DyV;

public class Ejercicios {
    public static void main(String [] args){
        int [] vector1 = new int []{-1,0,2,3,10,12,-23,-24,-7}; //Sesión 1.1
        int [] vector2 = new int []{1,1,4,5,5,7,7,8,8,9,9}; //Sesión 1.2
        int [] vector3 = new int []{2,5,8,9,22,34,45,98,101}; //Examen 2022
        int [] vector4 = new int []{4,7,23,34,45,56,67,78,89}; //Examen 2022
        int [] vector5 = new int []{-4,-2,0,1,1,2,3,4,-9}; //Examen 2021
        int [] vector6 = new int []{-4,-2,0,1,1,5,7,10,-6}; //Examen 2021
        int [] vector7 = new int []{-5,-2,-9,-4,1,5,7,0,-3}; //Examen 2020 Junio
        int [] vector8 = new int []{8,-1,2,4,2,-2,1,0,1}; //Examen 2020 Junio
        int [] vector9 = new int []{5,7,8,9,3,2,1,0,-7}; //Examen 2020 Diciembre
        int [] vector10 = new int []{1,2,2,3,3,4,0,0,1}; //Examen 2019
        int [] vector11 = new int []{10,15,23,32,1,2,3,4,7}; //Examen 2018
        int [] vector12 = new int []{-10,-2,0,3,7,9,19,28,30,42,55}; //Sesión 1.3
        int [] vector13 = new int []{10,5,-16,1,8,12,5,-20,16,2}; //Máx suma de subarrays

        System.out.println("Sesión 1.1: " + sumaPositivos(vector1));
        System.out.println("Sesión 1.2: " + elementoSolitario(vector2));
        System.out.println("Exámen 2022(Ej 1): " + parImpar(vector3));
        System.out.println("Exámen 2022(Ej 2): " + parImpar(vector4));
        System.out.println("Exámen 2021: " + ejDyV(vector5,vector6));
        System.out.println("Exámen 2020 Junio: " + Check2pos(vector7,vector8, -1));
        System.out.println("Exámen 2020 Diciembre: " + maxArrayColina(vector9));
        System.out.println("Exámen 2019: " + elementoEspecial(vector10));
        System.out.println("Exámen 2018: " + minArrayRotado(vector11));
        System.out.println("Sesión 1.3: " + elementoEspecial2(vector12));
        System.out.println("Subarray con Mayor suma: " + maxSubArraySuma(vector13));
    }

    //Sesión 1.1
    public static int sumaPositivos(int [] vector){
        return sumaPositivosAux(vector, 0, vector.length - 1);
    }
    private static int sumaPositivosAux(int [] vector,int i0,int iN){
        if(i0 == iN){
            if(vector[i0]  > 0) {
                return vector[i0];
            } else {
                return 0;
            }
        } else {
            int k = (i0 + iN)/2;
            int x = sumaPositivosAux(vector,i0,k);
            int i = sumaPositivosAux(vector,k + 1,iN);
            return x + i;
        }
    }

    //Sesión 1.2
    public static int elementoSolitario(int [] vector){
        return elementoSolitarioAux(vector, 0, vector.length - 1);
    }
    private static int elementoSolitarioAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else {
            int k = (i0 + iN)/2;
            if(vector[k-1] == vector[k]){
                if(((k-2)- i0) % 2 == 0){
                    return elementoSolitarioAux(vector,i0,k-2);
                } else {
                    return elementoSolitarioAux(vector, k+1, iN);
                }
            } else if(vector[k] == vector[k+1]){
                if((iN-(k+2)) % 2 == 0){
                    return elementoSolitarioAux(vector,k+2,iN);
                } else {
                    return elementoSolitarioAux(vector, i0, k-1);
                }

            } else {
                return vector[k];
            }
        }
    }

    //Examen 2022
    public static int parImpar(int [] vector){
        return parImparAux(vector, 0, vector.length - 1);
    }
    private static int parImparAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return i0;
        } else {
            int k = (i0 + iN) / 2;
            if(esPar(k) && esPar(vector[k]) || !esPar(k) && !esPar(vector[k])){
                return parImparAux(vector,k+1,iN);
            } else {
                return parImparAux(vector,i0,k);
            }
        }



    }
    private static boolean esPar(int n){
        return n % 2 == 0;
    }

    //Examen 2021
    public static int ejDyV(int [] vector1, int [] vector2){
        return ejDyVAux(vector1, vector2, 0, vector1.length - 1);
    }
    private static int ejDyVAux(int [] vector1, int [] vector2, int i0, int iN){
        if(i0 == iN){
            if(vector1[i0] == vector2[i0]){
                return -1;
            } else {
                return i0;
            }
        } else {
            int k = (i0 + iN) / 2;
            if(vector1[k] == vector2[k]){
                return ejDyVAux(vector1, vector2, k+1, iN);
            } else {
                return ejDyVAux(vector1, vector2, i0, k);
            }
        }
    }

    //Examen 2020 Junio
    public static boolean Check2pos(int [] vector1, int [] vector2, int v){
        int i = 0;
        boolean stop = false;
        mergeSort(vector2);
        while(!stop && i < vector1.length){
            stop = Check2posAux(vector2, v, vector1[i], 0, vector2.length - 1);
            i++;
        }
        return stop;
    }
    private static boolean Check2posAux(int [] vector2, int valor, int v1, int i0, int iN){
        if(i0 == iN){
            return valor == (v1 + vector2[i0]);
        } else {
            int k = (i0 + iN) / 2;
            if(vector2[k] + v1 == valor){
                return true;
            } else if (vector2[k] + v1 < valor){
                return Check2posAux(vector2, valor, v1, k+1, iN);
            } else {
                return Check2posAux(vector2, valor, v1, i0, k);
            }
        }
    }
    private static void mergeSort(int [] vector){
        mergeSortAux(vector, 0, vector.length - 1);
    }
    public static void mergeSortAux(int [] vector, int i0, int iN){
        if(i0 >= iN){
            return;
        } else {
            int k = (i0 + iN) / 2;
            mergeSortAux(vector, i0, k);
            mergeSortAux(vector, k+1, iN);
            merge(vector, i0, k, iN);
        }

    }
    private static void merge(int [] vector, int i0, int k, int iN){
        int i = i0, d = k+1, f = 0;
        int [] aux = new int[iN - i0 + 1];
        while(i <= k && d <= iN){
            if(vector[i] <= vector[d]){
                aux[f] = vector[i];
                i++;
                f++;
            } else {
                aux[f] = vector[d];
                d++;
                f++;
            }
        }
        for(int a = i; a <= k; a++){aux[f] = vector[a]; f++;}
        for(int a = d; d <= iN; d++){aux[f] = vector[a]; f++;}
        for(int a = 0; a < aux.length; a++){vector[i0+a] = aux[a];}
    }

    //Examen 2020 Diciembre
    public static int maxArrayColina(int [] vector){
        return maxArrayColinaAux(vector, 0, vector.length - 1);
    }
    private static int maxArrayColinaAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else if(vector.length == 2){
            return Math.max(vector[0], vector[1]);
        } else {
            int k = (i0 + iN) / 2;
            if(vector[k] < vector[k+1]) {
                return maxArrayColinaAux(vector, k, iN);
            } else if(vector[k-1] < vector[k]){
                return vector[k];
            } else {
                return maxArrayColinaAux(vector, i0, k);
            }
        }
    }

    //Examen 2019
    public static int elementoEspecial(int [] vector){
        if(vector.length == 1){
            return vector[0];
        } else {
            if(vector[0] == vector[vector.length - 1]){
                return elementoEspecialAux(vector, 1 , vector.length - 2);
            } else {
                return elementoEspecialAux(vector, 0 , vector.length - 1);
            }
        }
    }
    private static int elementoEspecialAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else {
            int k = (i0 + iN) / 2;
            if(vector[k] == vector[k+1]){
                if((k-1-i0) % 2 == 0){
                    return elementoEspecialAux(vector, i0,k-1);
                } else {
                    return elementoEspecialAux(vector, k+2,iN);
                }
            } else if(vector[k-1] == vector[k]){
                if((k-2-i0) % 2 == 0){
                    return elementoEspecialAux(vector, i0, k-2);
                } else {
                    return elementoEspecialAux(vector, k+1,iN);
                }
            } else {
                return vector[k];
            }
        }
    }

    //Examen 2018
    public static int minArrayRotado(int [] vector){
        if(vector[0] < vector[vector.length - 1]){
            return vector[0];
        } else {
            return minArrayRotadoAux(vector, 0, vector.length - 1);
        }
    }
    private static int minArrayRotadoAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else {
            int k = (i0 + iN) / 2;
            if(vector[k-1] > vector[k] && vector[k] < vector[k+1]){
                return vector[k];
            } else if(vector[0] > vector[k]){
                return minArrayRotadoAux(vector,i0,k);
            } else {
                return minArrayRotadoAux(vector, k+1, iN);
            }
        }
    }

    //Sesión 1.3
    public static int elementoEspecial2(int [] vector){
        return elementoEspecial2Aux(vector, 0, vector.length - 1);
    }
    private static int elementoEspecial2Aux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else {
            int k = (i0 + iN) / 2;
            if(vector[k] == k) {
                return k;
            } else if(vector[k] > k){
                return elementoEspecial2Aux(vector, i0, k);
            } else {
                return elementoEspecial2Aux(vector, k+1, iN);
            }
        }
    }

    //Sesión 1.4
    public static int maxSubArraySuma(int [] vector){
        return maxSubArraySumaAux(vector, 0, vector.length - 1);
    }
    private static int maxSubArraySumaCruzada(int [] vector, int i0, int k, int iN){
        int i = k, j = k+1, suma = 0, sumaMax = Integer.MIN_VALUE;
        while(i < i0){
            suma += vector[i];
            if(suma > sumaMax){
                sumaMax = suma;
            }
            i--;
        }
        suma = sumaMax;
        while(j < iN){
            suma += vector[j];
            if(suma > sumaMax){
                sumaMax = suma;
            }
            j++;
        }

        return sumaMax;
    }
    private static int maxSubArraySumaCruzada2(int [] vector, int i0, int k, int iN){
        int suma = 0, sumaMax = Integer.MIN_VALUE;
        for(int i = k; i < i0; i--){
            suma += vector[i];
            if(suma > sumaMax){
                sumaMax = suma;
            }
        }
        suma = sumaMax;
        for(int j = k+1; j < iN; j++){
            suma += vector[j];
            if(suma > sumaMax){
                sumaMax = suma;
            }
        }

        return sumaMax;
    }
    private static int maxSubArraySumaAux(int [] vector, int i0, int iN){
        if(i0 == iN){
            return vector[i0];
        } else {
            int k = (i0 + iN) / 2;
            int s1 = maxSubArraySumaAux(vector, i0, k);
            int s2 = maxSubArraySumaAux(vector, k+1, iN);
            int s3 = maxSubArraySumaCruzada(vector, i0, k, iN);

            return Math.max(s1, Math.max(s2,s3));
        }
    }
}
