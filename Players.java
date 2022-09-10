import java.util.Scanner;

public class Players {

    public static boolean botOrHumanPlayer(String Players){
        return Players.equals("Human");
    }


    public  static void changeCurrentPlayer(){
        System.out.println(HumanBotInstance.currentPlayer  + "<-- current player is ");
        HumanBotInstance.currentPlayer = HumanBotInstance.Player1.equals(HumanBotInstance.currentPlayer) ? HumanBotInstance.Player2 : HumanBotInstance.Player1;
       // HumanBotInstance.currentIcon = HumanBotInstance.iconPlayer1.equals(HumanBotInstance.currentPlayer) ? HumanBotInstance.iconPlayer2 : HumanBotInstance.iconPlayer1;

        HumanBotInstance.currentIcon = HumanBotInstance.currentIcon.equals("X") ? "O" : "X";
        //System.out.println(currentPlayer); iconPlayer1 == currentIcon
    }
    public static String choosePlayers(String question) {
        Scanner inputFromUsers = new Scanner(System.in);
        String[] askUser = {"Human", "Crazy bot", "Advanced bot"};
        String userChoose = Input.menu(question,askUser);
        return userChoose;
    }

    public static void setBot(String bot, int whatBot) {
        if(whatBot == 1) {
            HumanBotInstance.currentPlayer = HumanBotInstance.Player1 = bot + "_1";
            HumanBotInstance.Player1Bot = true;
            if(bot.equals("Advanced bot"))HumanBotInstance.Bot1Advanced = true;
        }else{
            HumanBotInstance.Player2 = bot + "_2";
            HumanBotInstance.Player2Bot = true;
            if(bot.equals("Advanced bot"))HumanBotInstance.Bot2Advanced = true;
        }
    }

    public static void setPlayer(String output, int whatPlayer){
        if(whatPlayer == 1) {
            //todo add colors to choose from and icons;
            HumanBotInstance.currentPlayer = HumanBotInstance.Player1 = Input.string("Whats your name player1?");
        }
        else {
            //todo add colors to choose from and icons;
            HumanBotInstance.currentPlayer = HumanBotInstance.Player2 = Input.string("Whats your name player2?");
        }
    }
}
