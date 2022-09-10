public class BotPlaying {

    public static void botPlaying(String Player){
        // need to remove the _number to handle what kind of bot we are working with
        String[] player = Player.split("_");
        // todo working on a bad bot and and advanced bot;
        if(player[0].equals("Crazy bot")){
            System.out.print(".".repeat(5));
            System.out.print("..Thinking..");
            System.out.print(".".repeat(5));
            Input.sleep(1000);
            System.out.println();
            System.out.println("Bad bot is laying on a random column");
            Board.dropToBoardPlayer(HumanBotInstance.currentPlayer, Input.randomizer(0,6));
            Input.sleep(1000);
        }
        else{
            System.out.println("Good bot is playing");
        }
    }


}
