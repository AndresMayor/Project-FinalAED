package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixWeightedGra<V> implements Graph<V> {

	
	
	public final static int DEFAULT_SIZE = 10;
	
	
	
	
	private int[][] Weight;
	private int[][] minPath;
	
	
	private Map<V,Integer> vertices;
	private Map<Integer,V> invVertices;
	
	
	public boolean isDirected;
	
	//por defecto
	
	public MatrixWeightedGra(boolean d) {
		vertices = new HashMap<V, Integer>();
		invVertices = new HashMap<Integer, V>();
		Weight = new int[DEFAULT_SIZE][DEFAULT_SIZE];
		isDirected = d;
	}
	
	//por seleccion
	public MatrixWeightedGra(int v, boolean d) {
		vertices = new HashMap<V, Integer>();
		invVertices = new HashMap<Integer, V>();
		Weight = new int[v][v];
		isDirected = d;
	}
	
	
	@Override
	public boolean addVertex(V v) {
		
		vertices.put(v, vertices.size());
		
		return true;
	}

	@Override
	public void removeV(V v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addEdge(V u, V v) {
		int posv = vertices.get(v);
		int posu = vertices.get(u);
		
		Weight[posv][posu] = 1;
		
		if(!isDirected) Weight[posu][posv] = 1;
		
		return true;
	}

	@Override
	public void removeE(V u, V v) {
		int posv = vertices.get(v);
		int posu = vertices.get(u);
		
		Weight[posv][posu] = Integer.MAX_VALUE;
		
		if(!isDirected) Weight[posu][posv] = Integer.MAX_VALUE;
		
	}

	@Override
	public List<V> bfs(V v) {
		return (vertices.size() != 0)? Algorithms.bfs(this, invVertices.get(0)) : null;
	}

	@Override
	public int[][] Kruskal(int[][] matrix) {
		return (vertices.size() != 0)? Algorithms.Kruskal(Weight) : null;
	}

	@Override
	public int[] Prim(int[][] matrix) {
		// TODO Auto-generated method stub
		 return (vertices.size() != 0)? Algorithms.prim(Weight) : null;
	}

	@Override
	public int getVertexSize() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int getIndex(V vertex) {
		
		return vertices.get(vertex);
	}

	@Override
	public List<V> getVertexAdjacent(V vertex) {
		List<V> adjacent = new ArrayList<V>();
		int pos = vertices.get(vertex);
		
		for(int i=0; i<Weight.length; i++) {
			if(Weight[pos][i] != Integer.MAX_VALUE && pos != i) adjacent.add(invVertices.get(i));
		}
		
		return adjacent;
	}

	@Override
	public boolean direct() {
		return isDirected;
	}

	@Override
	public int[] dijkstra(V v) {
		// TODO Auto-generated method stub
		return  (vertices.size() != 0) ? Algorithms.dijkstra(vertices.get(v), Weight) : null;
	}

	@Override
	public int[][] floydWarshall() {
		// TODO Auto-generated method stub
		return (vertices.size() != 0)? Algorithms.floydWarshall(Weight) : null;
	}

	@Override
	public List<V> dfs(V v) {
		// TODO Auto-generated method stub
		return (vertices.size() != 0)? Algorithms.dfs(this, invVertices.get(0)) : null;
	}

}
