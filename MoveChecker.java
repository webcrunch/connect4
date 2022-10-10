import javax.swing.*;
import java.util.ArrayList;

public class MoveChecker {

    private static int whatMoveToMake(String opp, String own) {
        // Start with checking the opponents bricks vertical first and then horizontal and last the diagonal ways. We are only interested if the opponent has more that two in a row. If the pattern is four then it is Game Over, and we are not able to be here.

        int oppMove = OpponentPatterCheck.returnAMove(opp);
        int ownMove = OpportunityPatternCheck.returnAMove(own);
        int layTwoMove = TwoPatternCheck.returnAMove(own);
        int layDangerTeoMove = OpponentPatterCheck.returnAMove(opp);
        System.out.println(oppMove);
        return oppMove != -1 ? oppMove : ownMove != -1 ? ownMove : layTwoMove != -1 ? layTwoMove: Input.randomizer(0,6);
    }

    public static int handleMovesFromBot(String opp, String own) {
        return whatMoveToMake(opp, own);
    }
}
