class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Character> st = new Stack<>();
        int count = 0;
        int depth = 0 ;

        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);

        if(ch =='('){
            depth++ ;
        }
        else{
            depth--;

            if(s.charAt(i-1) == '('){
                count += 1<<depth;
            }
        }
        }
        return count ;
    }
}