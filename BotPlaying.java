public class BotPlaying {

    public static void botPlaying() {
        // need to remove the _number to handle what kind of bot we are working with
        String[] player = HumanAndBot.currentPlayer.split("_");
        // todo working on a advanced bot;
        if (player[0].equals("Crazy bot")) {
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print("..Thinking.." + ConsoleColors.BLUE_UNDERLINED);
            System.out.print(ConsoleColors.RESET);
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print(ConsoleColors.WHITE);
            Input.sleep(2000);
            System.out.println();
            System.out.print(ConsoleColors.RESET);
            Board.dropToBoardPlayer(Input.randomizer(0, 6));
            Input.sleep(2000);
        } else {
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print(".. Hard Thinking.." + ConsoleColors.BLUE_UNDERLINED);
            System.out.print(ConsoleColors.RESET);
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print(ConsoleColors.WHITE);
            Input.sleep(2000);
            System.out.println();
            System.out.print(ConsoleColors.RESET);
            // check if board is empty method. If it is empty then it is player 1s first move
            if (emptyBoardCheck()) {
                Board.dropToBoardPlayer(3);
            } else {
                Board.dropToBoardPlayer(checkForNextMove());
            }

            Input.sleep(2000);
        }
    }

    public static int checkForNextMove(){
        return totalPieceOnTheBoard();
    }

    private  static int totalPieceOnTheBoard(){
        int checkBoard = Board.countNumberOnTheBoard();
        if(checkBoard < 2){
            return Input.randomizer(0,1) == 1 ? 4 : 2;
        }
        else{
            return Input.randomizer(0,6);
        }
    }
    private static boolean emptyBoardCheck() {
        String p = HumanAndBot.currentIcon;
        // check if we have a win, then it is not a tie
        // otherwise check if the board is full, then it is a tie
        for (String[] row : Board.board) {
            for (String cell : row) {
                if (p.contains(cell)) {
                    // found an empty space, not a tie
                    return false;
                }
            }
        }
        // didn't return before, so it is a tie
        return true;
    }


}
