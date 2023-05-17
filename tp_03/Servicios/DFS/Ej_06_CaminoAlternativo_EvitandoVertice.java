package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Ejercicio 6.
 * Supongamos una conexión entre computadoras (1, ... ,n) que se encuentra modelada
 * mediante un grafo. Se requiere, si existe, dar una conexión entre dos computadoras a y b
 * existentes sabiendo que la computadora i está fuera de servicio.
 */
public class Ej_06_CaminoAlternativo_EvitandoVertice {

    private Grafo grafo;
    private Integer origen;
    private Integer destino;
    private Integer out;

    private List<Integer> solucion;
    private HashMap<Integer, Boolean> vertices;

    public Ej_06_CaminoAlternativo_EvitandoVertice(Grafo g, Integer o, Integer d, Integer i) {
        this.grafo = g;
        this.origen = o;
        this.destino = d;
        this.out = i;
        this.solucion = new ArrayList<Integer>();
        this.vertices = new HashMap<Integer, Boolean>();
    }

    /**
     * Retorna, de todos los caminos existentes de origen a destino sin pasar i, si hay, el más corto.
     * Sin embargo, podría retornar el primero que encuentre para hacerlo más performante, o bien hacer un bfs para
     * simplificar la búsqueda del más corto)
     */
    public List<Integer> search() {
        if (this.origen != out && this.destino != out) {

            for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
                this.vertices.put(it.next(), false);
            }

            List<Integer> camino = new ArrayList<Integer>();
            camino.add(this.origen);
            search(this.origen, camino);
        }
        return this.solucion;
    }

    private void search(Integer v, List<Integer> camino) {

            if(v == this.destino) {
                if (this.solucion.isEmpty() || camino.size() < this.solucion.size()) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    for (Integer i: camino) tmp.add(i);
                    this.solucion = tmp;
                }
            } else {

                this.vertices.put(v, true);
                for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(v); it.hasNext();) {
                    Integer ady = it.next();
                    if (ady != this.out && !this.vertices.get(ady)) {
                        camino.add(ady);
                        this.search(ady, camino);
                        camino.remove(ady);
                    }
                }
                this.vertices.put(v, false);

            }
        }

}
