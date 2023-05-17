package Prog_III_2023.tp_03.Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, HashSet<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<Integer, HashSet<Arco<T>>>();
	}

	@Override
	public boolean isEmpty() {
		return this.vertices.isEmpty();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!this.vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new HashSet<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(this.vertices.containsKey(verticeId)) {
			this.vertices.remove(verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		this.agregarVertice(verticeId1);
		this.agregarVertice(verticeId2);
		Arco<T> aux = new Arco<T>(verticeId1, verticeId2, etiqueta);
		this.vertices.get(verticeId1).add(aux);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> delete = this.obtenerArco(verticeId1, verticeId2);
		if(delete != null) this.vertices.get(verticeId1).remove(delete);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(this.vertices.containsKey(verticeId1)) {
			for (Iterator<Arco<T>> it = this.obtenerArcos(verticeId1); it.hasNext();) {
				Arco<T> current = it.next();
				if(current.getVerticeDestino() == verticeId2)
					return current;
			}
		}
		return null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return this.obtenerArco(verticeId1, verticeId2) != null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int count = 0;
		if(!this.vertices.isEmpty()) {
			for (Iterator<Integer> it = this.obtenerVertices(); it.hasNext();) {
				count += this.vertices.get(it.next()).size();
			}
		}
		return count;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(!this.vertices.containsKey(verticeId)) return new ArrayList<Integer>().iterator();
		HashSet<Integer> adjs = new HashSet<Integer>();
		for (Iterator<Arco<T>> it = this.obtenerArcos(verticeId); it.hasNext();) {
			adjs.add(it.next().getVerticeDestino());
		}
		return adjs.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		HashSet<Arco<T>> aux = new HashSet<Arco<T>>();
		for (Iterator<Integer> it = this.obtenerVertices(); it.hasNext();) {
			aux.addAll(this.vertices.get(it.next()));
		}
		return aux.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if(!this.vertices.containsKey(verticeId)) return new ArrayList<Arco<T>>().iterator();
		return this.vertices.get(verticeId).iterator();
	}


}
