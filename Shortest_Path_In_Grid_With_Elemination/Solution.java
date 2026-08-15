package Shortest_Path_In_Grid_With_Elemination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPATH(int[][] grid, int k){
        int n = grid.length;
        int m = grid[0].length;

        int[][] visitedArray = new int[n][m];
        Arrays.fill(visitedArray, -1);
        visitedArray[0][0] = k;

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(0,k,0,0));
        int[] dir_r = {1,0,-1,0};
        int[] dir_c = {0,1,0,-1};
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int dist = it.dist;
            int ele = it.ele;
            int r =it.row;
            int c = it.col;

            for(int i = 0; i<4;i++){
                int newR = r + dir_r[i];
                int newC = c + dir_c[i];

                if(newR < 0 || newR >= n || newC < 0 || newC >= m ) continue;

                int newK = ele - grid[newR][newC];

                if(newK < 0) continue;

                if(newR == n -1 && newC == m-1) return dist + 1;

                if(newK > visitedArray[newR][newC]){
                    visitedArray[newR][newC] = newK;
                    q.offer(new Tuple(1+dist, newK, newR, newC));
                }
            }
        }


        return -1;
    }
    
}
