class Solution {
    public int minFlips(int a, int b, int c) {
         // Creating and assigning binary array size

        int[] aBinary = toBinary(a);
        int[] bBinary = toBinary(b);
        int[] cBinary = toBinary(c);

        int result = getMinFlips(aBinary, bBinary, cBinary);

        return result;
    }

    int getMinFlips(int[] x, int[] y, int[] z){
        int result = 0;
        for (int i = 0; i < x.length; i++){
            
            if(z[i] == 0 && x[i] == 1 && y[i] == 0) {
                result += 1;
            } else if(z[i] == 0 && x[i] == 0 && y[i] == 1) {
                result += 1;
            } else if(z[i] == 0 && x[i] == 1 && y[i] == 1) {
                result += 2;
            } else if(z[i] == 1 && x[i] == 0 && y[i] == 0){
                result += 1;
            }
        }
        
        return result;
    }

    public int log2(int N) {
        int result = (int)(Math.log(N) / Math.log(2));
        return result;
    }
    
    public int[] toBinary(int x){
        int[] binary = new int[30];
        int i = 0;
 
        // Number should be positive
        while (x > 0) {
            binary[i] = x % 2;
            x = x / 2;
            i++;
        }
        for(i = (i+1); i < binary.length; i++){
            binary[i] = 0;
        }

        return binary;
    }
}