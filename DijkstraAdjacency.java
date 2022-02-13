//https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/

import java.util.PriorityQueue;
import java.util.ArrayList;

public class DijkstraAdjacency {

	static class AdjListNode implements Comparable {
		public int weight;
		public int vertex;
		public AdjListNode(int weight, int vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}

		public int compareTo(Object n1) {
			return this.weight - ((AdjListNode) n1).weight;
		}
	}

	public static void main(String[] args) {
		int V = 9;
		ArrayList<ArrayList<AdjListNode> > graph
            = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(4, 1));
        graph.get(0).add(new AdjListNode(8, 7));
        graph.get(1).add(new AdjListNode(8, 2));
        graph.get(1).add(new AdjListNode(11, 7));
        graph.get(1).add(new AdjListNode(7, 0));
        graph.get(2).add(new AdjListNode(8, 1));
        graph.get(2).add(new AdjListNode(7, 3));
        graph.get(2).add(new AdjListNode(2, 8));
        graph.get(2).add(new AdjListNode(4, 5));
        graph.get(3).add(new AdjListNode(7, 2));
        graph.get(3).add(new AdjListNode(9, 4));
        graph.get(3).add(new AdjListNode(14, 5));
        graph.get(4).add(new AdjListNode(9, 3));
        graph.get(4).add(new AdjListNode(10, 5));
        graph.get(5).add(new AdjListNode(10, 4));
        graph.get(5).add(new AdjListNode(2, 6));
        graph.get(6).add(new AdjListNode(2, 5));
        graph.get(6).add(new AdjListNode(1, 7));
        graph.get(6).add(new AdjListNode(6, 8));
        graph.get(7).add(new AdjListNode(8, 0));
        graph.get(7).add(new AdjListNode(11, 1));
        graph.get(7).add(new AdjListNode(1, 6));
        graph.get(7).add(new AdjListNode(7, 8));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(1, 7));
		dijsktraShortestPath(graph, V, source);
	}

	public static int[] dijsktraShortestPath(ArrayList<ArrayList<AdjListNode>> graph, int n, int source) {
		int[] distance = new int[n];
		for(int i = 0; i < n; i++) {distance[i] = Integer.MAX_VALUE;}
		distance[source] = 0;
		// Now to create a min heap
		PriorityQueue<AdjListNode> minHeap = new PriorityQueue<>();
		minHeap.add(new AdjListNode(0, source));
		while(!minHeap.isEmpty()) {
			AdjListNode current = minHeap.poll();
			for(AdjListNode node: graph.get(current.vertex)) {
				if(distance[current.vertex] + node.weight < distance[node.vertex]) {
					distance[node.vertex] = distance[current.vertex] + node.weight;
					minHeap.add(new AdjListNode(distance[node.vertex], node.vertex));
				}
			} 
		}
		return distance; // Answer is in distance[target]
	}
}
