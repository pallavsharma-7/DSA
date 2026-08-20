class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int num = n;
            int digpro = 1;

            while (num > 0) {
                int rem = num % 10;
                digpro *= rem;
                num /= 10;
            }

            if (digpro % t == 0) {
                return n;
            }

            n++;
        }
    }
}