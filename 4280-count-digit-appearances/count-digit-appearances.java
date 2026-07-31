class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for (int n : nums) {
            while (n > 0) {
                if (n % 10 == digit) {
                    count++;
                }
                n = n/ 10;
            }
        }
        return count;
    }
}