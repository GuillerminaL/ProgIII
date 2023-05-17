package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.GrafoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Ejercicio 4
 * Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
 * camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
 * el grafo de entrada es acíclico.
 *
 */
public class Ej_04_CaminoSimpleDeMayorLongitud {

    private GrafoDirigido grafo;
    private Integer i;
    private Integer j;
    private HashMap<Integer, String> vertices;
    private List<List<Integer>> caminos;
    private List<Integer> caminoMayorLong;
    private int mayorLong;


    public Ej_04_CaminoSimpleDeMayorLongitud(GrafoDirigido g, Integer i, Integer j) {
        this.grafo = g;
        this.i = i;
        this.j = j;
        this.vertices = new HashMap<Integer, String>();
        this.caminoMayorLong = new ArrayList<Integer>();
        this.caminos = new ArrayList<List<Integer>>();
        this.mayorLong = 0;
    }

    public List<Integer> buscar() {
        if (grafo != null && !grafo.isEmpty()) {

            if (grafo.contieneVertice(i) && grafo.contieneVertice(j)) {

                //Inicializar
                for (Iterator<Integer> it = grafo.obtenerVertices(); it.hasNext(); ) {
                    this.vertices.put(it.next(), "NO_VISITADO");
                }

                this.buscar(i, 0, new ArrayList<Integer>());
                if (!caminoMayorLong.isEmpty()) caminoMayorLong.add(0, i);

            }
        }
        return caminoMayorLong;
    }

    private void buscar(Integer v, int longAcum, List<Integer> camino) {

        if (v == j) {
            if (longAcum > mayorLong) {
                this.mayorLong = longAcum;
                List<Integer> tmp = new ArrayList<Integer>();
                for (Integer i: camino) tmp.add(i);
                this.caminoMayorLong = tmp;
            }
        } else {
            vertices.put(v, "VISITANDO");
            for (Iterator<Integer> it = grafo.obtenerAdyacentes(v); it.hasNext();) {
                Integer ady = it.next();

                if (vertices.get(ady) != "VISITANDO") {
                    camino.add(ady);
                    this.buscar(ady, longAcum + 1, camino);
                    camino.remove(ady);
                }
            }
            vertices.put(v, "NO_VISITADO");
        }

    }
}
