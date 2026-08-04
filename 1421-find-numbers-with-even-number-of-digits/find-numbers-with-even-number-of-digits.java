class Solution {
    public int findNumbers(int[] nums) {
        int oc = 0 ; 
        for(int num : nums){
            int ic = 0 ; 
            while(num > 0){
                num=num/10; 
                ic++;
            }
                if(ic%2==0){
                    oc++ ;
                

            }
        }
        return oc ;
    }
}