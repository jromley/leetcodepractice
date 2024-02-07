class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            if(!checkRow(board, i))
                return false;
            if(!checkCol(board, i))
                return false;
        }

        //we do 9 loops total
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){ 

                char[][] square = new char[3][3];
                
                //copy our 9 numbers into our square
                for(int a = 0; a < 3; a++){
                    for(int b = 0; b < 3; b++){
                        //multiply row(a)/col(b) by iterators to copy correct squares
                        square[a][b] = board[a + (3 * i)][b + (3 * j)];
                    }
                }

                if(!checkSquare(square))
                    return false;

            }
        }

        return true;
    }

    public boolean checkRow(char[][] board, int row){

        char[] selected = board[row];

        return checkArray(selected);
    }

    public boolean checkCol(char[][] board, int col){

        char[] selected = new char[9];
        for(int i = 0; i < board.length; i++){
            selected[i] = board[i][col];
        }

        return checkArray(selected);
    }

    public boolean checkSquare(char[][] square){

        char[] selected = new char[9];
        int count = 0;

        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[0].length; j++){
                selected[count]= square[i][j];
                count++;
            }
        }

        return checkArray(selected);

    }

    public boolean checkArray(char[] arr){
        
        HashSet<Character> numbers = new HashSet<Character>();
        for(int i = 0; i < arr.length; i++){
            Character c = arr[i];
            if(!c.equals('.')){
                if(numbers.contains(c)){
                    return false;
                } else {
                    numbers.add(c);
                }
            }
        }

        return true;
    }

}