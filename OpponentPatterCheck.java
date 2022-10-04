public class OpponentPatterCheck {

    private static int danger = -1;
    private static int dangerLeft = -1;
    private static int dangerRight = -1;

    private static void vertical(String opp) {
        // vertical check opponent
            for (int column = 0; column < 6; column++) {
                for (int row = 0; row < 5; row++) {
                  if (
                        Board.board[column][row].equals(opp) &&
                        Board.board[column][row+1].equals(opp) &&
                        Board.board[column][row+2].equals(opp)
                ) {
                    if (row - 1 >= 0 && Board.board[column][row - 1].equals(" ")) dangerLeft = row - 1;
                    if ((row + 3 < 7) && Board.board[column][row + 3].equals(" ")) dangerRight = row + 3;
                }

           }
        }
    }

    private static void horizontal(String opp) {
        // horizontal check opponent
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 4; column++) {
                if (
                        Board.board[column][row].equals(opp) &&
                                Board.board[column + 1][row].equals(opp) &&
                                Board.board[column + 2][row].equals(opp)
                ) {
                    // check if the row over the pattern is already set with its own brick then we don´t need to handle that one

                    if (column - 1 >= 0 && Board.board[row - 1][column].equals(" ")) danger = row;
                }
            }
        }
    }

    private static void rightToLeft(String opp) {

    }

    private static int leftToRight(String opp) {
        return -1;
    }

    public static int returnAMove(String opp) {
        horizontal(opp);
        vertical(opp);
        rightToLeft(opp);
        leftToRight(opp);
        System.out.println(dangerLeft + " <- danger Left ");
        System.out.println(dangerRight + " <- danger Right ");
        return danger != -1 ? danger : dangerLeft != -1 && dangerRight != -1 ? Input.randomizer(0,1) == 1 ? dangerLeft : dangerRight : dangerLeft != -1 ? dangerRight : dangerLeft != -1 ? dangerRight : -1 ;
    }
}
