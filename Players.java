import java.util.Scanner;

public class Players {

    public static void botOrHumanPlayer(){

    }
    public static String Player1 = "G";
    public static String Player2 = "Y";
    public static String Color1 = ConsoleColors.GREEN;
    public static String Color2 = ConsoleColors.YELLOW;
    public static String currentPlayer = Player1;


    public static  String colorOfPlayer(String player){
        return Player1.equals(player) ? Color1 : Color2;
    }
    // public static String whoIsCurrentPlayer(){
    //    System.out.println(Player1);
    //    return player1.currentPlayer ? player2 : player1;
    //}

    public  static void changeCurrentPlayer(){
       /* System.out.println(currentPlayer + " Current Player ");
        System.out.println(Player1 + " Player1 ");
        System.out.println(Player1.equals(currentPlayer));
        System.out.println(Player1 == currentPlayer ? Player2 : Player2); */


        //currentPlayer = Player1.equals(currentPlayer) ? Player2 : Player1;
        currentPlayer = Player1 == currentPlayer ? Player2 : Player1;
    }
    public static String choosePlayers(String question) {
        Scanner inputFromUsers = new Scanner(System.in);
        String[] askUser = {"Human", "Crazy bot", "Advanced bot"};
        //(question, askUser);

        String userChoose = Input.menu(question,askUser);
        System.out.println(userChoose);
        return userChoose;
    }

}
