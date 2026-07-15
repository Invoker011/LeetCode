package Number_Of_Island;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numberOfIsland(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count=0;

        int[][]visited = new int[n][m];

        for(int row =0; row<n;row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == '1' && visited[row][col] == 0){
                    visited[row][col] = 1;
                    count++;
                    bfs(row, col, grid, visited);
                }
            }
        }
        return count;
    }
    private void bfs(int r, int c, char[][]grid, int[][]visited){
        visited[r][c] = 1;

        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(r,c));

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            //to see find 1 around it and mark them in all eight direction.
            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <=1; delCol++){
                    //if want to check only 4 directtion that is up down side and side the add below line;
                    //if(Math.abs(delRow + delCol) == 2 && delRow + delCol ==0) continue;
                    int nrow = row + delRow;
                    int ncol = col + delCol;

                    if(nrow >= 0 && ncol >= 0 && nrow < grid.length 
                        && ncol < grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                            visited[nrow][ncol] = 1;
                            q.add(new Pair(nrow,ncol));
                    }

                }
            }
        }

    }
    
}
