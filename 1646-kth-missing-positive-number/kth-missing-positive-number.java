class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0 , high = arr.length -1 ; 
        while(low <= high){


            int mid = (low + high)/2 ;
            int no_miss= arr[mid] - (mid + 1) ;

            if(no_miss < k ){
                low = mid + 1;
            } 
            else{

                high = mid-1 ;
            }
        }
        return ( high + 1 + k);
    }
}