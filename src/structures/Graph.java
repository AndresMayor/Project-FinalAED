package structures;

import java.util.List;

public interface Graph<V> {
	
	public List<V> bfs(V v);
	
	public int getVertexSize();
	
	
	public int getIndex(V vertex);
	
	public List<V> getvertexAdjacent(V vertex);

}
