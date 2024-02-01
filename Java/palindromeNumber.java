class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<=0)
            return x == 0? true : false;

        if( x < 10)
            return true;

        int length = (int) (Math.log10(x) + 1);
        int halfX = x / (int)Math.pow(10,((length+1)/2));

        int lastHalf = 0;
        
        for(int i = 0; i < length/2; i++){
            lastHalf += (x % 10) * (int)Math.pow(10,(length/2-i-1));
            x = x / 10;
        }

        return (lastHalf == halfX);
        

    }
}