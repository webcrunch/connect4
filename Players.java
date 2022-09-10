import java.util.Scanner;

public class Players {

    public static void botOrHumanPlayer(){

    }
    public static String Player1;
    public static String Player2;
    public static String iconPlayer1 = "O" ; //+ ConsoleColors.GREEN
    public static String iconPlayer2 = "O" ;//+  ConsoleColors.YELLOW;
    public static String currentPlayer;
    public static String currentIcon = iconPlayer1;
    // todo handle this in a better way than
    public static boolean Player1Bot = false;
    public static boolean Player2Bot = false;
    public static  boolean Bot1Advanced = false;
    public static boolean Bot2Advanced = false;

    public  static void changeCurrentPlayer(){
        System.out.println(currentPlayer);
        //System.out.println(iconPlayer1.equals(currentIcon));
        currentPlayer = Player1.equals(currentPlayer) ? Player2 : Player1;
        currentIcon = iconPlayer1.equals(currentIcon) ? iconPlayer2 : iconPlayer1;
        System.out.println(currentIcon);
    }
    public static String choosePlayers(String question) {
        Scanner inputFromUsers = new Scanner(System.in);
        String[] askUser = {"Human", "Crazy bot", "Advanced bot"};
        String userChoose = Input.menu(question,askUser);
        return userChoose;
    }

    public static void setBot(String bot, int whatBot) {
        if(whatBot == 1) {
            Players.Player1Bot = true;
            if(bot.equals("Advanced bot"))Players.Bot1Advanced = true;
            Players.currentPlayer = bot;
        }else{
            Players.Player2Bot = true;
            if(bot.equals("Advanced bot"))Players.Bot2Advanced = true;
            Players.currentPlayer = bot;
        }
    }

    public static void setPlayer(String output, int whatPlayer){
        if(whatPlayer == 1) {
            //todo add colors to choose from and icons;
            currentPlayer = Player1 = Input.string("Whats your name player1?");
        }
        else {
            //todo add colors to choose from and icons;
            currentPlayer = Player2 = Input.string("Whats your name player2?");
        }
    }
}
