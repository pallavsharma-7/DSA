class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int t = 1; t <= target; t++) {
            int n = 1;

            while ((1 << n) - 1 < t) n++;

            if ((1 << n) - 1 == t) {
                dp[t] = n;
                continue;
            }

            dp[t] = n + 1 + dp[(1 << n) - 1 - t];

            for (int m = 0; m < n - 1; m++) {
                int forward = (1 << (n - 1)) - 1;
                int backward = (1 << m) - 1;

                int remaining = t - forward + backward;

                dp[t] = Math.min(
                    dp[t],
                    n + m + 1 + dp[remaining]
                );
            }
        }

        return dp[target];
    }
}