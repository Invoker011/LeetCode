package Shortest_path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPath(int[][] grid){
        int n = grid.length;
        if(n == 1) return 1;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] visitedArray = new int[n][n];

        for(int i  = 0; i<n; i++){
            for(int j = 0; j < n ;j++){
                visitedArray[i][j] = Integer.MAX_VALUE;
            }
        }
        visitedArray[0][0] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(1,0,0));

        int[] dir_r ={-1,-1,-1,0,1,1,1,0};
        int[] dir_c = {-1,0,1,1,1,0,-1,-1};

        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int dist = it.dist;
            int r = it.row;
            int c =it.col;

            for(int i = 0; i < 8; i++){
                int newr = r + dir_r[i];
                int newc = c + dir_c[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < n 
                    && grid[newr][newc] == 0 && 1 + dist < visitedArray[newr][newc]
                ){
                    visitedArray[newr][newc] = 1 + dist;
                    if(newr == n-1 && newc == n -1) return 1 + dist;
                    q.offer(new Tuple(1 + dist, newr, newc));
                }
            }
        }

        return -1;
    }
    
}
