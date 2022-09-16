import java.util.ArrayList;

public class HumanAndBot {
    public static String Player1;
    public static String iconPlayer1;
    public static ArrayList<Integer> lastDraw = new ArrayList<Integer>(); // Create an ArrayList object
    public static String iconColor1 = ConsoleColors.BLUE;
    public static String Player2;
    public static String iconPlayer2 = "X" ;
    public static String iconColor2 =  ConsoleColors.YELLOW;
    public static String currentPlayer;
    public static String currentIcon;
    public static String currentIconColor = iconColor1;
    // todo handle this in a better way than
    public static boolean Player1Bot = false;
    public static boolean Player2Bot = false;
    public static  boolean Bot1Advanced = false;
    public static boolean Bot2Advanced = false;

    public static void resetPlayer(){
        HumanAndBot.currentPlayer = null;
        HumanAndBot.Player1 = null;
        HumanAndBot.Player2 = null;
    }


}
