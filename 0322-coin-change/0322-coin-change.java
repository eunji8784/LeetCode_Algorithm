class Solution {
    public int coinChange(int[] coins, int amount) {
        final int INF = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        
        if (amount == 0) {
            return 0;
        }
        
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1; 
            }
        }
        
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int n = i / 2;
            for (int j = 1; j <= n; j++) {
                if (dp[i - j] != INF && dp[j] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
                }
            }
        }
        
        return (dp[amount] == INF ? -1 : dp[amount]);
    }
}