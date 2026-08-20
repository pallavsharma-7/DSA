class Solution {
    public int maximumWealth(int[][] accounts) {

        int r = accounts.length ;
        int c = accounts[0].length ; 
        int currsum =0 ; 
        int maxsum = 0 ; 

        for(int i = 0 ; i < r ; i++){
            currsum = 0 ; 
            for(int j = 0 ; j < c; j++){
               currsum += accounts[i][j];
               maxsum = Math.max(currsum , maxsum);

            }
        }
        return maxsum ; 
    }
}