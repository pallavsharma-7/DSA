class Solution {
    public boolean checkValidString(String s) {

      Stack<Integer> open = new Stack<>();
      Stack<Integer> astri = new Stack<>();

      for(int i = 0 ; i < s.length() ;i++){
         char ch = s.charAt(i);
        if(ch == '('){
            open.push(i);
        }
        else if( ch == '*'){
           astri.push(i);
        }

        else{
         if(!open.isEmpty()){
            open.pop();
         }

         else if( !astri.isEmpty()){
            astri.pop();
         }
         else{
            return false ; 
         }
           

        }

      }
    while(!open.isEmpty()){
       if(astri.isEmpty()){
        return false ; 
       }

       int opnidx = open.pop();
       int astidx = astri.pop();

       if(opnidx > astidx){
        return false ; 
       }
     

    }

 return open.isEmpty();
    }
}