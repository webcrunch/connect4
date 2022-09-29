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
                            " ", " ", "X", " ", " ", " ", " "
                    },
                    {
                            " ", " ", "X", " ", " ", " ", " "
                    },
                    {
                            " ", " ", "X", " ", " ", " ", " "
                    }
            };

    public static void resetBoard() {
        for (int down = 0; down < 6; down++) {
            for (int right = 0; right < 7; right++) {
                Board.board[down][right] = " ";
            }
        }
    }

    public static int countNumberOnTheBoard() {
        int totalCount = 0;
        for (int down = 0; down < 6; down++) {
            for (int right = 0; right < 7; right++) {
                totalCount = !Board.board[down][right].equals(" ") ? totalCount + 1 : totalCount;
            }
        }
        return totalCount;
    }


    public static void drawBoard() {
        //System.out.format("It is %d time to play",Players.currentPlayer);

        System.out.println("It is " + HumanAndBot.currentPlayer + "(" + HumanAndBot.currentIcon + "): time to play");
        displayRowNumbers();

        System.out.println();
        for (String[] row : board) {
            for (String cell : row) { //HumanAndBot.currentIconColor
                System.out.print("|  " + ConsoleColors.RESET + cell +  ConsoleColors.RESET + "  ");
            }
            System.out.print(ConsoleColors.RESET);
            System.out.println("|");
            System.out.println("_____________________________________________");
        }
    }

    private static boolean occupiedOrNot(int floor, int width) {
        return board[floor][width].equals(" ");
    }

    public static void displayRowNumbers(){
        for (int i = 0; i < 7; i++) {
            if (i == 6) System.out.print("   " + i + "  ");
            else System.out.print("   " + i + "  ");
        }
    }

    public static void dropToBoardPlayer(int width) {
        // check the bottom of the board and then go upwards
        // start with [floor][width]
        System.out.println(HumanAndBot.currentIconColor);
        String inputToBoard = HumanAndBot.currentIcon;
        //HumanAndBot.currentIconColor +
        for (int floor = 5; floor >= 0; floor--) {
            if (occupiedOrNot(floor, width)) {
                //HumanAndBot.lastDraw.add(floor);
                //HumanAndBot.lastDraw.add(width);
                board[floor][width] = inputToBoard;
                break;
            }
        }
    }
}
