public class TwoPatternCheck {

    private static int layTwo = -1;
    private static int layTwoLeft = -1;
    private static int layTwoRight = -1;

    private static void vertical() {

    }

    private static void horizontal() {

    }

    private static void rightToLeft() {

    }

    private static int leftToRight() {
        return -1;
    }

    public static int returnAMove() {
        horizontal();
        vertical();
        rightToLeft();
        leftToRight();
        return -1;
    }
}
