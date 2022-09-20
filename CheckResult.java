public class CheckResult {

    public static boolean tieTheBoard() {
        // check if we have a win, then it is not a tie
         if(isAWin()){
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


    public static boolean isAWin(){
        String p = HumanAndBot.currentIcon;
        // Check for connecting four horizon.  -------
         for (int rad = 0; rad < Board.board.length; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (Board.board[rad][kol].equals(p) &&
                        Board.board[rad][kol + 1].equals(p) &&
                        Board.board[rad][kol + 2].equals(p) &&
                        Board.board[rad][kol + 3].equals(p)){
                    return true;
                }
            }
        }
        // Check for connecting four vertical. |
        for (int rad = 0; rad < Board.board.length - 3; rad++) {
            for (int kol = 0; kol < Board.board[0].length; kol++) {
                if (Board.board[rad][kol].equals(p)  &&
                        Board.board[rad + 1][kol].equals(p)  &&
                        Board.board[rad + 2][kol].equals(p)  &&
                        Board.board[rad + 3][kol].equals(p)) {
                    return true;
                }
            }
        }
        // Check for connecting four diagonal from right to left.
        for (int rad = 3; rad < Board.board.length; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (Board.board[rad][kol].equals(p)  &&
                        Board.board[rad - 1][kol + 1].equals(p)  &&
                        Board.board[rad - 2][kol + 2].equals(p)  &&
                        Board.board[rad - 3][kol + 3].equals(p)) {
                    return true;
                }
            }
        }
        // Check for connecting four diagonal from left to right.
        for (int rad = 0; rad < Board.board.length - 3; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (Board.board[rad][kol].equals(p)  &&
                        Board.board[rad + 1][kol + 1].equals(p)  &&
                        Board.board[rad + 2][kol + 2].equals(p)  &&
                        Board.board[rad + 3][kol + 3].equals(p)) {
                    return true;
                }
            }
        }
        return false;
    }



}
