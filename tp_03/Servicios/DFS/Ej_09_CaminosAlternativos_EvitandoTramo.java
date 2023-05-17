package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.Arco;
import Prog_III_2023.tp_03.Grafos.GrafoNoDirigido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Ejercicio 9
 * Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
 * todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos
 * Aires a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al
 * tránsito.
 */

/*
public class CaminosAlternativos_EvitandoTramo {

    private GrafoNoDirigido grafo;
    private String origen;
    private String destino;
    private Arco fuera_de_servicio;

    private List<List<String>> solucion;
    private HashMap<String, Boolean> vertices;

    public CaminosAlternativos_EvitandoTramo(GrafoNoDirigido g, String o, String d, Arco out) {
        this.grafo = g;
        this.origen = o;
        this.destino = d;
        this.fuera_de_servicio = out;
        this.solucion = new ArrayList<List<String>>();
    }

    public void buscar() {
        if (this.grafo != null && this.grafo.contieneVertice(this.origen) && this.grafo.contieneVertice(this.destino)) {

            for (Iterator<String> it = this.grafo.obtenerVertices(); it.hasNext();) {
                this.vertices.put(it.next(), false);
            }
            this.buscar(this.origen, new ArrayList<String>());
        }
        return this.solucion;
    }

    private void buscar(String v, List<String> camino) {
        if (v == this.destino) {
            List<String> tmp = new ArrayList<String>();
            tmp.add(this.origen);
            for (String s: camino) tmp.add(s);
            this.solucion.add(tmp);
        } else {
            this.vertices.put(v, true);
            for (Iterator<Arco> it = this.grafo.obtenerArcos(v); it.hasNext();) {
                Arco t = it.next();
                if (t != this.fuera_de_servicio) {
                    String d = t.getDestino();
                    if (!this.vertices.get(d)) {
                        camino.add(d);
                        this.buscar(d, camino);
                        camino.remove(d);
                    }
                }
            }
            this.vertices.put(v, false);
        }
    }
}


*/