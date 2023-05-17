package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Ejercicio 5.
 * Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
 * con todos los vértices a partir de los cuales exista un camino en G que termine en v.
 *
 */
public class Ej_05_VerticesConCaminoAV {

    private Grafo grafo;
    private int v;
    private HashSet<Integer> solucion;

    public Ej_05_VerticesConCaminoAV(Grafo g, Integer v) {
        this.grafo = g;
        this.v = v;
        this.solucion = new HashSet<Integer>();
    }

    public  List<Integer> buscar() {
        if (this.grafo != null && !this.grafo.isEmpty()) {

            for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
                Integer current = it.next();

                if (!this.solucion.contains(current)) {
                    Caminos dfs_search = new Caminos(this.grafo, current, this.v, Integer.MAX_VALUE);
                    List<List<Integer>> caminos = dfs_search.caminos();

                    if (!caminos.isEmpty()) {
                        for (List<Integer> c: caminos) {
                            c.remove(c.size()-1);
                            this.solucion.addAll(c);
                        }
                    }
                }

            }
        }
        return new ArrayList(this.solucion);
    }



}
