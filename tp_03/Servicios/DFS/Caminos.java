package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.Arco;
import Prog_III_2023.tp_03.Grafos.Grafo;

import java.util.*;

public class Caminos {

    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;

    private List<List<Integer>> caminos;

    // Servicio caminos
    public Caminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
        this.caminos = new ArrayList<List<Integer>>();
    }

    public List<List<Integer>> caminos() {
        if (this.lim > 0 && this.grafo != null) {
            this.caminos(new ArrayList<Arco<?>>(), new ArrayList<Integer>(), this.origen, 0);
        }
        return this.caminos;
    }


    private void caminos(List<Arco<?>> visitados, List<Integer> camino, Integer v, int cont) {

        if (v == this.destino) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(this.origen);
            for (Integer i: camino) tmp.add(i);
            this.caminos.add(tmp);

        } else {
            for (Iterator<?> it = this.grafo.obtenerArcos(v); it.hasNext();) {
                Arco<?> current = (Arco<?>) it.next();
                if (!visitados.contains(current)) {
                    visitados.add(current);
                    cont += 1;
                    if (cont <= this.lim) {
                        Integer dest = current.getVerticeDestino();
                        camino.add(dest);
                        this.caminos(visitados, camino, dest, cont);
                        camino.remove(dest);
                    }
                    visitados.remove(current);
                    cont -= 1;
                }
            }
        }

    }

}
