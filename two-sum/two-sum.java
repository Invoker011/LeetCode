//brute force 
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int [] result = new int[2];
//         for(int i = 0; i < n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(nums[i] + nums[j] == target){
//                     result[0] = i;
//                     result[1] = j;
//                 }
//             }
//         }
//         return result;
//     }
// }
//Optimised Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer.Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int [] {map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Index Found");
    }
}
