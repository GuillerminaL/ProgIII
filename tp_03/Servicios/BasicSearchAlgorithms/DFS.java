package Prog_III_2023.tp_03.Servicios.BasicSearchAlgorithms;

import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {

    HashMap<Integer, Estado> vertices;

    public DFS(){
        this.vertices = new HashMap<Integer, Estado>();
    }

    public void dfs_visit(Grafo g, Integer v, int t) {

        this.vertices.put(v, Estado.VISITANDO);
        t += 1;
        //v -> tiempo_de_descubrimiento = t;

        for (Iterator<Integer> it = g.obtenerAdyacentes(v); it.hasNext();) {
            Integer current = it.next();
            if (this.vertices.get(current) == Estado.NO_VISITADO) {
                this.dfs_visit(g, current, t);
            }
            /*-------- Test de aciclicidad ---------------*/
            if (this.vertices.get(current) == Estado.VISITANDO) {
                System.out.println("Hay ciclo");
            }
            /*---------------------------------------------*/
        }

        t += 1;
        //v -> tiempo_de_finalizacion = t;
        this.vertices.put(v, Estado.VISITADO);
    }

    public void dfs(Grafo g) {

        for (Iterator<Integer> it = g.obtenerVertices(); it.hasNext();) {
           this.vertices.put(it.next(), Estado.NO_VISITADO);
        }

        int tiempo = 0;

        for (Iterator<Integer> it = this.vertices.keySet().iterator(); it.hasNext();) {
            Integer v = it.next();
            if (this.vertices.get(v) == Estado.NO_VISITADO) {
                this.dfs_visit(g, v, tiempo);
            }
        }

    }

}

/**
 * CC
 *    - Con Listas de adyacencia:  O(|V| + |A|)
 *    - Con Matriz de adyacencia:  == recorrer matriz  O(V^2)
 *
 *     Node has : color, desc, fin
 *     Colores: WHITE no visitado, YELLOW visitando, BLACK visitado
 *
 *     Clases de Arcos:
 *       1. ARCOS TREE: Aquellos que llevaron a vértices no visitados -blancos- en el recorrido actual.
 *                      BOSQUES ABARCADORES EN PROFUNDIDAD: Posibles Cjtos de ARCOS TREE ()
 *
 *       2. ARCOS BACK: Aquellos que intentaron llevarme desde un descendiente a un ancestro -amarillo a amarillo- en el
 *                         camino actual de recursión.
 *                        TEST DE ACICLICIDAD: los arcos back permiten determinar si un grafo tiene ciclos o no, según
 *                                             tenga arcos back o no.
 *     PSEUDO-CÓDIGO
 *     public dfs(G) {
 *         for each node of G {
 *             node.color = WHITE;
 *         }
 *         int tiempo = 0;
 *         for each node of G {
 *             if (node.color == WHITE) {
 *                 this.dfs_visit(node);
 *             }
 *         }
 *     }
 *
 *     private dfs_visit(node) {
 *         node.setColor(YELLOW);
 *         tiempo = tiempo+1;
 *         node.desc = tiempo;
 *         for each adyacente de node {
 *             if (node.color == WHITE) {
 *                 this.dfs_visit(node);
 *             }
 *             //------- Test de aciclicidad ----------
 *             if (node.color == YELLOW) {
 *                 print("Hay ciclo");
 *             }
 *             //--------------------------------------
 *         }
 *         node.setColor(BLACK);
 *         tiempo = tiempo+1;
 *         node.fin = tiempo;
 *     }
 */
