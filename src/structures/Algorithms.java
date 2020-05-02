package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithms {
	
	public static <V> List<V> bfs(Graph<V> g, V v){
		return traversal(g, v, new Stack<>());
	}
	
	

	private static <V> List<V> traversal(Graph<V> g, V v, Stack<V> stack){
		List<V> trav = new ArrayList<>();
		
		V vertex = v;
		stack.push(vertex);
		
		boolean[] visited = new boolean[g.getVertexSize()];
		
		while(!stack.isEmpty()) {
			
			vertex = (V) stack.pop();
			int indexV = g.getIndex(vertex);
			
			if (!visited[indexV]) {
				trav.add(vertex);
				visited[indexV] = true;
				
				List<V> adjacents = g.getvertexAdjacent(vertex);
				stack.addAll(adjacents);
			}
		}
		return trav;
	}
}
