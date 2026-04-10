package Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid){
        if(grid.length == 0) return 0;
        //get rows and columns
        int m = grid.length;
        int n = grid[0].length;
        // to count total number of oranges.
        int total = 0;
        //to count oranges that got rotten.
        int count = 0;

        //Queue to store postion of rotten oranges.
        Queue<int[]> rotten = new LinkedList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] != 0) total++;

                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
            }
        }

        // Arrays for direction vectors(up, down, left, right)
        int[]dx = {0, 0, 1, -1};
        int[]dy = {1, -1, 0, 0};

        //variable to count unit time;
        int day = 0;

        //BFS loop to rot oranges level by level.

        while(!rotten.isEmpty()){

            //number of rotten oranges to be processed in this round;
            int k = rotten.size();

            count+=k;

            for(int i =0; i< k; i++){
                int []pos = rotten.poll();

                int x = pos[0], y= pos[1];

                // Check all 4 directions
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // Skip out-of-bound or non-fresh cells
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                        continue;

                    // Mark orange as rotten
                    grid[nx][ny] = 2;

                    // Add new rotten orange to queue
                    rotten.add(new int[]{nx, ny});
                }
            }
            if(!rotten.isEmpty()) day++;
        }
        return total == count ? day : -1;


    }
    
}
