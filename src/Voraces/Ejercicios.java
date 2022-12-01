package Voraces;

import javax.lang.model.element.PackageElement;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicios {
    public static void main(String[] args) {
        //Ej Diapositivas 1
        ArrayList<Integer> valores1 = new ArrayList<>();
        ArrayList<Moneda> solucion1 = new ArrayList<>();
        valores1.add(2);
        valores1.add(50);
        valores1.add(10);
        valores1.add(1);
        valores1.add(5);
        valores1.add(20);
        solucion1 = numMonedasDesordenadas(valores1, 120);
        System.out.print("Monedas: ");
        if(solucion1 != null){
            for(Moneda moneda : solucion1){
                System.out.print(moneda.getValor() + "(" + moneda.getCantidad() + ")" + " ");
            }
        } else { System.out.println("No hay Monedas");}

        //Sesión 1.1
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Producto> n1 = new ArrayList<>();
        ArrayList<Producto> n2 = new ArrayList<>();
        ArrayList<Producto> n3 = new ArrayList<>();
        productos.add(new Producto(1, 10));
        productos.add(new Producto(2, 5));
        productos.add(new Producto(3, 8));
        productos.add(new Producto(1, 6));
        productos.add(new Producto(1, 12));
        distribuyeCarga(productos, n1, n2, n3);
        System.out.print("\nn1: ");
        for(Producto producto : n1){
            System.out.print(producto.getPeso() + " ");
        }
        System.out.print("\nn2: ");
        for(Producto producto : n2){
            System.out.print(producto.getPeso() + " ");
        }
        System.out.print("\nn3: ");
        for(Producto producto : n3){
            System.out.print(producto.getPeso() + " ");
        }

        //Sesión 1.2
        ArrayList<Pelicula> candidatos = new ArrayList<>();
        ArrayList<Pelicula> solucion2 = new ArrayList<>();
        candidatos.add(new Pelicula("La Sirenita", "Alberto", 60, new Hora(8, 10)));
        candidatos.add(new Pelicula("Spiderman", "Diego", 120, new Hora(7, 0)));
        candidatos.add(new Pelicula("Avengers", "Carlos", 50, new Hora(9, 0)));
        solucion2 = obtenerListado(candidatos);
        System.out.print("\nPelículas: ");
        if(solucion2 != null){
            for(Pelicula pelicula : solucion2){
                System.out.print(pelicula.getTitulo() + " ");
            }
        } else { System.out.println("No hay Películas");}

        //Sesion 1.3
        int [] U = new int[]{0,1,2,3,4,5};
        ArrayList<Conjunto> S = new ArrayList<>();
        ArrayList<Conjunto> solucion3 = new ArrayList<>();
        S.add(new Conjunto(new int[]{1,2,0,3}));
        S.add(new Conjunto(new int[]{2,4}));
        S.add(new Conjunto(new int[]{3,4}));
        S.add(new Conjunto(new int[]{4,5}));
        solucion3 = conjuntoMinimo(U, S);
        System.out.print("\nConjuntos: ");
        if(solucion3 != null){
            for(Conjunto conjunto : solucion3){
                System.out.print("{");
                for(int i = 0; i < conjunto.longitud(); i++){
                    if(i != 0){ System.out.print(", ");}
                    System.out.print(conjunto.get(i));
                }
                System.out.print("} ");
            }
        } else { System.out.println("No hay Conjuntos");}

        //Examen Julio 2019
        int K = 4;
        int [] vector = new int[]{-2,0,5,-1,2};
        int [] solucion4 = vectorTransformado(vector, K);
        System.out.print("\nVector Transformado: ");
        for(int i : solucion4){
            System.out.print(i + " ");
        }

        //Examen Enero 2021
        int puntuacion1 = 80;
        ArrayList<Integer> valoresRana = new ArrayList<>(){{add(5); add(10); add(25); add(50); add(15);}};
        ArrayList<AgujeroRana> solucion5;
        solucion5 = numDiscosGreedy(valoresRana, puntuacion1);
        System.out.print("\nRanas: ");
        if(solucion5 != null){
            for(AgujeroRana rana : solucion5){
                System.out.print(rana.getValor() + "(" + rana.getCantidad() + ")" + " ");
            }
        } else { System.out.println("No hay Ranas");}

        //Examen Febrero 2021
        int modojuego = 3;
        int puntuacion2 = 96;
        ArrayList<Integer> diana = new ArrayList<Integer>() {{add(2); add (20); add(9); add(8); add(3); add(13); add(4); add(1); add(18);}};
        ArrayList<Diana> solucion6;
        solucion6 = numDardosGreedy(diana, puntuacion2, modojuego);
        System.out.print("\nDiana(" + modojuego + "): ");
        if(solucion6 != null){
            for(Diana dianaActual : solucion6){
                System.out.print(dianaActual.getValor() + "(" + dianaActual.getCantidad() + ")" + " ");
            }
        } else { System.out.println("No hay Ranas");}

        //Examen Julio 2021
        int nDiputados = 145;
        int mayoriaABS = (nDiputados / 2) + 1;
        float umbralPacto = 0.5F;
        // lista de partidos políticos
        ArrayList<Partido> misPartidos = new ArrayList<Partido>();
        ArrayList<Partido> solucion7;
        misPartidos.add(new Partido("extIZQ",10,1F));
        misPartidos.add(new Partido("muyIZQ",10,3F));
        misPartidos.add(new Partido("IZQ",50,4F));
        misPartidos.add(new Partido("Centro",5,5F));
        misPartidos.add(new Partido("Derecha",49,6F));
        misPartidos. add(new Partido("muyDerecha",10,7F));
        misPartidos.add(new Partido("extDerecha",10,10F));
        solucion7 = greedyPactometer(misPartidos, mayoriaABS, umbralPacto);
        System.out.print("\nPartidos: ");
        if(solucion7 != null){
            for(Partido partido : solucion7){
                System.out.print(partido.getNombre() + "(" + partido.getDiputados() + ")" + " ");
            }
        } else { System.out.println("No hay Ranas");}

        /*
        //Examen Enero 2022
        int maxAlumnos = 4;
        ArrayList<Estudiante> misEstudiantes = new ArrayList<>();
        ArrayList<Grupo> solucion8;
        misEstudiantes.add(new Estudiante("Alberto", "Saiz", true, 10));
        misEstudiantes.add(new Estudiante("Carlos", "Castillo", true, 9.7));
        misEstudiantes.add(new Estudiante("Lucas", "Luque", true, 8.1));
        misEstudiantes.add(new Estudiante("Paula", "SantaMaria", false, 1.3));
        misEstudiantes.add(new Estudiante("Raquel", "Tricio", false, 5));
        misEstudiantes.add(new Estudiante("Alex", "Ramos", true, 7.6));
        misEstudiantes.add(new Estudiante("Almudena", "Manzanares", false, 2.4));
        misEstudiantes.add(new Estudiante("Diego", "Vargas", true, 2.9));
        misEstudiantes.add(new Estudiante("Maria", "DelaRosa", false, 6.4));
        misEstudiantes.add(new Estudiante("Manuela", "Rodriguez", false, 5.8));
        solucion8 = mezclaEstudiantes(misEstudiantes, 4);
        System.out.print("\nGrupos: ");
        if(solucion8 != null){
            for(Grupo grupo : solucion8){
                System.out.println("{");
                for(int i = 0; i < grupo.getNumAlumnos(); i++){
                    Estudiante x = grupo.getAlumnos().get(i);
                    System.out.print(x.getNombre() + " " + x.getApellidos());
                }
                System.out.println("(" + calcularNotaMedia(grupo, maxAlumnos)  + ")" + "}");
            }
        } else { System.out.println("No hay Estudiantes");}
        */

        //Examen Julio 2022
        ArrayList<Concursante> supervivientes = new ArrayList<>();
        ArrayList<Concursante> equipo1 = new ArrayList<>();
        ArrayList<Concursante> equipo2 = new ArrayList<>();
        supervivientes.add(new Concursante(1, 45, 79, true));
        supervivientes.add(new Concursante(2, 18, 43, true));
        supervivientes.add(new Concursante(3, 20, 90, false));
        supervivientes.add(new Concursante(4, 32, 85, false));
        supervivientes.add(new Concursante(5, 41, 50, true));
        supervivientes.add(new Concursante(6, 19, 73, false));
        crearEquiposVoraz(supervivientes, equipo1, equipo2);
        System.out.print("\nEquipo 1: ");
        double suma1 = 0, suma2 = 0;
        for(Concursante concursante : equipo1){
            System.out.print(concursante.getId() + " ");
            suma1 += calcularFuerza(concursante.getEdad(), concursante.getPeso(), concursante.isGenero());
        }
        System.out.println("(" + suma1 + ")");
        for(Concursante concursante : equipo2){
            System.out.print(concursante.getId() + " ");
            suma2 += calcularFuerza(concursante.getEdad(), concursante.getPeso(), concursante.isGenero());
        }
        System.out.println("(" + suma2 + ")");
    }

    //Ej Diapositivas 1
    public static ArrayList<Moneda> numMonedasDesordenadas(ArrayList<Integer> valores, int cantidad){
        ArrayList<Moneda> solucion = new ArrayList<Moneda>();
        int valor ;
        while ((cantidad>0) &&(!valores.isEmpty())) {
            valor = seleccionarCandidatoListaDesordenada(valores);
            Integer remove = valor;
            valores.remove(remove);
            if ((cantidad/valor) > 0){
                solucion.add(new Moneda(valor, cantidad/valor));
                cantidad = cantidad % valor;
            }
        }
        if (cantidad==0) { return solucion; }
        else return null;
    }
    private static int seleccionarCandidatoListaDesordenada(ArrayList<Integer> valores){
        int mayor = Integer.MIN_VALUE;
        for (Integer moneda : valores)
            if ((mayor< moneda)) mayor = moneda;
        return mayor;
    }

    //Sesión 1.1
    public static void distribuyeCarga( ArrayList<Producto> productos, ArrayList<Producto> n1, ArrayList<Producto> n2, ArrayList<Producto> n3){

        int n1P = 0,n2P = 0,n3P = 0;
        while(!productos.isEmpty()){
            Producto producto = seleccionarMayorPesoDesordenado(productos);
            productos.remove(producto);
            if((n1P == 0) || (n1P <= n2P) && (n1P <= n3P)){
                n1.add(producto);
                n1P += producto.getPeso();
            } else if((n1P > n2P) && (n2P <= n3P)){
                n2.add(producto);
                n2P += producto.getPeso();
            } else if((n1P > n3P) && (n2P > n3P)){
                n3.add(producto);
                n3P += producto.getPeso();
            }
        }

    }
    private static Producto seleccionarMayorPesoDesordenado(ArrayList<Producto> productos){
        Producto mejor = null;
        for(Producto producto : productos){
            if((mejor == null) || (producto.getPeso() > mejor.getPeso())){
                mejor = producto;
            }
        }
        return mejor;
    }

    //Sesión 1.2
    public static ArrayList<Pelicula> obtenerListado(ArrayList<Pelicula> candidatos){
        ArrayList<Pelicula> solucion = new ArrayList<>();
        while((!candidatos.isEmpty())){
            Pelicula pelicula = seleccionarCandidato(candidatos);
            candidatos.remove(pelicula);
            if(esFactible(pelicula, solucion)){
                solucion.add(pelicula);
            }
        }

        if(solucion.size() > 0){ return solucion;}
        else return null;
    }
    private static Pelicula seleccionarCandidato(ArrayList<Pelicula> candidatos){
        Pelicula mejor = null;

        for(Pelicula pelicula : candidatos){
            if((mejor == null) || (pelicula.getFin() < mejor.getFin())){
                mejor = pelicula;
            }
        }

        return mejor;
    }
    private static boolean esFactible(Pelicula candidato, ArrayList<Pelicula> solucion){
        boolean esFactible = true;
        if(solucion.size() > 0){
            if(solucion.get(solucion.size() - 1).getFin() > candidato.getInicio()){
                esFactible = false;
            }
        }

        return esFactible;
    }

    //Sesión 1.3
    public static ArrayList<Conjunto> conjuntoMinimo(int [] U, ArrayList<Conjunto> S){
        ArrayList<Conjunto> solucion = new ArrayList<>();
        boolean [] incluidos = new boolean[U.length];

        while(!todosIncluidos(incluidos)){
            Conjunto candidato = seleccionarCandidatoConjunto(S, incluidos);
            S.remove(candidato);
            solucion.add(candidato);
            for(int i = 0; i < candidato.longitud(); i++){
                incluidos[candidato.get(i)] = true;
            }
        }

        if(!solucion.isEmpty()){ return solucion;}
        else { return null;}
    }
    private static boolean todosIncluidos(boolean [] incluidos){
        boolean ok = true;
        int i = 0;
        while(ok && i < incluidos.length){
            ok = incluidos[i];
            i++;
        }

        return ok;
    }
    private static Conjunto seleccionarCandidatoConjunto(ArrayList<Conjunto> S, boolean [] incluidos){
        Conjunto mejorCandidato = null;
        int mejor = 0, actual;

        for(Conjunto conjunto : S){
            actual = contarDistintos(conjunto, incluidos);
            if(mejorCandidato == null || actual > mejor){
                mejorCandidato = conjunto;
                mejor = actual;
            }
        }

        return mejorCandidato;
    }
    private static int contarDistintos(Conjunto conjunto, boolean [] incluidos){
        int num = 0;
        for(int i = 0; i < conjunto.longitud(); i++){
            if(!incluidos[conjunto.get(i)]){
                num++;
            }
        }
        return num;
    }

    //Examen Julio 2019
    public static int[] vectorTransformado(int [] vector, int K){
        int [] solucion = new int[vector.length];
        for(int i = 0; i < vector.length; i++){ solucion[i] = vector[i];}
        int i = 0;
        while(i < K){
            int canditato = seleccionarCandidatoMenor(solucion);
            for(int j = 0; j < vector.length; j++){
                if(solucion[j] == canditato){
                    solucion[j] = canditato * (-1);
                }
            }
            i++;
        }

        return solucion;
    }
    private static int seleccionarCandidatoMenor(int [] vector){
        int menor = Integer.MAX_VALUE;
        for(int i : vector){
            if(i < menor) {
                menor = i;
            }
        }

        return menor;
    }

    //Examen Enero 2021
    public static ArrayList<AgujeroRana> numDiscosGreedy(ArrayList<Integer> valoresRana, int puntuacion){
        ArrayList<AgujeroRana> solucion = new ArrayList<>();
        while((!valoresRana.isEmpty()) && puntuacion > 0){
            int candidato = seleccionarCandidatoRana(valoresRana);
            valoresRana.remove(Integer.valueOf(candidato));
            if((puntuacion / candidato) > 0){
                solucion.add(new AgujeroRana(candidato, puntuacion / candidato));
                puntuacion = puntuacion % candidato;
            }
        }

        if(!solucion.isEmpty()){ return solucion;}
        else return null;
    }
    private static int seleccionarCandidatoRana(ArrayList<Integer> valoresRana){
        int mayor = Integer.MIN_VALUE;
        for(Integer i : valoresRana){
            if(i > mayor){
                mayor = i;
            }
        }
        return mayor;
    }

    //Examen Febrero 2021
    public static ArrayList<Diana> numDardosGreedy(ArrayList<Integer> valores, int puntuacion, int modo){
        ArrayList<Diana> solucion = new ArrayList<>();
        while(!valores.isEmpty() && puntuacion > 0){
            int candidato = seleccionarCandidatoDardo(valores);
            int valor = candidato * modo;
            valores.remove(Integer.valueOf(candidato));
            if(puntuacion / valor > 0){
                solucion.add(new Diana(candidato, puntuacion / valor, modo));
                puntuacion = puntuacion % valor;
            }
        }

        if(!solucion.isEmpty()){ return solucion;}
        else return null;
    }
    private static int seleccionarCandidatoDardo(ArrayList<Integer> valores){
        int mayor = Integer.MIN_VALUE;
        for(Integer i : valores){
            if(i > mayor){
                mayor = i;
            }
        }
        return mayor;
    }

    //Examen Julio 2021
    public static ArrayList<Partido> greedyPactometer(ArrayList<Partido> misPartidos, int mayoriaABS, float umbralPacto){
        ArrayList<Partido> solucion = new ArrayList<>();
        Partido mayorNumDiputados = seleccionarPartidoGobierno(misPartidos);
        misPartidos.remove(mayorNumDiputados);
        solucion.add(mayorNumDiputados);
        mayoriaABS -= mayorNumDiputados.getDiputados();

        while(!misPartidos.isEmpty() && mayoriaABS > 0){
            Partido candidato = seleccionarCandidatoPartido(misPartidos, mayorNumDiputados);
            misPartidos.remove(candidato);
            if(candidato.Perjuicio(mayorNumDiputados) < umbralPacto){
                solucion.add(candidato);
                mayoriaABS -= candidato.getDiputados();
            }
        }

        if(!solucion.isEmpty()){ return solucion;}
        else return null;
    }
    private static Partido seleccionarPartidoGobierno(ArrayList<Partido> misPartidos){
        Partido mayorDiputados = null;
        int mayor = Integer.MIN_VALUE;

        for(Partido partido : misPartidos){
            if(mayorDiputados == null || partido.getDiputados() > mayor){
                mayorDiputados = partido;
                mayor = partido.getDiputados();
            }
        }
        return mayorDiputados;
    }
    private static Partido seleccionarCandidatoPartido(ArrayList<Partido> partidos, Partido partidoPrincipal){
        Partido p = null;
        float perjuicioMejor = Integer.MAX_VALUE;

        for(Partido partido : partidos){
            if(p == null || partidoPrincipal.Perjuicio(partido) < perjuicioMejor){
                p = partido;
                perjuicioMejor = partidoPrincipal.Perjuicio(partido);
            } else if(partidoPrincipal.Perjuicio(partido) == perjuicioMejor){
                if(partido.getDiputados() > p.getDiputados()){
                    p = partido;
                    perjuicioMejor = partidoPrincipal.Perjuicio(partido);
                }
            }
        }

        return p;
    }


    //Examen Enero 2022
    /*
    public static ArrayList<Grupo> mezclaEstudiantes(ArrayList<Estudiante> listaEst, int maxAlumnos) {
        ArrayList<Grupo> solucion = new ArrayList<>();
        int numGrupos = listaEst.size() / maxAlumnos;
        Grupo [] grupos = new Grupo[numGrupos];
        for(int i = 0; i < grupos.length; i++){
            grupos[i] = new Grupo(new ArrayList<>(), maxAlumnos, 0);
        }

        while(!listaEst.isEmpty()){
            Estudiante candidato = seleccionarCandidatoEstudiante(listaEst);
            listaEst.remove(candidato);
            int grupoMenorMedia = grupoMenorNotaMedia(solucion, maxAlumnos);
            grupos[grupoMenorMedia].getAlumnos().add(candidato);
            grupos[grupoMenorMedia].setNumAlumnos(grupos[grupoMenorMedia].getNumAlumnos() + 1);
        }

        for(int i = 0; i < grupos.length; i++){
            solucion.add(grupos[i]);
        }

        if(!solucion.isEmpty()){ return solucion;}
        else return null;
    }
    private static Estudiante seleccionarCandidatoEstudiante(ArrayList<Estudiante> listaEst){
        Estudiante mejor = null;
        double mejorNota = Double.MAX_VALUE;

        for(Estudiante estudiante : listaEst){
            if(mejor == null || estudiante.getNota() > mejorNota){
                mejor = estudiante;
                mejorNota = estudiante.getNota();
            }
        }

        return mejor;
    }
    private static int calcularNotaMedia(Grupo grupo, int maxAlumnos){
        int sumaNota = 0;

        for(Estudiante estudiante : grupo.getAlumnos()){
            sumaNota += estudiante.getNota();
        }

        return sumaNota / maxAlumnos;
    }
    private static int grupoMenorNotaMedia(ArrayList<Grupo> grupos, int maxAlumnos){
        int grupoMenorMedia = -1;
        double menorNotaMedia = Double.MAX_VALUE;

        for(int i = 0; i < grupos.size(); i++){
            Grupo grupo = grupos.get(i);
            if(grupoMenorMedia == -1 || calcularNotaMedia(grupo, maxAlumnos) < menorNotaMedia){
                grupoMenorMedia = i;
                menorNotaMedia = calcularNotaMedia(grupo, maxAlumnos);
            }
        }

        return grupoMenorMedia;
    }
     */

    //Examen Julio 2022
    public static void crearEquiposVoraz(ArrayList<Concursante> supervivientes, ArrayList<Concursante> equipo1, ArrayList<Concursante> equipo2){
        double fuerza1 = 0, fuerza2 = 0;

        while(!supervivientes.isEmpty()){
            Concursante candidato = seleccionarCandidatoConcursante(supervivientes);
            supervivientes.remove(candidato);
            double fuerza = calcularFuerza(candidato.getEdad(), candidato.getPeso(), candidato.isGenero());
            if(fuerza1 <= fuerza2){
                equipo1.add(candidato);
                fuerza1 += fuerza;
            } else {
                equipo2.add(candidato);
                fuerza2 += fuerza;
            }
        }
    }
    private static Concursante seleccionarCandidatoConcursante(ArrayList<Concursante> supervivientes){
        Concursante masFuerte = null;
        double masFuerza = Double.MIN_VALUE;

        for(Concursante concursante : supervivientes){
            double fuerza = calcularFuerza(concursante.getEdad(), concursante.getPeso(), concursante.isGenero());
            if(masFuerte == null || fuerza > masFuerza){
                masFuerte = concursante;
                masFuerza = fuerza;
            }
        }

        return masFuerte;
    }
    private static double calcularFuerza(int edad, int peso, boolean genero){
        double g;
        if(!genero) { g = 1.3;}
        else { g = 1;}

        return  (double) 1 / edad * 1 / peso * g;
    }

}
