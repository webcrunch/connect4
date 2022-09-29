
public class Players {

    public static boolean botOrHumanPlayer(){
        String[] player = HumanAndBot.currentPlayer.split("_");
        return  !player[0].contains("bot");
    }

    public  static void changeCurrentPlayer(){
        HumanAndBot.currentPlayer = HumanAndBot.Player1.equals(HumanAndBot.currentPlayer) ? HumanAndBot.Player2 : HumanAndBot.Player1;

        HumanAndBot.currentIcon = HumanAndBot.currentIcon.equals(HumanAndBot.iconPlayer1) ? HumanAndBot.iconPlayer2 : HumanAndBot.iconPlayer1;

        HumanAndBot.currentIconColor = HumanAndBot.Player1.equals(HumanAndBot.currentPlayer) ? HumanAndBot.iconColor2 : HumanAndBot.iconColor1;
    }
    public static String choosePlayers(String question) {
        String[] askUser = {"Human", "Crazy bot", "Advanced bot"};
        return Input.menu(question,askUser);
    }

    public static void setBot(String bot, int whatBot) {
        if(whatBot == 1) {
            HumanAndBot.currentPlayer = HumanAndBot.Player1 = bot + "_1";
            HumanAndBot.isPlayer1Bot = true;
            HumanAndBot.currentIcon = HumanAndBot.iconPlayer1 = "O";
            if(bot.equals("Advanced bot")) HumanAndBot.isBot1Advanced = true;
        }else{
            HumanAndBot.Player2 = bot + "_2";
            HumanAndBot.isPlayer2Bot = true;
            HumanAndBot.iconPlayer2 = "X";
            if(bot.equals("Advanced bot")) HumanAndBot.isBot2Advanced = true;
        }
    }

    public static void setPlayer(int whatPlayer){
        if(whatPlayer == 1) {
            //todo add colors to choose from and icons;
            HumanAndBot.currentPlayer = HumanAndBot.Player1 = Input.string("Whats your name player1?");
            HumanAndBot.iconPlayer1 = (Input.menu("Do you want to customise your icon for the player?", "Yes", "No").equals("Yes") ?
            Input.onlyString("Choose a letter from the Alphabet only (a-z) and max 1 character. Default: O").toUpperCase() : "O");
            HumanAndBot.currentIcon = HumanAndBot.iconPlayer1;
        }
        else {
            //todo add colors to choose from and icons;
            HumanAndBot.Player2 = Input.string("Whats your name player2?");
            HumanAndBot.iconPlayer2 = (Input.menu("Do you want to customise your icon for the player?", "Yes", "No").equals("Yes") ?
                    Input.onlyString("Choose a letter from the Alphabet only (a-z) and max 1 character. Default: X ").toUpperCase() : "X");
        }
    }
}
