class Solution {
    public int myAtoi(String s) {
        
        boolean foundSign = false;
        boolean isPos = true;
        
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!foundSign){
                if(s.charAt(i) == '-' || s.charAt(i) == '+' || Character.isDigit(s.charAt(i))){
                    foundSign = true;
                    isPos = s.charAt(i) == '-' ? false : true;
                    if(Character.isDigit(s.charAt(i))){
                        output.append(s.charAt(i));
                    }
                } else if (s.charAt(i) != ' '){
                    return 0;
                }
            } else {
                if(Character.isDigit(s.charAt(i))){
                    output.append(s.charAt(i));
                } else{
                    break;
                }
            }
        }

        if(output.isEmpty()){
            return 0;
        }

        double result = Double.parseDouble(output.toString());

        result = isPos ? result : -1 * result;

        if(result > (Math.pow(2, 31) -1) ){
            return 2147483647;
        }

        if(result < (-1 * (Math.pow(2, 31)) -1 ) ){
            return -2147483648;
        }

        return (int)result;

    }
}
