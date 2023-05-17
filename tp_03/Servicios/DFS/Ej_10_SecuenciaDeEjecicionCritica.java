package Prog_III_2023.tp_03.Servicios.DFS;

import Prog_III_2023.tp_03.Grafos.Grafo;
/*
import java.util.ArrayList;

public class Ej_10_SecuenciaDeEjecicionCritica {

    // public class Tarea   String nombre, String descripcipon, int duración (hs.)
    // public class Arco    int demora (hs.), Tarea origen, Tarea destino

    private Grafo grafo; //Supone que es un árbol n-ario
    private List<Tarea> secuenciaCritica;
    private int maxDuracionSC;

    public Ej_10_SecuenciaDeEjecicionCritica() {
        this.secuenciaCritica = new ArrayList<Tarea>();
        this.maxDuracionSC = 0;
    }

    public List<Tarea> calcular(Grafo g, Tarea tarea0) {
        if (this.grafo != null && this.grafo.contieneTarea(tarea0)) {
            this.grafo = g;
            this.calcular(tarea0, new ArrayList<Tarea>(), 0);
        }
        return this.secuenciaCritica;
    }

    public void calcular(Tarea t, List<Tarea> secuencia, int acum) {
        if (this.grafo.getAdyacentes(t) == null && acum > maxDuracionSC) {
            List<Tarea> tmp = new ArrayList<Tarea>();
            for (Tarea ta: secuencia) tmp.add(ta);
            this.secuenciaCritica = tmp;
            this.maxDuracionSC = acum;

        } else {

            for (Iterator<Arco> it = this.grafo.getAdyacentes(t); it.hasNext();) {
                Arco a = it.next();
                Tarea d = a.getDestino();
                if (this.secuencia.contains(d)) {
                    int dur = d.getDuracion();
                    int dem = a.getDemora;

                    secuencia.add(d);
                    acum += (dur + dem);
                    this.calcular(d, secuencia, acum);
                    acum -= (dur + dem);
                    secuencia.remove(d);

                }
            }
        }
    }
}

*/
