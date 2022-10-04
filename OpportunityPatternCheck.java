public class OpportunityPatternCheck {

    private static int opportunity = -1;
    private static int opportunityLeft = -1;
    private static int opportunityRight = -1;

    private static void vertical(String own) {
        // vertical check opponent
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 5; row++) {
                if (
                        Board.board[column][row].equals(own) &&
                                Board.board[column][row+1].equals(own) &&
                                Board.board[column][row+2].equals(own)
                ) {
                    if (row - 1 >= 0 && Board.board[column][row - 1].equals(" ")) opportunityLeft = row - 1;
                    if ((row + 3 < 7) && Board.board[column][row + 3].equals(" ")) opportunityRight = row + 3;
                }
            }
        }
    }

    private static void horizontal(String own) {
        // horizontal check opponent
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 4; column++) {
                if (
                        Board.board[column][row].equals(own) &&
                                Board.board[column + 1][row].equals(own) &&
                                Board.board[column + 2][row].equals(own)
                ) {
                    // check if the row over the pattern is already set with its own brick then we don´t need to handle that one

                    if (column - 1 >= 0 && Board.board[row - 1][column].equals(" ")) opportunity = row;
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

        System.out.println(opportunityLeft + " <- opportunity Left ");
        System.out.println(opportunityRight + " <- opportunity Right ");

        return opportunity != -1 ? opportunity : opportunityLeft != -1 && opportunityRight != -1 ? Input.randomizer(0,1) == 1 ? opportunityRight : opportunityLeft: opportunityLeft != -1 ? opportunityLeft : opportunityRight != -1 ? opportunityRight : -1;
    }

}
