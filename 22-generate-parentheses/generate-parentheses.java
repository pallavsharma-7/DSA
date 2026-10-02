class Solution {
    public List<String> generateParenthesis(int n) {


           List<String> result = new ArrayList<String>();

           generate(result , n , 0,0,"");
           return result ; 


        
    }

    public void generate(List<String> result , int max , int open , int close , String unpro){

        if(unpro.length() == (2*max)){

            result.add(unpro);
            return ; 
        }

        if(open < max){
            generate(result , max , open+1 , close , (unpro + "(" ));
        }

        if(close < open){
            generate(result , max , open , close+1 , (unpro + ")" ));
        }
    }
}