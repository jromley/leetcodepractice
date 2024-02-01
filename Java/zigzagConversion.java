class Solution {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        ArrayList<StringBuilder> results = new ArrayList<StringBuilder>();

        for(int i = 0; i < numRows; i++){
            results.add(new StringBuilder());
        }

        int row = 0;
        int pos = 0;
        boolean walkingDown = true;


        while(pos < s.length()){
            results.get(row).append(s.charAt(pos));
            
            if(walkingDown) {
                row++;
                if(row == numRows){
                    walkingDown = false;
                    row -= 2;
                    if(row == 0){
                        walkingDown = true;
                    }
                }
            } else{
                row -= 1;
                if(row == 0){
                    walkingDown = true;
                }
            }

            pos++;

        }

        String val = "";
        for(int i = 0; i < numRows; i++){
            val += results.get(i).toString();
        }

        return val;

    }

    /*

    0 2 4 6 8
    1 3 5 7 9

    2 2 2 2 2
    2 2 2 2 2

    The first letter in the string is s[0]
    the second letter in the string for rows=4 is s[6]
    the third letter in the string for rows=4 is s[12]
    s[0] s[6] s[12] ->  6 6 6
    s[1] s[5] s[7] s[11] s[13] -> 4 2 4 2 
    s[2] s[4] s[8] s[10] -> 2 4 2 4
    s[3] s[9] -> 6
   

   8 0 8 0  // first row is *2 -2 
   6 2 6 2  // *2 + 2
   4 4 4 4
   2 6 2 6
   8 0 8 0


   s[0] s[4] s[8]
   s[1] s[3] s[5] s[7] s[9]
   s[2] s[6] s[10]

   4 4 4
   2 2 2 2 2
   4 4 4


    00/0      02/4        04/8
    10/1 11/3 12/5  13/7  14/9
    20/2      22/6        24/10



    00           08          16
    01        07 09       15
    02     06    10    14
    03  05       11 13
    04           12

    8 8 8
    6 2 6
    4 4 4
    2 6 2
    8 8 8


    00/0              03/6
    10/1        12/5  13/7
    20/2  21/4        23/8
    30/3              33/9
    
    until we hit numRows-1
    increment the row number, keep column the same
    once we hit numRows-1, increment column but decrement row until row0

    PAYPALISHIRING

    P
    A
    Y

    */

}