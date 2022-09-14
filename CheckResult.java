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
                if (Board.board[vertical][row].equals(p) && Board.board[vertical][row + 1].equals(p) && Board.board[vertical][row + 2].equals(p) && Board.board[vertical][row + 3].equals(p))
                    return true;
            }
        }
        // problem med index 6 out of bounds for length 6 ???
        for (int horizontal = 0; horizontal < 7; horizontal++) {
            for (int row = 0; row < 4; row++) {

                if ((row + 3 < 6) && Board.board[row][horizontal].equals(p) && Board.board[row + 1][horizontal].equals(p) && Board.board[row + 2][horizontal].equals(p) && Board.board[row + 3][horizontal].equals(p))
                    return true;
            }
        }

        // Check vertical left to right first
        for (int diagonalLoop = 0; diagonalLoop < 4; diagonalLoop++) {
            if (Board.board[diagonalLoop][diagonalLoop].equals(p) && Board.board[diagonalLoop + 1][diagonalLoop + 1].equals(p) && Board.board[diagonalLoop + 2][diagonalLoop + 2].equals(p) && Board.board[diagonalLoop + 3][diagonalLoop + 3].equals(p))
                return true;
        }

        // Check vertical left to right
        for (int diagonalLoop = 0; diagonalLoop < 4; diagonalLoop++) {
            if (diagonalLoop == 0) {
                for (int innerLoop = 0; innerLoop < 3; innerLoop++) {
                    if (Board.board[innerLoop][innerLoop].equals(p) && Board.board[innerLoop + 1][innerLoop + 1].equals(p) && Board.board[innerLoop + 2][innerLoop + 2].equals(p) && Board.board[innerLoop + 3][innerLoop + 3].equals(p))
                        return true;
                }
                // 3 loops
            } else if (diagonalLoop == 1) {
                for (int innerLoop = 1; innerLoop < 4; innerLoop++) {
                    if (Board.board[innerLoop][innerLoop].equals(p) && Board.board[innerLoop + 1][innerLoop + 1].equals(p) && Board.board[innerLoop + 2][innerLoop + 2].equals(p) && Board.board[innerLoop + 3][innerLoop + 3].equals(p))
                        return true;
                }
            } else if (diagonalLoop == 2) {
                {
                    for (int innerLoop = 2; innerLoop < 4; innerLoop++) {
                        if (Board.board[innerLoop][innerLoop].equals(p) && Board.board[innerLoop + 1][innerLoop + 1].equals(p) && Board.board[innerLoop + 2][innerLoop + 2].equals(p) && Board.board[innerLoop + 3][innerLoop + 3].equals(p))
                            return true;
                    }
                }
            } else {
                if (Board.board[diagonalLoop][diagonalLoop].equals(p) && Board.board[diagonalLoop + 1][diagonalLoop + 1].equals(p) && Board.board[diagonalLoop + 2][diagonalLoop + 2].equals(p) && Board.board[diagonalLoop + 3][diagonalLoop + 3].equals(p))
                    return true;
            }
            /*  */
        }
        // Check vertical right to left
          /*   for (int innerLoop = 6; innerLoop > 2; innerLoop--){

                } */

            /*  */

        return false;
    }


}
