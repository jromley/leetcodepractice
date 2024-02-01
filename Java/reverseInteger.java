class Solution {
    public int reverse(int x) {

        boolean isPos = x>=0 ? true : false;
        
        StringBuilder myX = new StringBuilder(String.valueOf(x));
        myX.reverse();

        if(!isPos){
            myX.deleteCharAt(myX.length()-1);
        }

        if(Double.parseDouble(myX.toString()) > (Math.pow(2, 31) -1) ){
            return 0;
        }

        x = Integer.parseInt(myX.toString());
        return isPos ? x : -1 * x;

        
    }
}