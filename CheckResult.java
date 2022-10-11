public class CheckResult {

    public static boolean tieTheBoard() {
        // check if we have a win, then it is not a tie
         if(getIsAWin()){
            return false;
        }
        // otherwise check if the board is full, then it is a tie
        for (String[] row : Board.board) {
            for (String cell : row) {
                if (!"XO".contains(cell)) {
                    // found an empty space, not a tie
                    return false;
                }
            }
        }
        // didn't return before, so it is a tie
        return true;
    }
    public static boolean getIsAWin(){
        return isAWin(HumanAndBot.currentIcon);
    }
    public static boolean getIsAWinTempBrick(String pattern){
        return isAWin(pattern);
    }

    private static boolean isAWin(String p){

        // Check for connecting four horizon.  -------
         for (int row = 0; row < Board.board.length; row++) {
            for (int column = 0; column < Board.board[0].length - 3; column++) {
                if (Board.board[row][column].equals(p) &&
                        Board.board[row][column + 1].equals(p) &&
                        Board.board[row][column + 2].equals(p) &&
                        Board.board[row][column + 3].equals(p)){
                    return true;
                }
            }
        }
        // Check for connecting four vertical. |
        for (int row = 0; row < Board.board.length - 3; row++) {
            for (int column = 0; column < Board.board[0].length; column++) {
                if (Board.board[row][column].equals(p)  &&
                        Board.board[row + 1][column].equals(p)  &&
                        Board.board[row + 2][column].equals(p)  &&
                        Board.board[row + 3][column].equals(p)) {
                    return true;
                }
            }
        }
        // Check for connecting four diagonal from right to left.
        for (int row = 3; row < Board.board.length; row++) {
            for (int column = 0; column < Board.board[0].length - 3; column++) {
                if (Board.board[row][column].equals(p)  &&
                        Board.board[row - 1][column + 1].equals(p)  &&
                        Board.board[row - 2][column + 2].equals(p)  &&
                        Board.board[row - 3][column + 3].equals(p)) {
                    return true;
                }
            }
        }
        // Check for connecting four diagonal from left to right.
        for (int row = 0; row < Board.board.length - 3; row++) {
            for (int column = 0; column < Board.board[0].length - 3; column++) {
                if (Board.board[row][column].equals(p)  &&
                        Board.board[row + 1][column + 1].equals(p)  &&
                        Board.board[row + 2][column + 2].equals(p)  &&
                        Board.board[row + 3][column + 3].equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }



}
