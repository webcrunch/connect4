public class WriteComponent {
    public static void displayRowNumbers(){
        for (int i = 0; i < 7; i++) {
            if (i == 6) System.out.print("   " + i + "   ");
            else System.out.print("   " + i + "  ");
        }
    }
}