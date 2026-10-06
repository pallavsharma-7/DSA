class Solution {
    public int minAddToMakeValid(String s) {
      Stack<Character> st = new Stack<>();

      int open = 0 ; 
      int close = 0 ; 

      for(int i = 0 ; i < s.length() ; i++){

        char ch = s.charAt(i);

        if(ch == '('){
              open++ ;
            st.push(ch);
          
        }
        else if(ch == ')'){
            close++; 
            if(!st.isEmpty()){
                st.pop();
                open-- ; 
                close--;
            }
        }
      } 
      return open + close ; 
    }
}