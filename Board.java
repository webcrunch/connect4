public class Board {
    // create a 2-way array for the board and set it as a field variable.
    public static String[][] board =
            {
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    }
            };


    public static void drawBoard() {
        //System.out.format("It is %d time to play",Players.currentPlayer) ;
        System.out.println("It is " + HumanBotInstance.currentPlayer + ": time to play");
        WriteComponent.displayRowNumbers();
        System.out.println();
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print("|  " + cell + "  ");
            }
            System.out.println("|");
            System.out.println("_____________________________________________");
        }
    }

    private static boolean occupiedOrNot(int width, int floor) {
        return board[floor][width].equals(" ");
    }

    public static void dropToBoardPlayer(String player, int width) {
        // check the bottom of the board and then go upwards
        // start with [floor][width]
        for (int floor = 5; floor >= 0; floor--){
            if(occupiedOrNot(width,floor)){
                board[floor][width] = HumanBotInstance.currentIcon;
                break;
            }
            else continue;
        }
        // todo check the rows column witch (row column) that is free.
    }
}
