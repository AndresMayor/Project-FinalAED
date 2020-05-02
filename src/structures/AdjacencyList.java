package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList <V> implements Graph<V> {
	
	private Algorithms alg;
	
	private List<List<Duplex< V , Integer>>> adjacencyList;
	
	private Map<Integer, V> invVertices;
	
	private Map<V, Integer> vertices;
	
	
	
	
	public AdjacencyList() {
		
		adjacencyList = new ArrayList<List<Duplex<V, Integer>>>();
		vertices = new HashMap<V, Integer>();
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
	public List<V> getvertexAdjacent(V vertex) {
		
		List<V> adjacent = new ArrayList<V>();
		
		List<Duplex<V, Integer>> ad = adjacencyList.get(vertices.get(vertex));
		
		for(int i=0; i<ad.size(); i++) {
			
			adjacent.add(ad.get(i).getE1());
		}
		
		return adjacent;
	}
	

}
