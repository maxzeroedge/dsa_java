import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CycleInDirectedGraph {
    public boolean isCyclicUtil(int node, ArrayList<ArrayList<Integer>> adj, Map<Integer, Boolean> visitedMap, Map<Integer, Boolean> recurrentMap) {
        if(recurrentMap.containsKey(node)) {
            return true;
        }
        if(visitedMap.containsKey(node)) {
            return false;
        }
        recurrentMap.put(node, true);
        visitedMap.put(node, true);
        for(Integer connections: adj.get(node)) {
            if(isCyclicUtil(connections, adj, visitedMap, recurrentMap)) {
                return true;
            }
        }
        recurrentMap.remove(node);
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Map<Integer, Boolean> recurrentMap = new HashMap<>();
        for(int i = 0; i < V; i++) {
            if(isCyclicUtil(i, adj, visitedMap, recurrentMap)) {
                return true;
            }
        }
        return false;
    }
}
