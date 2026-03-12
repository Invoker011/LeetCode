package Maximum_Points_You_can_Obtain_From_Cards;

public class Solution {
    public int maximumPoints(int[] cardPoints, int k){
        int maxPoints = 0;
        int sum = 0;

        for(int i=0; i < k; i++){
            sum += cardPoints[i];
        }
        maxPoints = sum;
        int j = cardPoints.length -1;

        for(int i = k-1;  i >= 0; i--){
            sum -= cardPoints[i];
            sum += cardPoints[j];
            j--;
            maxPoints = Math.max(maxPoints, sum);
        }
        return maxPoints;
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        int k = 3;
        int[] cardPoints= {1,2,3,4,5,6,1};

        int result = sol.maximumPoints(cardPoints,k);
        System.out.println(result);
    }
}
