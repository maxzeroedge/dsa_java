import java.util.List;
import java.util.ArrayList;

public class MotherVertex {
    public static void updateDP(int[][] graph, int[][] dp, int edge, int vertex) {
        for(int e: dp[edge]){
            if(dp[edge][e] == -1) {
                for(int edge2: graph[edge]) { // Process all linked nodes
                    dp[edge][edge2] = 1;
                    updateDP(graph, dp, edge2, edge);
                }
                
            }
            if(dp[edge][e] == 1) {
                dp[vertex][e] = 1;
            } else {
                dp[edge][e] = 0;// To avoid reprocessing
            }
        }
    }

    public static List<Integer> findMotherVertex(int[][] graph, int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int edge: graph[i]) {
                dp[i][edge] = 1;
                updateDP(graph, dp, edge, i);
            }
        }
        List<Integer> vertexList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] != 1) {
                    break;
                }
            }
            vertexList.add(i);
        }
        return vertexList;
    }
}
