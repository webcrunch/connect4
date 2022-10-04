public class TwoPatternCheck {

    private static int layTwo = -1;
    private static int layTwoLeft = -1;
    private static int layTwoRight = -1;

    private static void vertical() {

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
        vertical();
        rightToLeft();
        leftToRight();
        System.out.println("good to lay on that place: " + layTwo);
        return  layTwo != -1 ? layTwo : -1;
    }
}
