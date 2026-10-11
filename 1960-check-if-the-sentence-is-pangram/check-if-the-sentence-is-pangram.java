class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> st = new HashSet<>();
        for(int i = 0 ; i < sentence.length() ;i++){
            char ch = sentence.charAt(i);
            if(!st.contains(ch)){
                st.add(ch);
            }
        }

        if(st.size() == 26){
            return true ;
        }
        return false ;
    }
}