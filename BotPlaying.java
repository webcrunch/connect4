public class BotPlaying {

    public static void botPlaying(){
        // need to remove the _number to handle what kind of bot we are working with
        String[] player = HumanAndBot.currentPlayer.split("_");
        // todo working on a advanced bot;
        if(player[0].equals("Crazy bot")){
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print("..Thinking.." + ConsoleColors.BLUE_UNDERLINED);
            System.out.print(ConsoleColors.RESET);
            System.out.print("." + ConsoleColors.BLUE_UNDERLINED.repeat(5));
            System.out.print(ConsoleColors.WHITE);
            Input.sleep(2000);
            System.out.println();
            System.out.print(ConsoleColors.RESET);
            Board.dropToBoardPlayer(Input.randomizer(0,6));
            Input.sleep(2000);
        }
        else{
            System.out.println("Good bot is playing");
        }
    }


}
