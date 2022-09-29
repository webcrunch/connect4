public class Main {

    public static void main(String[] args) {
        // Introduction for the user
        print("\n".repeat(60));
        print("Connect4 game");
        print("-".repeat(60));
        //todo add rules.
        print("Welcome to Connect4. Rules are easy");
        print(" ".repeat(1));
        initTheGame();
    }

    public static void initTheGame() {
        String player1 = Players.choosePlayers("Player 1: Are you a human or bot?");
        if(player1.contains("Human")) Players.setPlayer(1);
        else Players.setBot(player1,1);
        String player2 = Players.choosePlayers("Player 2: Are you a human or bot?");
        if(player2.contains("Human")) Players.setPlayer(2);
        else Players.setBot(player2,2);

        startTheGame();
    }

    public static void startTheGame(){
        while (true) {
            displayBoard();
            int checkPlay = playYourTurn();
            if(checkPlay == 1)EndingHandling.handleEndings("End");
            if(checkPlay == 2)EndingHandling.handleEndings("Tie");
        }
    }


    private static int playYourTurn(){
        boolean checkForHumans = Players.botOrHumanPlayer();
        if(checkForHumans) Board.dropToBoardPlayer(Input.integer("Choose what row you want to put your coin(between 0-6)", 0,6));
        else BotPlaying.botPlaying();
        //todo check if the player has won
        boolean tie = CheckResult.tieTheBoard();
        if(tie) return 2;
        boolean won = CheckResult.isAWin();
        if(won) return 1;
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
