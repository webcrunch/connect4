import javax.swing.*;
import java.util.ArrayList;

public class MoveChecker {

    private static int whatMoveToMake(String opp, String own) {
        // Start with checking the opponents bricks vertical first and then horizontal and last the diagonal ways. We are only interested if the opponent has more that two in a row. If the pattern is four then it is Game Over, and we are not able to be here.
/*

        // diagonal (left to right) check opponent
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 7; row++) {
                if (
                        Board.board[column][row].equals(opp) &&
                        Board.board[column + 1][row + 1].equals(opp) &&
                        Board.board[column + 2][row + 2].equals(opp)
                ) {
                    if(row -1 >= 0 && column -1 >= 0 && Board.board[column-1][row-1].equals(" ")) dangerLeft = row -1;
                    if(row +3 <= 6 && column +3 <= 5 && Board.board[column+3][row+3].equals(" ")) dangerRight = row +3;
                }
            }
        }


        // Check for connecting four diagonal from right to left. Need to rewrite this so it takes all three pattern also
        for (int row = 3; row < 6; row++) {
            for (int column = 0; column < 3; column++) {
                if (
                        Board.board[row][column].equals(opp)  &&
                        Board.board[row - 1][column + 1].equals(opp)  &&
                        Board.board[row - 2][column + 2].equals(opp)
                ) {

                   //if(row +1 <= 6 && column -1 <= 5 && Board.board[row+1][column-1].equals(" ")) dangerLeft = row +1;
                   //if(row -3 <= 6 && column +3 <= 5 && Board.board[row-3][column+3].equals(" ")) dangerRight = row -3;
                }
            }
        }


        // vertical check for self three pattern
        for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 3; row++) {
                if (
                        Board.board[vertical][row].equals(own) &&
                            Board.board[vertical][row + 1].equals(own) && Board.board[vertical][row + 2].equals(own)
                ) {
                    System.out.println(own);
                    // check if the left or right side is beyond the side of the board or they are already set with own piece.
                    if( row -1 >= 0 && Board.board[vertical][row -1].equals(" ")) opportunityLeft = row -1;
                    if( row +3 < 7 && Board.board[vertical][row +3].equals(" ")) opportunityRight = row +3;

                }
            }
        }

        // horizontal check for self three pattern
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 6; column++) {
                if (
                        Board.board[row][column].equals(own) &&
                                Board.board[row + 1][column].equals(own) &&
                                Board.board[row + 2][column].equals(own)
                ) {
                    if (row -1 >= 0 && Board.board[row - 1][column].equals(" ")) opportunity = row - 1;
                }
            }
        }

        // diagonal (left to right) check for self
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 7; row++) {
                if (
                        Board.board[column][row].equals(own) &&
                                Board.board[column + 1][row + 1].equals(own) &&
                                Board.board[column + 2][row + 2].equals(own)
                ) {

                    if(row -1 >= 0 && column -1 >= 0 && Board.board[column-1][row-1].equals(" ")) opportunityLeft = row -1;
                    if(row +3 <= 6 && column +3 <= 5 && Board.board[column+3][row+3].equals(" ")) opportunityRight = row +3;
                }
            }
        }

        // Check for connecting four diagonal from right to left for self.
        for (int row = 3; row < Board.board.length; row++) {
            for (int column = 0; column < Board.board[0].length - 3; column++) {
                if (
                        Board.board[row][column].equals(own)  &&
                        Board.board[row - 1][column + 1].equals(own)  &&
                        Board.board[row - 2][column + 2].equals(own)
                ) {

                   if(row +1 <= 6 && column -1 <= 5 && Board.board[column-1][row+1].equals(" ")) opportunityRight = row +1;
                   if(row -3 <= 6 && column +3 <= 5 && Board.board[column+3][row-3].equals(" ")) opportunityLeft = row -3;
                }
            }
        }


        // vertical check for self two pattern
        for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 3; row++) {
                if (
                        Board.board[vertical][row].equals(own) &&
                        Board.board[vertical][row + 1].equals(own)
                ) {
                    // check if the left or right side is beyond the side of the board or they are already set with own piece.

                    if( row -1 >= 0 && Board.board[vertical][row -1].equals(" ")) layTwoLeft = row -1;

                    if( row +2 < 7 && Board.board[vertical][row +2].equals(" ")) layTwoRight = row +2;
                }
            }
        }

        // horizontal check for self two pattern
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 6; column++) {
                if (
                        Board.board[row][column].equals(own) &&
                                Board.board[row + 1][column].equals(own)
                ) {
                    // check if the row over the pattern is already set with a own brick then we don´t need to handle that one
                    if (row -1 >= 0 && Board.board[row - 1][column].equals(" ")) layTwo = row - 1;
                }
            }
        }

        Input.sleep(400);

        //todo have diagonal checks left - bug in the system. and the other checks also

*/
        int oppMove = OpponentPatterCheck.returnAMove(opp);
        int ownMove = OpportunityPatternCheck.returnAMove(own);
        int layTwoMove = TwoPatternCheck.returnAMove(own);

        return oppMove != -1 ? oppMove : ownMove != -1 ? ownMove : layTwoMove != -1 ? layTwoMove: Input.randomizer(0,6);
    }

    public static int handleMovesFromBot(String opp, String own) {
        return whatMoveToMake(opp, own);
    }
}
