
public class Dijkstra {

	public static void main(String[] args) {
		int[][] graph = new int[][]{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int[] path = shortestPath(graph, 0);
		for(int p: path) {System.out.println(p);}
	}

	public static int minDistance(int[] dist, boolean[] sptSet, int n) {
		int minDistance = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < n; i++) {
			if(!sptSet[i] && minDistance >= dist[i]) {
				minDistance = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static int[] shortestPath(int[][] graph, int src) {
		int n = graph.length;
		int[] dist = new int[n];
		boolean[] sptSet = new boolean[n];
		for(int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		//sptSet[src] = true;
		for(int i = 0; i < n-1; i++) {
			int minIndex = minDistance(dist, sptSet, n);
			sptSet[minIndex] = true;
			for(int j = 0; j < n; j++) {
				if(!sptSet[j] && graph[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE && dist[minIndex] + graph[minIndex][j] < dist[j]) {
					dist[j] = dist[minIndex] + graph[minIndex][j];
				}
			}
		}
		return dist;
	}
}
