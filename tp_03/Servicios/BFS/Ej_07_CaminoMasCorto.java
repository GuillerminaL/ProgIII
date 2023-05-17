package Prog_III_2023.tp_03.Servicios.BFS;

import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.*;

/**
 * Ejercicio 7.
 * Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
 * es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
 * esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
 * cantidad de cuadras posible.
 */
public class Ej_07_CaminoMasCorto {

    private Grafo grafo;
    private Integer o;
    private Integer d;

    private List<Integer> fila;
    private HashMap<Integer, Integer> antecesores;

    public Ej_07_CaminoMasCorto(Grafo g, Integer o, Integer d) {
        this.grafo = g;
        this.o = o;
        this.d = d;
        this.fila = new ArrayList<Integer>();
        this.antecesores = new HashMap<Integer, Integer>();
    }

    /**
     * Adaptación del BFS
     *
     * Por cada nodo adyacente, se guarda la referencia a su padre -en origen, null-.
     * Es destino?
     * SI: se reconstruye y se devuelve el camino de retorno.
     * NO: Si no está en la fila y no fue visitado (no hay referencia al padre), se lo agrega.
     *
     */
    public List<Integer> get() {
        List<Integer> result = new ArrayList<Integer>();
        if (this.grafo != null && !this.grafo.isEmpty()) {
            if (this.grafo.contieneVertice(this.o) && this.grafo.contieneVertice(this.d)) {

                this.antecesores.put(this.o, null);
                this.fila.add(this.o);

                int i = 0;
                while(i < this.fila.size()) {
                    Integer tmp = this.fila.get(i);

                    for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(tmp); it.hasNext();) {
                        Integer ady = it.next();
                        if (!this.antecesores.containsKey(ady)) this.antecesores.put(ady, tmp);

                        if (ady == this.d) {
                            result.add(ady);
                            while (this.antecesores.get(ady) != null) {
                                result.add(0, this.antecesores.get(ady));
                                ady = this.antecesores.get(ady);
                            }
                            return result;
                        }

                        if (!this.fila.contains(ady)) this.fila.add(ady);

                    }

                    i++;
                }
            }
        }
        return result;
    }





}
