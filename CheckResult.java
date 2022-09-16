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
        // kolla efter 4 i rad uppåt och neråt
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
        // kolla efter 4 i rad diagonalt upp

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

    public static boolean isaTwo() {
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
        // Check horizontal to see if we get any four in a row.
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

        }
        // Check vertical right to left - hard coded for two patterns outer four in a row on the matrix (can only be one correct pattern)
        if(Board.board[0][3].equals(p) && Board.board[1][2].equals(p) && Board.board[2][1].equals(p) && Board.board[3][0].equals(p) || Board.board[2][6].equals(p) && Board.board[3][5].equals(p) && Board.board[4][4].equals(p) && Board.board[5][5].equals(p) )return true;


        // Check vertical right to left - hard coded for other patterns

        if(Board.board[0][4].equals(p) && Board.board[1][3].equals(p) && Board.board[2][2].equals(p) && Board.board[3][0].equals(p) || Board.board[2][6].equals(p) && Board.board[3][5].equals(p) && Board.board[4][4].equals(p) && Board.board[5][5].equals(p) )return true;

        if(Board.board[1][6].equals(p) && Board.board[2][5].equals(p) && Board.board[3][4].equals(p) && Board.board[4][3].equals(p) || Board.board[2][5].equals(p) && Board.board[3][4].equals(p) && Board.board[4][3].equals(p) && Board.board[5][1].equals(p) )return true;

        /*
        * 3 st pattern x 2
        *
        * 0,5 | 1,4 | 2,3 | 3,2
        * 2,3 | 3,2 | 4,1 | 5,0
        * 1,4 | 2,3 | 3,2 | 4,1
        *
        * */

        if(Board.board[0][5].equals(p) && Board.board[1][4].equals(p) && Board.board[2][3].equals(p) && Board.board[3][2].equals(p) || Board.board[2][3].equals(p) && Board.board[3][2].equals(p) && Board.board[4][1].equals(p) && Board.board[5][0].equals(p) || Board.board[1][4].equals(p) && Board.board[2][3].equals(p) && Board.board[3][2].equals(p) && Board.board[4][1].equals(p) )return true;

        /*
         * 3 st pattern x 2
         *
         * 0,6 | 1,5 | 2,4 | 3,3
         * 1,5 | 2,4 | 3,3 | 4,2
         * 2,4 | 3,3 | 4,2 | 5,1
         *
         * */
        if(Board.board[0][6].equals(p) && Board.board[1][5].equals(p) && Board.board[2][4].equals(p) && Board.board[3][3].equals(p) || Board.board[1][5].equals(p) && Board.board[2][4].equals(p) && Board.board[3][3].equals(p) && Board.board[4][2].equals(p) || Board.board[2][4].equals(p) && Board.board[3][3].equals(p) && Board.board[4][2].equals(p) && Board.board[5][1].equals(p) )return true;

        return false;
    }


}
