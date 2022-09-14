@SuppressWarnings("InfiniteLoopStatement")
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
            boolean won = playYourTurn();
            if(won) {
                System.out.println("congratulation!!" + HumanAndBot.currentPlayer + " you won this time, Revenge!!! :) 2" ); break;
            }
        }
        //System.out.println(" player Won");
    }

    private static boolean playYourTurn(){

        //todo checked for a win and check if it is a boots turn
        boolean checkForHumans = Players.botOrHumanPlayer(HumanAndBot.currentPlayer);
        if(checkForHumans) Board.dropToBoardPlayer(Input.integer("Choose what row you want to put your coin(between 0-6)", 0,6));
        else BotPlaying.botPlaying(HumanAndBot.currentPlayer);
        //todo check if the player has won
        boolean won = CheckResult.isAWin();
        System.out.println(won + " check if the action is perfect to win");
        if(won) return true;
        HumanAndBot.lastDraw.clear();
        Players.changeCurrentPlayer();
        Input.sleep(2000);
        return false;
    }

    private static void displayBoard() {
        Board.drawBoard();
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
