package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList <V> implements Graph<V> {
	
	private Algorithms alg;
	
	public final static int DEFAULT_SIZE = 18;
	
	private List<List<Duplex< V , Integer>>> adjacencyList;
	
	private Map<Integer, V> invVertices;
	
	private Map<V, Integer> vertices;
	
	private boolean isDirected;
	
	private int[][] weightedMatrix;
	
	
	
	public AdjacencyList(boolean isDirected) {
		
		this.isDirected = isDirected;
		adjacencyList = new ArrayList<List<Duplex<V, Integer>>>();
		vertices = new HashMap<V, Integer>();
		weightedMatrix = new int[18][18];
	}
	
	@Override
	public List<V> bfs(V v) {
		return (vertices.size() != 0) ? Algorithms.bfs(this, invVertices.get(0)) : null;
	}

	@Override
	public int getVertexSize() {
	
		return vertices.size();
	}

	@Override
	public int getIndex(V vertex) {
		
		return vertices.get(vertex);
	}

	@Override
	public List<V> getVertexAdjacent(V vertex) {
		
		List<V> adjacent = new ArrayList<V>();
		
		List<Duplex<V, Integer>> ad = adjacencyList.get(vertices.get(vertex));
		
		for(int i=0; i<ad.size(); i++) {
			
			adjacent.add(ad.get(i).getE1());
		}
		
		return adjacent;
	}

	@Override
	public boolean addVertex(V v) {
		vertices.put(v, vertices.size());
		
		return true;
	}

	@Override
	public void removeV(V v) {
		int pos = vertices.get(v);
		
		adjacencyList.remove(pos);
		
		for(int i=0; i<adjacencyList.size(); i++) {
			List<Duplex<V, Integer>> trans = adjacencyList.get(i);
			for(int j=0; j<trans.size(); j++) {
				Duplex<V, Integer> dupla = trans.get(j);
				if(dupla.getE1().equals(v)) trans.remove(j);
			}
		}
		
		vertices.remove(v);
	}

	@Override
	public boolean addEdge(V u, V v) {
		int pos = vertices.get(v);
		List<Duplex<V, Integer>> adj = adjacencyList.get(pos);
		
		adj.add(new Duplex<V, Integer>(u, null));
		
		if(!direct()) {
			pos = vertices.get(u);
			adj = adjacencyList.get(pos);
			
			adj.add(new Duplex<V, Integer>(v, null));
		}
		
		return true;
	}

	@Override
	public void removeE(V u, V v) {
		List<Duplex<V, Integer>> ad = adjacencyList.get(vertices.get(v));
		boolean ready = false;
		
		for(int i=0; i<ad.size() && !ready; i++) {
			if(ad.get(i).getE1().equals(u)) {
				ad.remove(i);
				ready = true;
			}	
		}
		
		if(!isDirected) {
			ad = adjacencyList.get(vertices.get(u));
			ready = false;
			
			for(int i=0; i<ad.size() && !ready; i++) {
				if(ad.get(i).getE1().equals(v)) {
					ad.remove(i);
					ready = true;
				}
			}
		}
	}



	@Override
	public boolean direct() {
		return isDirected;
	}
	@Override
	public int[][] Kruskal(int[][] p) {
		return (vertices.size() != 0) ? Algorithms.Kruskal(weightedMatrix) : null;
	}
	@Override
	public int[] Prim(int[][] p) {
		return (vertices.size() != 0) ? Algorithms.prim(weightedMatrix) : null;
	}
	@Override
	public int[][] floydWarshall() {
		return (vertices.size() != 0) ? Algorithms.floydWarshall(weightedMatrix) : null;
	
	}

	@Override
	public int[] dijkstra(V v) {
		// TODO Auto-generated method stub
		return (vertices.size() != 0) ? Algorithms.dijkstra(vertices.get(v), weightedMatrix) : null;
	}

	@Override
	public List<V> dfs(V v) {
		// TODO Auto-generated method stub
		return (vertices.size() != 0) ? Algorithms.dfs(this, invVertices.get(0)) : null;
	}
	
}
