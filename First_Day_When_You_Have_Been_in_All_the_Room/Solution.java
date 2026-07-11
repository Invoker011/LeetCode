package First_Day_When_You_Have_Been_in_All_the_Room;

public class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit){
        int n = nextVisit.length;
        long mod = 1_000_000_007;
        long[] dp = new long[n];

        for(int i =1; i<n;i++){
            dp[i] = (2 * dp[i-1] - dp[nextVisit[i-1]] + 2 + mod) % mod;
        }
        return (int)(dp[n-1]);
    }
    
}
