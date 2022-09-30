public class BotPlaying {

    public static void botPlaying() {
        String[] player = HumanAndBot.currentPlayer.split("_");

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
                Board.dropToBoardPlayer(totalPieceOnTheBoard());
            }

            Input.sleep(2000);
        }
    }

    public static int checkForNextMove() {
        return MoveChecker.handleMovesFromBot(HumanAndBot.currentPlayer.equals(HumanAndBot.Player1) ? HumanAndBot.iconPlayer2 : HumanAndBot.iconPlayer1, HumanAndBot.currentIcon);
    }

    private static int totalPieceOnTheBoard() {
        int checkBoard = Board.countNumberOnTheBoard();
        if (checkBoard < 2) return Input.randomizer(0, 1) == 1 ? 4 : 2;
        else return checkForNextMove();
    }

    private static boolean emptyBoardCheck() {
        int numberOfSpaces = 0;
        for (String[] row : Board.board) {
            for (String cell : row) {
                if (cell.equals(" ")) numberOfSpaces++;
            }
        }
        return (numberOfSpaces == 6 * 7) ? true : false;

    }


}
