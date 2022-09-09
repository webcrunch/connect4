public class Board {
    // create a 2-way array for the board and set it as a field variable.
    public static String[][] board =
            {
                    {
                            " "  ," " , " ", " ", " ", " ", " "
                    },
                    {
                            " ", " ", " ", " ", " "  , " ", " "
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


    public static void drawBoard(){
        //System.out.format("It is %d time to play",Players.currentPlayer) ;
        System.out.println("It is " + Players.currentPlayer + ": time to play");
        for(String[] row : board){
            for(String cell : row){
                System.out.print("|  " + cell + "  ");
            }
            System.out.println("|");
            System.out.println("_____________________________________________");
        }
    }

    public static void dropToBoard(String player, int row){
        System.out.println(player);
        System.out.println(row);
        // todo check the rows column witch (rowcolumn) that is free.
    }
}
