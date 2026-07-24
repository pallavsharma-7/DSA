class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean increasing = true ;
        boolean decreasing = true ; 
       int n = nums.length ; 
        for(int i = 0 ; i < nums.length-1 ; i++){

            if( nums[i+1] < nums[i] && i <= n-1){
                increasing= false ; 
               
            }
            else if ( nums[i+1] > nums[i] && i <= n-1){
                decreasing = false ; 
             
            }
        }
        return increasing || decreasing ;
    }
}