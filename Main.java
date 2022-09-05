import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int player1 =  choosePlayers("Player 1: Are you a human or bot?");
        System.out.println(player1);
    }

    private static int choosePlayers(String question){
        Scanner inputFromUsers = new Scanner(System.in);
        print(question, "1. Human", "2. crazy bot", "3. advanced bot");

        int userChoose = Integer.parseInt(inputFromUsers.nextLine());
        return userChoose;
    }


    private static void print(String question, String... choices){
        print(question);
        int number = 0;
        for (String choice : choices) {
            print(choice);
            number++;
        }
    }


    private static void print(String message){
        System.out.println(message);
    }
}
