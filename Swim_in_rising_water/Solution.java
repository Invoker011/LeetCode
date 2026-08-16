package Swim_in_rising_water;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int swimShortTime(int[][]grid){
        int n = grid.length;

        int [][]visited = new int[n][n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<Tuple> q = new PriorityQueue<>((a,b) -> a.time - b.time);
        q.offer(new Tuple(grid[0][0],0,0));
        
        int[] dir_r = {1,0,-1,0};
        int[] dir_c = {0,1,0,-1};
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int t = it.time;
            int r = it.row;
            int c = it.col;   
            for(int i = 0; i< 4; i++){
                int newR = r + dir_r[i];
                int newC = c + dir_c[i];

                if(newR >= 0 && newR < n && newC >=0 && newC < n){
                    int newTime = Math.max(t,grid[newR][newC]);
                    if(newTime < visited[newR][newC]){
                        visited[newR][newC] = newTime;
                        q.offer(new Tuple(newTime,newR,newC));
                    }
                }
            }
        }    
        return visited[n-1][n-1];
    }   
    
}
