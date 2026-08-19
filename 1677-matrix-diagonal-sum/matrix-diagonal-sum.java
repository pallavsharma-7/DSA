class Solution {
    public int diagonalSum(int[][] mat) {

        int r = mat.length ; 
       
        int sum = 0 ;

        for(int i = 0 ; i < r ;i++){

            sum += mat[i][i] ;

            int j = r-1-i ; 
            if( i != r - i - 1 )
            sum += mat[i][j];
           

                
                
            }
        
        return sum ; 
    }
}