package Number_Of_Provinces;
import java.util.*;
public class Solution {
    public int findNumberOfProvinces(int[][] isConnected){
        int V = isConnected.length;

        List<List<Integer>>adjList = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j =0; j< V; j++){
                if(isConnected[i][j] == 1 && i !=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];

        int count = 0;

        for(int i=0; i<V;i++){
            if(!visited[i]){
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;


    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited){
        visited[node] = true;

        for(int neighbor: adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,adjList,visited);
            }
        }
    }
    
}
