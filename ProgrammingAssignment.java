import java.util.*;
import java.lang.*;
import java.io.*;
public class ProgrammingAssignment {

	class Edge implements Comparable<Edge> {
		int source;
		int destination;
		int weight;

		public int compareTo(Edge compareEdge) {
			return this.weight-compareEdge.weight;
			}
		};

		class subset {
			int parent;
			int rank;
		};
		
		int V;
		int E; 
		Edge edge[]; 

		ProgrammingAssignment(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[E];
			for (int i = 0; i < e; ++i) {
				edge[i] = new Edge();
			}
		}
		
			int find(subset subsets[], int i) {
				if (subsets[i].parent != i) 
					subsets[i].parent = find(subsets, subsets[i].parent);
					return subsets[i].parent;
				
			}
		

			void Union(subset subsets[], int x, int y) {
				int xroot = find(subsets, x);
				int yroot = find(subsets, y);
					if (subsets[xroot].rank < subsets[yroot].rank) {
						subsets[xroot].parent = yroot;
					}else if (subsets[xroot].rank > subsets[yroot].rank) {
						subsets[yroot].parent = xroot;
					}else{
						subsets[yroot].parent = xroot;
						subsets[xroot].rank++;
						}
				}
			

			void KruskalMST() {
				Edge result[] = new Edge[V]; 
				int e = 0; 
				int i = 0; 
				for (i = 0; i < V; ++i) {
					result[i] = new Edge();
				}

				Arrays.sort(edge);
				subset subsets[] = new subset[V];
				for(i = 0; i < V; ++i) {
					subsets[i]=new subset();
					for (int v = 0; v < V; ++v) {
					subsets[v].parent = v;
					subsets[v].rank = 0;
					}
				}
					i = 0; 
					while (e < V - 1) {
						Edge next_edge = new Edge();
						next_edge = edge[i++];
						int x = find(subsets, next_edge.source);
						int y = find(subsets, next_edge.destination);

						if (x != y) {
							result[e++] = next_edge;
							Union(subsets, x, y);
						}

					}

					System.out.println("Following are the edges in the constructed MST");
					for (i = 0; i < e; ++i) {
						System.out.println(result[i].source + " -- " + result[i].destination + " == "+
								result[i].weight);
				}
					
				}
				
			

				public static void main (String[] args) {
					int V = 4; 
					int E = 5; 
					ProgrammingAssignment graph = new ProgrammingAssignment(V, E);

					graph.edge[0].source = 0;
					graph.edge[0].destination = 1;
					graph.edge[0].weight = 10;

					graph.edge[1].source = 0;
					graph.edge[1].destination = 2;
					graph.edge[1].weight = 6;

					graph.edge[2].source = 0;
					graph.edge[2].destination = 3;
					graph.edge[2].weight = 5;

					graph.edge[3].source = 1;
					graph.edge[3].destination = 3;
					graph.edge[3].weight = 15;

					graph.edge[4].source = 2;
					graph.edge[4].destination = 3;
					graph.edge[4].weight = 4;
					graph.KruskalMST();
				}
			}