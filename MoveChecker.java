import java.util.ArrayList;

public class MoveChecker {

    private static int whatMoveToMake(String opp, String own) {
        // Start with checking the opponents bricks vertical first and then horizontal and last the diagonal ways. We are only interested if the opponent has more that two in a row. If the pattern is four then it is Game Over, and we are not able to be here.

        int danger = -1;
        int dangerLeft = -1;
        int dangerRight = -1;
        int opportunity = -1;
        int opportunityLeft = -1;
        int opportunityRight = -1;
        int layTwo = -1;
        int layTwoVert = -1;

        // vertical check opponent
         for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 3; row++) {
                if (Board.board[vertical][row].equals(opp) && Board.board[vertical][row + 1].equals(opp) && Board.board[vertical][row + 2].equals(opp)
                ){
                    System.out.println("will this be better now ? It is not so fun any more, vertical");
                }

            }
        }

        // horizontal check opponent
        for(int row = 0; row < 4; row++){
            for (int column = 0;column < 6;column++){
                if(
                        Board.board[row][column].equals(opp) &&
                        Board.board[row +1][column].equals(opp) &&
                        Board.board[row +2][column].equals(opp)
                ){
                    danger = row -1;
                    System.out.println("will this be better now ? It is not so fun any more doe the horizontal");
                }

            }
        }

        // diagonal (right to left) check opponent
        for (int rad = 3; rad < Board.board.length; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (
                        Board.board[rad][kol].equals(opp)  &&
                        Board.board[rad - 1][kol + 1].equals(opp)  &&
                        Board.board[rad - 2][kol + 2].equals(opp)
                ) {
                    System.out.println("will this be better now ? It is not so fun any more doe the diagonal");
                }
            }
        }

        // diagonal (left to right) check opponent
        for (int rad = 0; rad < Board.board.length - 3; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (
                        Board.board[rad][kol].equals(opp)  &&
                        Board.board[rad + 1][kol + 1].equals(opp)  &&
                        Board.board[rad + 2][kol + 2].equals(opp)
                        ) {
                    System.out.println("will this be better now ? It is not so fun any more doe the diagonal2");
                }
            }
        }

        // vertical check your self
        for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 3; row++) {
                if (Board.board[vertical][row].equals(own) && Board.board[vertical][row + 1].equals(own) && Board.board[vertical][row + 2].equals(own)
                ){
                    System.out.println("will this be better now ? It is not so fun any more for your self, vertical");
                }

            }
        }

        // horizontal check your self
        for(int row = 0; row < 4; row++){
            for (int column = 0;column < 6;column++){
                if(
                        Board.board[row][column].equals(own) &&
                                Board.board[row +1][column].equals(own) &&
                                Board.board[row +2][column].equals(own)
                ){
                    opportunity = row -1;
                    System.out.println("will this be better now ? It is not so fun any more doe the horizontal");
                }

            }
        }

        // diagonal (right to left) check your self
        for (int rad = 3; rad < Board.board.length; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (
                        Board.board[rad][kol].equals(own)  &&
                                Board.board[rad - 1][kol + 1].equals(own)  &&
                                Board.board[rad - 2][kol + 2].equals(own)
                ) {
                    System.out.println("will this be better now ? It is not so fun any more doe the diagonal");
                }
            }
        }

        // diagonal (left to right) check your self
        for (int rad = 0; rad < Board.board.length - 3; rad++) {
            for (int kol = 0; kol < Board.board[0].length - 3; kol++) {
                if (
                        Board.board[rad][kol].equals(own)  &&
                                Board.board[rad + 1][kol + 1].equals(own)  &&
                                Board.board[rad + 2][kol + 2].equals(own)
                ) {
                    System.out.println("will this be better now ? It is not so fun any more doe the diagonal2");
                }
            }
        }

        System.out.println(danger + " " + opportunity);

        Input.sleep(400);
        return 0;
    }

    public static int handleMovesFromBot(String opp, String own) {
        return whatMoveToMake(opp, own);
    }
}
