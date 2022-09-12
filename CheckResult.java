public class CheckResult {

    public static boolean tieTheBoard(){
        // check if we have a win, then it is not a tie
        if(isAWin()){
            return false;
        }
        // otherwise check if the board is full, then it is a tie
        for(String[] row : Board.board) {
            for (String cell : row) {
                if(!"XO".contains(cell)){
                    // found an empty space, not a tie
                    return false;
                }
            }
        }
        // didn't return before, so it is a tie
        return true;
    }

    public static boolean isAWin(){
        // check if the current player has won
        String p = HumanBotInstance.currentIcon;
        System.out.println(p + " check the icons ");
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 7; col++){
                Input.print(p);
                // check for vertical wins
                //if(row == 0 && Board.board[row][col].equals(p) && Board.board[row + 1][col].equals(p) &&  Board.board[row+2][col].equals(p)){
                //    return true;
                //}
                // check for horizontal wins
                //if(col == 0 && Board.board[row][col].equals(p) && Board.board[row][col + 1].equals(p) && Board.board[row][col + 2].equals(p)){
                //    return true;
                //}
                // check for diagonal wins (left to right)
                //if(col == 0 && row == 0 && Board.board[row][col].equals(p) && Board.board[row + 1][col + 1].equals(p) && Board.board[row + 2][col + 2].equals(p)){
                //    return true;
                //}
                // check for diagonal wins (right to left)
                //if(col == 2 && row == 0 && Board.board[row][col].equals(p) && Board.board[row + 1][col - 1].equals(p) && Board.board[row + 2][col - 2].equals(p)){
                //    return true;
                //}
            }
        }
        return false;
    }



}
