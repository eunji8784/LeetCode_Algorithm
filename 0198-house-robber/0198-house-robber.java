class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int answer = -1;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = nums[0] + nums[2];
        
        for (int i = 3; i < n; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        
        for (int num : dp) {
            answer = Math.max(answer, num);
        }
        
        return answer;
    }
}