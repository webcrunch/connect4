public class Main {

    public static void main(String[] args) {
        // Introduction for the user
        print("\n".repeat(60));
        print("Connect4 game");
        print("-".repeat(60));
        print("Welcome to Connect4. Rules are easy");
        print(" ".repeat(1));
        Start();
    }

    private static void Start() {
        // start with a no return ?? maybe need to change this later.
        // todo solve problem with bot handling to currentPlayer
        String player1 = Players.choosePlayers("Player 1: Are you a human or bot?");
        if(player1.contains("Human")) Players.setPlayer(1);
        else Players.setBot(player1,1);
        String player2 = Players.choosePlayers("Player 1: Are you a human or bot?");
        if(player2.contains("Human")) Players.setPlayer(2);
        else Players.setBot(player2,2);
        while (true) {
            displayBoard();
            int checkPlay = playYourTurn();
            // get a "ending" method with enum
            if(checkPlay == 1) {
                Input.print("congratulation!!" + HumanAndBot.currentPlayer + " you won this time, Revenge!!! :) 2" );
                String newGame = Input.menu("Do you want to play again?", "No i am finished", "Yes with same settings", "Yes with new settings");
                if(newGame.equals("No i am finished")){
                    Input.print("Thank you for playing");
                    break;
                }
                if(newGame.equals("Yes with same settings")){
                        HumanAndBot.currentPlayer = HumanAndBot.Player1;
                        Board.resetBoard();
                        continue;
                }
                if(newGame.equals("Yes with new settings")) {
                    HumanAndBot.resetPlayer();
                    Board.resetBoard();
                    Main.Start();
                }
            }
            if(checkPlay == 2){
                Input.print("the game was tie, better luck to both next time");
                String newGame = Input.menu("Do you want to play again?", "No i am finished", "Yes with same settings", "Yes with new settings");
                if(newGame.equals("No i am finished")){
                    Input.print("Thank you for playing");
                    break;
                }
                if(newGame.equals("Yes with same settings")){
                    HumanAndBot.currentPlayer = HumanAndBot.Player1;
                    Board.resetBoard();
                    continue;
                }
                if(newGame.equals("Yes with new settings")) {
                    HumanAndBot.resetPlayer();
                    Board.resetBoard();
                    Main.Start();
                }
            }
        }
    }

    private static int playYourTurn(){
        boolean checkForHumans = Players.botOrHumanPlayer();
        if(checkForHumans) Board.dropToBoardPlayer(Input.integer("Choose what row you want to put your coin(between 0-6)", 0,6));
        else BotPlaying.botPlaying();
        //todo check if the player has won
        boolean tie = CheckResult.tieTheBoard();
        System.out.println(tie);
        if(tie) return 2;
        boolean won = CheckResult.isAWin();
        System.out.println(won + " check if the action is perfect to win");
        if(won) return 1;
        HumanAndBot.lastDraw.clear();
        Players.changeCurrentPlayer();
        Input.sleep(2000);
        return 0;
    }

    private static void displayBoard() {
        Board.drawBoard();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
