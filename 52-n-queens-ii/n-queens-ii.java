class Solution {
    private int n;
    private int fullMask;
    private int answer = 0;

    public int totalNQueens(int n) {
        this.n = n;
        this.fullMask = (1 << n) - 1;
        this.answer = 0;

        solve(0, 0, 0, 0);
        return answer;
    }

    private void solve(
            int row, int cols, int diag1, int diag2) {

        if (row == n) {
            answer++;
            return;
        }

        int available = fullMask &
            ~(cols | diag1 | diag2);

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            solve(
                row + 1,
                cols | bit,
                ((diag1 | bit) << 1) & fullMask,
                (diag2 | bit) >> 1
            );
        }
    }
}