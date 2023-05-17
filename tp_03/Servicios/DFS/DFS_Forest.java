package Prog_III_2023.tp_03.Servicios.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Prog_III_2023.tp_03.Grafos.Grafo;
import Prog_III_2023.tp_03.Servicios.BasicSearchAlgorithms.Estado;

public class DFS_Forest {

	private Grafo<?> grafo;
	HashMap<Integer, Estado> vertices;

	public DFS_Forest(Grafo<?> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<Integer, Estado>();
	}

	private void dfsForest_visit(List<Integer> forest, Integer v) {
		this.vertices.put(v, Estado.VISITANDO);
		forest.add(v);

		for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(v); it.hasNext();) {
			Integer ady = it.next();
			if (this.vertices.get(ady) == Estado.NO_VISITADO) {
				this.dfsForest_visit(forest, ady);
			}
		}

		this.vertices.put(v, Estado.VISITADO);
	}

	public List<Integer> dfsForest() {
		List<Integer> forest = new ArrayList<Integer>();
		if (!this.grafo.isEmpty()) {

			for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
				this.vertices.put(it.next(), Estado.NO_VISITADO);
			}

			for (Integer v : this.vertices.keySet()) {
				if (this.vertices.get(v) == Estado.NO_VISITADO) {
					this.dfsForest_visit(forest, v);
				}
			}

		}
		return forest;
	}

}
