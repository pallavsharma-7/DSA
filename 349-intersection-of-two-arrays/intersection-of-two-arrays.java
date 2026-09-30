

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        
        for (int i = 0; i < nums1.length; i++) {
            s.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (s.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }

        
        int[] result = new int[ans.size()];

        Iterator<Integer> it = ans.iterator();

        for (int i = 0; i < ans.size(); i++) {
            result[i] = it.next();
        }

        return result;
    }
}