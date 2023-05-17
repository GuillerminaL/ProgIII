package Prog_III_2023.tp_03.Servicios.BFS;

import java.util.*;

import Prog_III_2023.tp_03.Grafos.Grafo;


public class BFS_Forest {

	private Grafo<?> grafo;
	private List<Integer> list;


	public BFS_Forest(Grafo<?> grafo) {
		this.grafo = grafo;
		this.list = new ArrayList<Integer>();
	}

	public List<Integer> bfsForest() {
		List<Integer> forest = new ArrayList<Integer>();
		if (this.grafo != null && !this.grafo.isEmpty()) {

			this.list.clear();

			for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
				Integer v = it.next();
				if(!forest.contains(v)) {
					this.bfsForest(forest, v);
				}
			}

		}
		return forest;
	}

	private void bfsForest(List<Integer> forest, Integer v) {
		forest.add(v);
		this.list.add(v);

		while (!this.list.isEmpty()) {
			Integer actual = this.list.remove(0);
			for (Iterator<Integer> it = this.grafo.obtenerAdyacentes(actual); it.hasNext();) {
				Integer ady = it.next();
				if (!forest.contains(ady)) {

					forest.add(ady);
					this.list.add(ady);

				}
			}
		}
	}
	
}
