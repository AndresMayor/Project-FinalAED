package structures;

import java.util.ArrayList;
import java.util.Comparator;
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
				
				List<V> adjacents = g.getVertexAdjacent(vertex);
				stack.addAll(adjacents);
			}
		}
		return trav;
	}
	
	public static int[][] Kruskal(int[][] p) {
		
		Disjointset<Integer> set = new Disjointset<>();
		
		int [][] MST = new int[p.length][p.length];
		
		for (int i = 0;i<p.length;i++) {
			set.makeSet(i);
		}
		
				class Obj {
					int A;
					int B;
					int P;

					Obj(int a, int b, int p) {
						A = a;
						B = b;
						P = p;
					}

					int getA() {
						return A;
					}

					int getB() {
						return B;
					}

					int getP() {
						return P;
					}
				}
			
				ArrayList<Obj> aristas = new ArrayList<>();
				for(int i = 0; i<p.length;i++) {
					for (int j =0;j<p.length;j++) {
						int weight = p[i][j];
						if (weight>0 && weight < Integer.MAX_VALUE) {
							Obj ob =new Obj(i,j,weight);
							aristas.add(ob);
						}
					}
				}
				Comparator<Obj> comparator = new Comparator<Obj>() {

					@Override
					public int compare(Obj o1, Obj o2) {
						if (o1.getP()>o2.getP()) {
							return 1;
						}else if(o1.getP()<o2.getP()) {
							return -1;
						}else {
							return 0;	
						}
						
					}
					
				};
				aristas.sort(comparator);
				for (int i= 0;i<aristas.size();i++) {
					Obj arist = aristas.get(i);
					if(set.findSet(arist.getA()) != set.findSet(arist.getB())) {
						set.union(arist.getA(), arist.getB());
						MST[arist.getA()][arist.getB()]=arist.getP();
						MST[arist.getB()][arist.getA()]=arist.getP();
					}
				}
				return MST;
	}
	
	
	
	
}
