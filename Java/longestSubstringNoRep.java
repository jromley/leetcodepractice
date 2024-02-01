class Solution {
    
    public int lengthOfLongestSubstring(String s) {

        if(!containsDuplicates(s)){
            return s.length();
        }

        boolean foundInstanceOfNoDup = false;

        for (int i = 2; i < s.length(); i++){
            foundInstanceOfNoDup = false;
            for(int j = 0; i+j <= s.length(); j++){
                
                if(!containsDuplicates(s.substring(j, i+j))){
                    
                    if(i+1 == s.length()){
                        return i;
                    }
                    foundInstanceOfNoDup = true;
                    break;
                }
            }

            if(!foundInstanceOfNoDup){
                return i-1;
            }

        }

        return 1;
    }

    public boolean containsDuplicates(String s){

        return s.length() != s.chars().distinct().count();
    }

    
}