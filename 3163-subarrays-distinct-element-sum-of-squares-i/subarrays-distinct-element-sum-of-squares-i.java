class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0 ; 
            int n = nums.size() ; 
        for(int i = 0 ; i < n ; i++){

            Set<Integer> st = new HashSet<>();

            for(int j = i ; j < n ; j++){
                st.add(nums.get(j));
                ans += (st.size() * st.size());
            }
        }

        return ans ; 
    }
}