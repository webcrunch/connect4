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

 /*   private static int occupiedOrNot(int choose){
        int row = -1;
        do{
            board[choose][4].equals(" ")
        }while(row < 0)
            return 2;
    }
    public static void crazyBotDropToBoard(){

    } */

    public static void dropToBoard(String player, int row){
        int minC = 0;
        int maxC = 7;
        int minR = 0;
        int maxR = 6;
        int random_intCol = (int)Math.floor(Math.random()*(maxC-minC+1)+minC);
        int random_intRow = (int)Math.floor(Math.random()*(maxR-minR+1)+minR);
        System.out.println(random_intRow + " <-row col-> " +  random_intCol);
        try{
            //String color = Players.colorOfPlayer(player);
            //System.out.println(color + " dddddddd");
            board[random_intRow][random_intCol] = player ;
            Players.changeCurrentPlayer();
        }
        catch (Exception ignore){}

        // todo check the rows column witch (rowcolumn) that is free.
    }
}
