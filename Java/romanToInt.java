class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder pfx = new StringBuilder();
        char temp;
        boolean done = false;
        
        for(int i = 0; i < strs[0].length(); i++){
            temp = strs[0].charAt(i);
            
            for (String s : strs){
                if(i >= s.length()){
                    done = true;
                    break;
                }
                if(s.charAt(i) != temp){
                    done = true;
                    break;
                }
            }
            if(done){
                return pfx.toString(); 
            }
            pfx.append(temp);
        }


        return pfx.toString();
        
    }
}