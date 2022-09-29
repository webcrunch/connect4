public class EndingHandling {
    public static void handleEndings(String status){
        if(status.equals("End")) endOfGameHandling();
        else tieOfGameHandling();
    }


    private static void doYouWantToPlayANewGame(){
        String newGame = Input.menu("Do you want to play again?", "No i am finished", "Yes with same settings", "Yes with new settings");

        // switch case here

        if(newGame.equals("No i am finished")){
            Input.print("Thank you for playing");
            System.exit(0);
        }
        if(newGame.equals("Yes with same settings")){
            HumanAndBot.currentPlayer = HumanAndBot.Player1;
            Board.resetBoard();
            Main.startTheGame();
        }
        if(newGame.equals("Yes with new settings")) {
            HumanAndBot.resetPlayer();
            Board.resetBoard();
            Main.initTheGame();
        }
    }
    private static void endOfGameHandling(){
        Board.drawBoard();
        Input.print("congratulation!! " + HumanAndBot.currentPlayer + " you won this time, Revenge for " + (HumanAndBot.currentPlayer.equals(HumanAndBot.Player1) ? HumanAndBot.Player2 : HumanAndBot.Player1) +  "!!! :)" );

        doYouWantToPlayANewGame();
    }

    private static void tieOfGameHandling(){
        Board.drawBoard();
        Input.print("the game was tie, better luck to both next time");
        doYouWantToPlayANewGame();
    }
}
