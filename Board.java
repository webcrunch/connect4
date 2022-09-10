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
        System.out.println("It is " + Players.currentPlayer + ": time to play");
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

 /*
    public static void crazyBotDropToBoard(){

    } */

    private static boolean occupiedOrNot(int width, int floor) {
        System.out.println(width + " "  + floor);
        return board[floor][width].equals(" ");
    }

    public static void dropToBoardPlayer(String player, int width) {
        // check the bottom of the board and then go upwards
        // start with [floor][width]
        for (int floor = 5; floor >= 0; floor--){
            if(occupiedOrNot(width,floor)){
                System.out.println(Players.currentIcon);
                board[floor][width] = Players.currentIcon;
                break;
            }
            else continue;
        }
  //      board[1][6] = "X";
        /*int minC = 0;
        int maxC = 7;
        int minR = 0;
        int maxR = 6;
        int random_intCol = (int) Math.floor(Math.random() * (maxC - minC + 1) + minC);
        int random_intRow = (int) Math.floor(Math.random() * (maxR - minR + 1) + minR);
        System.out.println(random_intRow + " <-row col-> " + random_intCol);
        try {
            //String color = Players.colorOfPlayer(player);
            //System.out.println(color + " dddddddd");
            board[random_intRow][random_intCol] = player;
            Players.changeCurrentPlayer();
        } catch (Exception ignore) {
        }*/

        // todo check the rows column witch (rowcolumn) that is free.
    }
}
