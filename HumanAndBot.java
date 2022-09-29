public class HumanAndBot {

    public static String Player1, iconPlayer1, iconColor1 = ConsoleColors.BLUE;

    public static String Player2, iconPlayer2, iconColor2 =  ConsoleColors.GREEN_BOLD;
    public static String currentPlayer, currentIcon, currentIconColor = iconColor1;
    // set is in the beginning of the boolean variable name;
    public static boolean isPlayer1Bot = false, isBot1Advanced = false, isPlayer2Bot = false, isBot2Advanced = false;

    public static void resetPlayer(){
        HumanAndBot.currentPlayer = null;
        HumanAndBot.Player1 = null;
        HumanAndBot.Player2 = null;
    }

}
