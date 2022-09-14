public class Board {
    // create a 2-way array for the board and set it as a field variable.
    public static String[][] board =
            {
                    {
                            " ", " ", " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " ", " ", ""
                    },
                    {
                            " ", " ", "X", "X", "X", "X", ""
                    },
                    {
                            " ", " ", " ", " ", " ", " ", ""
                    },
                    {
                            " ", " ", " ", " ", " ", " ", ""
                    },
                    {
                            " ", " ", " ", " ", " ", " ", ""
                    }
            };


    public static void drawBoard() {
        System.out.print(ConsoleColors.RESET);
        //System.out.format("It is %d time to play",Players.currentPlayer) ;
        System.out.println("It is " + HumanAndBot.currentPlayer + ": time to play");
        WriteComponent.displayRowNumbers();

        System.out.println();
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print("|  " +ConsoleColors.RESET + cell + ConsoleColors.RESET  + "  ");
            }
            System.out.print(ConsoleColors.RESET);
            System.out.println("|");
            System.out.println("_____________________________________________");
        }
    }

    private static boolean occupiedOrNot( int floor, int width) {
        return board[floor][width].equals(" ");
    }

    public static void dropToBoardPlayer(int width) {
        // check the bottom of the board and then go upwards
        // start with [floor][width]
        System.out.println(HumanAndBot.currentIconColor);
        String inputToBoard =  HumanAndBot.currentIcon;
        //HumanAndBot.currentIconColor +
        for (int floor = 5; floor >= 0; floor--){
            if(occupiedOrNot(floor,width)){
                System.out.println(floor + " floor and widht" + width);
                //HumanAndBot.lastDraw.add(floor);
                //HumanAndBot.lastDraw.add(width);
                //board[floor][width] = inputToBoard ;
                break;
            }

        }
        // todo check the rows column witch (row column) that is free.
    }
}
