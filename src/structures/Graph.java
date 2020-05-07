package structures;

import java.util.List;

public interface Graph<V> {
	
	public boolean addVertex(V v);
	
	public void removeV(V v);
	
	public boolean addEdge(V u, V v);
	
	public void removeE(V u, V v);
	
	
	public List<V> bfs(V v);
	
	public int[][] Kruskal(int[][] p);
	
	public int getVertexSize();
	
	
	public int getIndex(V vertex);
	
	public List<V> getVertexAdjacent(V vertex);
	
	public boolean direct();

}
