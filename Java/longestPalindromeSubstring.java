class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if(s.length() == 1)
            return s;
        
        if(isPalindrome(s))
            return s;
        
        for(int i = s.length()-1; i > 0 ; i--){

            for(int j = 0; j + i <= s.length(); j++){
                if(isPalindrome(s.substring(j, j+i))){
                    return s.substring(j, j+i);
                }
            }

        }
        
        return s.substring(0,1);
        
    }

    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

/*

b b b b c b a a a






*/