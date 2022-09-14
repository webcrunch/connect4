public class CheckResult {

    public static boolean tieTheBoard() {
        // check if we have a win, then it is not a tie
        /* if(isAWin()){
            return false;
        }*/
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


    public static boolean isAWin() {
        //int length,int height
        // check if the current player has won
        String p = HumanAndBot.currentIcon;
        //int y = HumanAndBot.lastDraw.get(0); // from top to bottom
        //int x = HumanAndBot.lastDraw.get(1); // from left to right
        // check if the draw is on a side of the board
        // ej optimerad kod !!

        // check horizontal to see if we get any four in a row.

        // Check vertical to see if we get any four in a row.
        for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 4; row++) {
                if (Board.board[vertical][row].equals(p) && Board.board[vertical][row +1].equals(p) && Board.board[vertical][row +2 ].equals(p) && Board.board[vertical][row +3].equals(p))
                    return true;
            }
        }
        for (int horizontal = 0; horizontal < 7; horizontal++) {

            for (int row = 0; row < 4; row++) {
                if (Board.board[row][horizontal].equals(p) && Board.board[row + 1][horizontal].equals(p) && Board.board[row + 2][horizontal].equals(p) && Board.board[row + 3][horizontal].equals(p))
                    return true;
            }
        }


        /* for (int horz = 0; horz < 7; h )
        for (int row = 0; row < 4; row++){
        if(Board.board[1][row].equals(p) &&  Board.board[1][row + 1].equals(p) && Board.board[1][row + 2].equals(p) && Board.board[1][row + 3].equals(p) )return true;
        } */

        return false;
    }


}
