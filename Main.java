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
        String player2 = Players.choosePlayers("Player 2: Are you a human or bot?");

        while (true) {
            displayBoard();
            dropElement();
        }

    }

    private static void dropElement(){
        //todo change so it changes players after the previous player had mad it draw and checked for a win
        //int row = Input.integer("Choose what row you want to put your coin", 1,7);
        Board.dropToBoard(Players.currentPlayer, Input.integer("Choose what row you want to put your coin", 1,7));
        System.out.println(Players.currentPlayer);
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
