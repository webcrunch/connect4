public class TwoPatternCheck {

    private static int layTwo = -1;
    private static int layTwoLeft = -1;
    private static int layTwoRight = -1;

    private static void vertical(String own) {
        // vertical check opponent
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 6; row++) {
                if (
                        Board.board[column][row].equals(own) &&
                        Board.board[column][row+1].equals(own)
                ) {
                    if (row - 1 >= 0 && Board.board[column][row - 1].equals(" ")) layTwoLeft = row - 1;
                    if ((row + 2 < 7) && Board.board[column][row + 2].equals(" ")) layTwoRight = row + 2;
                }
            }
        }
    }


    private static void horizontal(String own) {
        // horizontal check opponent
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 5; column++) {
                if (
                        Board.board[column][row].equals(own) &&
                        Board.board[column + 1][row].equals(own)
                ) {
                    // check if the row over the pattern is already set with its own brick then we don´t need to handle that one
                    if (column - 1 >= 0 && Board.board[row - 1][column].equals(" ")) layTwo = row;
                }
            }
        }
    }

    private static void rightToLeft() {

    }

    private static int leftToRight() {
        return -1;
    }

    public static int returnAMove(String own) {
        horizontal(own);
        vertical(own);
        rightToLeft();
        leftToRight();

        System.out.println(layTwoLeft + " <- lay Left ");
        System.out.println(layTwoRight + " <- lay Right ");

        return  layTwo != -1 ? layTwo : layTwoLeft != -1 && layTwoRight != -1 ? Input.randomizer(0,1) == 1 ? layTwoRight : layTwoLeft : layTwoLeft != -1 ? layTwoLeft : layTwoRight != -1 ? layTwoRight : -1;
    }
}
