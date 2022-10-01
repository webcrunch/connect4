import javax.swing.*;
import java.util.ArrayList;

public class MoveChecker {

    private static int whatMoveToMake(String opp, String own) {
        // Start with checking the opponents bricks vertical first and then horizontal and last the diagonal ways. We are only interested if the opponent has more that two in a row. If the pattern is four then it is Game Over, and we are not able to be here.
/*
        int danger = -1;
        int dangerLeft = -1;
        int dangerRight = -1;
        int opportunity = -1;
        int opportunityLeft = -1;
        int opportunityRight = -1;
        int layTwo = -1;
        int layTwoLeft = -1;
        int layTwoRight = -1;


        for (int column = 0; column < 6;column++){
        for (int row = 0; row < 4; row++){
            System.out.println(column + " " + row);
        }
        }
/*
        // vertical check opponent

        for (int vertical = 0; vertical < 6; vertical++) {
            for (int row = 0; row < 3; row++) {
                if (Board.board[vertical][row].equals(opp) && Board.board[vertical][row + 1].equals(opp) && Board.board[vertical][row + 2].equals(opp)
                ) {
                    // check if the left or right side is beyond the side of the board or they are already set with own piece.

                    if( row -1 >= 0 && Board.board[vertical][row -1].equals(" ")) dangerLeft = row -1;
                    if( row +3 < 7 && Board.board[vertical][row +3].equals(" "))dangerRight = row +3;

                }
            }
        }

        // horizontal check opponent
        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 4; column++) {

                if (
                        Board.board[column][row].equals(opp) &&
                        Board.board[column + 1][row].equals(opp) &&
                        Board.board[column + 2][row].equals(opp)
                ) {
                    // check if the row over the pattern is already set with a own brick then we don´t need to handle that one

                    if (column -1 >= 0 && Board.board[row - 1][column].equals(" ")) danger = row - 1;
                }
            }
        }
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

        // prioritize danger first top then right/left (randomize 0,1 (0 left 1 right))
        // then opportunity same approach
        // last lay and also same approach.

        // first check the danger.
        int leftRight = Input.randomizer(0,1);

    Integer checkOpponentWinMove = danger != -1 ? danger: dangerLeft != -1 && dangerRight != -1 ? leftRight == 1? dangerRight : dangerLeft : dangerLeft != -1 ? dangerLeft : dangerRight != -1 ? dangerRight : -1;
        Integer checkOwnWinMove = opportunity != -1 ? opportunity: opportunityLeft != -1 && opportunityRight != -1 ? leftRight == 1 ? opportunityRight : opportunityLeft : opportunityLeft != -1 ? opportunityLeft : opportunityRight != -1 ? opportunityRight : -1;
        Integer checkOwnMove = layTwo != -1 ? layTwo: layTwoLeft != -1 && layTwoRight != -1 ? leftRight == 1 ? layTwoRight : layTwoLeft : layTwoLeft != -1 ? layTwoLeft : layTwoRight != -1 ? layTwoRight : -1;

        Input.sleep(400);

        //todo have diagonal checks left - bug in the system. and the other checks also
        //return checkOpponentWinMove != -1 ? checkOpponentWinMove : checkOwnWinMove != -1 ? checkOwnWinMove : checkOwnMove != -1 ? checkOwnMove : Input.randomizer(0,6);
        return checkOpponentWinMove != -1 ? checkOpponentWinMove : checkOwnWinMove != -1 ? checkOwnWinMove : checkOwnMove != -1 ? checkOwnMove : Input.randomizer(0,6);
*/
        int oppMove = OpponentPatterCheck.returnAMove(opp);
        int ownMove = OpportunityPatternCheck.returnAMove();
        int layTwoMove = TwoPatternCheck.returnAMove();
        
        return oppMove != -1 ? oppMove : Input.randomizer(0,6);
    }

    public static int handleMovesFromBot(String opp, String own) {
        return whatMoveToMake(opp, own);
    }
}
