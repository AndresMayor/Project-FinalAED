package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Algorithms {
	
	
	
	public static <V> List<V> bfs(Graph<V> g, V v){
		return traversalbfs(g, v, new  LinkedList<V>());
	}
	
	
	public static <V> List<V> dfs(Graph<V> g, V v) {
		return traversal(g, v, new Stack<V>());
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
	
	
	private static <V> List<V> traversalbfs(Graph<V> g, V v, Queue<V> ds) {
		List<V> trav = new ArrayList<>();

		V vertex = v;
		ds.add(vertex);

		boolean[] visited = new boolean[g.getVertexSize()];

		while (!ds.isEmpty()) {
			vertex = ds.poll();
			int indexV = g.getIndex(vertex);

			if (!visited[indexV]) {
				trav.add(vertex);
				visited[indexV] = true;

				List<V> adjacents = g.getVertexAdjacent(vertex);
				ds.addAll(adjacents);
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
	
	private static int minIndex(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 0; i < distance.length; i++)
			if (visited[i] == false && distance[i] <= min) {
				min = distance[i];
				index = i;
			}

		return index;
	}
	
	
	public static int [] prim(int [][] matrix) {
		
		int[] mat = new int[matrix.length];
		boolean[] inMat = new boolean [matrix.length];
		int[] weight = new int[matrix.length];
		
		for (int i = 0 ; i<matrix.length;i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		
		weight[0]=0;
		mat[0]=-1;
		
		for (int i=0 ;i <matrix.length-1;i++) {
			int u =minIndex(weight,inMat);
			inMat[u]=true;
			for(int j = 0; j<matrix.length;j++) {
				if ( matrix[u][j]!= 0 && inMat[j]==false && matrix[u][j] < weight[j] ) {
					mat[j]=u;
					weight[j]=matrix[u][j];
				}
			}
		}
		return weight;
		
	}
	
	public static <V> int [] dijkstra (int v,int[][] g) {
		
		boolean [] visted = new boolean[g.length];
		int [] distance = new int[g.length];
		
		for (int i = 0;i<distance.length;i++) {
			distance[i]=Integer.MAX_VALUE;
			
		}
		distance[v]=0;
		
		for (int i = 0;i<g.length-1;i++) {
			int u =minIndex(distance,visted);
			
			visted[u]=true;
			
			for (int j =0 ;j<g.length;j++) {
				if (!visted[j] && g[u][j] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + g[u][j] < distance[j]) {
					distance[j] = distance[u] + g[u][j];
			}

			}
		}
		return distance;
	}
	
	
	
	public static <V> int[][] floydWarshall(int [][] w){
		
		int v = 0;
		int [][] D =w;
	
		
		for (int k = 0 ;k < w.length;k ++) {
			for (int i = 0; i< w.length;i++) {
				for (int j=0;j<w.length;j++) {
					if (j != k || i != k) {
						if(D[i][k]!= Integer.MAX_VALUE && D[k][j]!=Integer.MAX_VALUE) {
							
							v=D[i][k]+D[k][j];
							
							if (D[i][j]>v) {
								D[i][j] = v;
							}
						}
					}
				}
			}
			
		}
		return D;
	}
	
	
	
}
