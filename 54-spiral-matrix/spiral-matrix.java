class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int strow = 0;
        int endrow = matrix.length - 1;
        int stcol = 0;
        int endcol = matrix[0].length - 1;

        while (strow <= endrow && stcol <= endcol) {

            // top ---->
            for (int j = stcol; j <= endcol; j++) {
                ans.add(matrix[strow][j]);
            }
            strow++;

            // right ↓
            for (int i = strow; i <= endrow; i++) {
                ans.add(matrix[i][endcol]);
            }
            endcol--;

            // bottom <----
            if (strow <= endrow) {
                for (int j = endcol; j >= stcol; j--) {
                    ans.add(matrix[endrow][j]);
                }
                endrow--;
            }

            // left ↑
            if (stcol <= endcol) {
                for (int i = endrow; i >= strow; i--) {
                    ans.add(matrix[i][stcol]);
                }
                stcol++;
            }
        }

        return ans;
    }
}