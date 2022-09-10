import java.util.Scanner;

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

        String player1 = Players.choosePlayers("Player 1: Are you a human or bot?");
        if(player1 == "Human") Players.setPlayer(player1,1);
        else Players.setBot(player1,1);
        String player2 = Players.choosePlayers("Player 1: Are you a human or bot?");
        if(player2 == "Human") Players.setPlayer(player2,1);
        else Players.setBot(player2,2);
        while (true) {
            displayBoard();
            playYourTurn();
        }
    }

    private static void playYourTurn(){
        //todo checked for a win and check if it is a boots turn

        Board.dropToBoardPlayer(Players.currentPlayer, Input.integer("Choose what row you want to put your coin(between 0-6)", 0,6));
        //todo check if the player has won
        Players.changeCurrentPlayer();
        Input.print(Players.currentPlayer);
        Input.sleep(1500);
    }

    private static void displayBoard() {
        //print("\n".repeat(60));
        Board.drawBoard();

        //print("\n".repeat(60));
    }

    private static void print(String question, String... choices) {
        print(question);
        int number = 1;
        for (String choice : choices) {
            print(number + " " + choice);
            number++;
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
