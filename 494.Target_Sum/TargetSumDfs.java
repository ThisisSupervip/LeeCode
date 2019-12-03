public class TargetSumDfs{
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        int targetSumWays = solution.findTargetSumWays(nums, 1);
        System.out.println(targetSumWays);
    }
}

class Solution {
    static int res;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        recur(nums, S, 0, '+',0);
        recur(nums, S, 0, '-',0);
        return res;
    }
    public void recur(int[] nums, int S, int index, char symbol, int sum){
        sum+=symbol=='+'?nums[index]:0-nums[index];
        if(index==nums.length-1){
            if(S==sum){
                res++;
            }
            return;
        }
        recur(nums,S,index+1,'+',sum);
        recur(nums,S,index+1,'-',sum);
    }
}