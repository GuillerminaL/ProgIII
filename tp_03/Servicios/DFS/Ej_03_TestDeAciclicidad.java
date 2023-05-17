package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.GrafoDirigido;
import Prog_III_2023.tp_03.Servicios.BasicSearchAlgorithms.Estado;

import java.util.HashMap;
import java.util.Iterator;

public class Ej_03_TestDeAciclicidad {

    private GrafoDirigido grafo;
    private HashMap<Integer, Estado> vertices;

    public Ej_03_TestDeAciclicidad() {
        this.vertices = new HashMap<Integer, Estado>();
    }

    public boolean esAciclico(GrafoDirigido g) {
        this.grafo = g;
        if (this.grafo == null || this.grafo.isEmpty())  return true;
        return !this.tieneCiclo();
    }

    private boolean tieneCiclo() {
        this.vertices.clear();

        for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
            this.vertices.put(it.next(), Estado.NO_VISITADO);
        }

        for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
            Integer node = it.next();
            if (this.vertices.get(node) == Estado.NO_VISITADO) {
                if (this.tieneCiclo(node)) return true;
            }
        }

        return false;
    }


    private boolean tieneCiclo(Integer node) {

        this.vertices.put(node, Estado.VISITANDO);

        for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(node); it.hasNext();) {
            Integer actual = it.next();
            if (this.vertices.get(actual) == Estado.NO_VISITADO) {
                this.tieneCiclo(actual);
            }
            if (this.vertices.get(actual) == Estado.VISITANDO) {
                return true;
            }
        }

        this.vertices.put(node, Estado.VISITADO);
        return false;
    }

}
