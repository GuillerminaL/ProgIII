package Prog_III_2023.tp_03.Servicios.BasicSearchAlgorithms;

import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BFS {

    private HashMap<Integer, Boolean> vertices;
    private List<Integer> list;

    public BFS() {
        this.vertices = new HashMap<Integer, Boolean>();
        this.list = new ArrayList<Integer>();
    }

    public void bfs(Grafo g) {
        if (g == null) return;

        this.list.clear();

        for (Iterator<Integer> it = g.obtenerVertices(); it.hasNext();) {
            this.vertices.put(it.next(), false);
        }

        for (Iterator<Integer> it = this.vertices.keySet().iterator(); it.hasNext();) {
            Integer v = it.next();
            if(!this.vertices.get(v)) {
                this.bfs(g, v);
            }
        }

    }

    private void bfs(Grafo g, Integer v) {

        this.vertices.put(v, true);
        this.list.add(v);

        while (!this.list.isEmpty()) {
            Integer actual = this.list.remove(0);
            for (Iterator<Integer> it = g.obtenerAdyacentes(actual); it.hasNext();) {
                Integer ady = it.next();
                if (!this.vertices.get(ady)) {

                    this.vertices.put(ady, true);
                    this.list.add(ady);

                }
            }
        }

    }

}

/**
 *  *     CC:
 *  *           - Con Listas de adyacencia:  O(|V| + |A|)
 *  *           - Con Matriz de adyacencia:  == recorrer matriz  O(V^2)
 *  *
 *  *     - Equivalente a un recorrido por niveles en un árbol.
 *  *     - En un grafo, desde el vértice x, todos los que tienen la misma distancia
 *  *     - Usa estructura de fila (cola, queue)
 *  *     - No recursivo, iterativo
 *  *     - Usos: Camino de menor longitud entre v y x, en grafos NO ponderados
 *
 *
 *     PSEUDO-CÓDIGO
 *
 *     public BFS(G) {
 *
 *         Vacía la fila;
 *
 *         for each v de G
 *             v -> no visitado;
 *
 *         for each v de G
 *             if (v.no visitado)
 *                 this.BFS(G, v);
 *     }
 *
 *     public BFS(G, v) {
 *
 *         v.visitado;
 *         Agregar v a la fila;
 *
 *         while(!fila.isEmpty)
 *             tomar vertice x de la fila;
 *
 *             for each ady de x
 *                  if (ady.no visitado)
 *                     y.visitado;
 *                     fila.add(y);
 *
 *     }
 *
 *
 */
