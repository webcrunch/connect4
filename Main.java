import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Introduction for the user
        print("\n".repeat(60));
        print("Connect4 game");
        print("-".repeat(60));
        print("Welcome to Connect4. Rules are easy");
        print(" ".repeat(1));
        // ta kod från Thomas valKompassen
        Start();
    }


    private static void Start(){
        // start with a no return ?? maybe need to change this later.
        int player1 =  choosePlayers("Player 1: Are you a human or bot?");
        int player2 =  choosePlayers("Player 1: Are you a human or bot?");
        System.out.println(player1 + " " + player2);

    }

    private static int choosePlayers(String question){
        Scanner inputFromUsers = new Scanner(System.in);
        print(question, "Human", "Crazy bot", "Advanced bot");

        int userChoose = Integer.parseInt(inputFromUsers.nextLine());
        return userChoose;
    }


    private static void print(String question, String... choices){
        print(question);
        int number = 1;
        for (String choice : choices) {
            print(number + " " + choice);
            number++;
        }
    }


    private static void print(String message){
        System.out.println(message);
    }
}
