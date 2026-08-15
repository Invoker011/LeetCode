package Shortest_Path_In_Binary_Maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution{
    public int shortestPath(int[][] grid, int[] source, int[]destination){
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0,source[0],source[1]));

        int[][]visitedArray = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visitedArray[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] dir_r = {0,1,0,-1};
        int[] dir_c = {1,0,-1,0};

        visitedArray[source[0]][source[1]] = 0;

        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int des = it.des;
            int r = it.row;
            int c = it.col;
            for(int i = 0; i < 4; i++){
                int newr = r + dir_r[i];
                int newc = c + dir_c[i];

                if(newr >= 0 && newc>=0 && newr < n && newc < m && 
                    grid[newr][newc] == 1 && 1 + des < visitedArray[newr][newc]){
                        visitedArray[newr][newc] = 1 + des;
                        if(newr == destination[0] && newc == destination[1]) return 1 + des;
                        q.offer(new Tuple(1+des, newr, newc));
                }
            }
        }
        return -1;
    }
}

