package Prog_III_2023.tp_03.Servicios.BFS;

import Prog_III_2023.tp_03.Grafos.Grafo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Ejercicio 8
 * Dados un grafo G con sus vértices rotulados con colores y dos vértices v1 y v2, escriba un
 * algoritmo que encuentre un camino desde el vértice v1 al vértice v2 tal que no pase por
 * vértices rotulados con el color rojo.
 *
 */
public class Ej_08_CaminoEvitandoRotulos {

    private Grafo grafo;
    private String rotulo;
    private Integer origen;
    private Integer destino;

    private List<Integer> fila;
    private List<Integer> solucion;
    private HashMap<Integer, Integer> ancestros;


    public Ej_08_CaminoEvitandoRotulos(Grafo g, Integer o, Integer d, String rotulo) {
        this.grafo = g;
        this.rotulo = rotulo;
        this.origen = o;
        this.destino = d;
        this.fila = new ArrayList<Integer>();
        this.solucion = new ArrayList<Integer>();
    }

    public List<Integer> search() {
        if (this.grafo != null && !this.grafo.isEmpty()
                && this.grafo.contieneVertice(this.origen) && this.grafo.contieneVertice(this.destino)) {

            this.ancestros.put(this.origen, null);
            this.search(this.origen);

        }
        return this.solucion;
    }

    private void search(Integer v) {
        this.fila.add(v);

        while (!this.fila.isEmpty()) {
            Integer actual = this.fila.remove(0);
            for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(actual); it.hasNext(); ) {
                Integer ady = it.next();
                if (ady == this.destino) {
                    this.guardarCamino(ady);
                    return;
                } else {
//                    if (ady.getRotulo() != this.rotulo) {
                    if (!this.ancestros.containsKey(ady)) {
                        this.ancestros.put(ady, actual);
                        this.fila.add(ady);
                    }
//                    }
                }
            }
        }
    }

    private void guardarCamino(Integer ady) {
        this.solucion.add(ady);
        while (ady != null) {
            Integer ancestro = this.ancestros.get(ady);
            this.solucion.add(0, ancestro);
            ady = ancestro;
        }
    }

}
