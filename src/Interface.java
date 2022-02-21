import java.util.Locale;
import java.util.Scanner;

public class Interface {

    public static void welcome() {
        System.out.print(" ----Welcome to You are the legend! ----\n");
        System.out.println("---- You are the legend is adventure game. ---- \n");
    }

    public static Scanner menu(){
        Scanner reader = new Scanner(System.in);
        System.out.println(
                "\nWhat you want to do? \n" +
                "------------------------\n" +
                "         HELP\n" +
                "         GO\n" +
                "         LOOK\n" +
                "------------------------\n" +
                "         QUIT\n" +
                "------------------------"
        );

        return new Scanner(reader.nextLine());
    }

    public static void invalidWord() {
        System.out.println("I don't know what you mean...");
    }

    public static void goWhere() {
        System.out.println("Go ... where?");
        System.out.println("You have to write go + the direction that you wanna go.");
    }

    public static void noDoor() {
        System.out.println("There is no door!");
    }

    public static boolean quit() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Do you really want to quit the game ? (Yes/No)");
        String option = reader.nextLine().toUpperCase(Locale.ROOT);

        return (option.equals("YES") || option.equals("Y"));
    }

    public static void help() {
        System.out.println("You are lost!!!");
        System.out.println("You are alone inside the hospital, Try to defeat the enemy that threatens the survival of humanity on earth. ");
        System.out.println("Navigate through the rooms and use the right tools to beat him.");
        System.out.println();
        System.out.println("Access \"look\" to see the possible exits from the room.");
        System.out.println("Use the go command to move between rooms.");
        System.out.println("Example: \"go north\" to go to the next room.");
        System.out.println();
    }

    public static void look(String description) {
        System.out.print(description);
    }

    public static void thanks() {
        System.out.println("Thank you for playing.  Good bye.");
    }

    public static String namePlayer() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Your name: ");
        return reader.nextLine();
    }

    public static void nameEnemy(String enemyDetails) {
        System.out.println("<     -- Enemy --     >");
        System.out.println(enemyDetails);
        System.out.println("<     ---     >");
    }

    public static void phrase1(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("You took one in the face");
        } else {
            System.out.println("Enemy took one in the face");
        }
    }

    public static void phrase2(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("You are not doing well");
        } else {
            System.out.println("Enemy are not doing well");
        }
    }

    public static void phrase3(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("You are worse than a stray dog");
        } else {
            System.out.println("Enemy are worse than a stray dog");
        }
    }

    public static void phrase4(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("You need to react");
        } else {
            System.out.println("Enemy is not reacting");
        }
    }

    public static void phrase5(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("Your Ki is weak");
        } else {
            System.out.println("Enemy's Ki is weak");
        }
    }

    public static void YouWin(String player) {
        showPlayerAfterItem(player);
        System.out.println("<     ----     >");
        System.out.println("  You win game  ");
        System.out.println("<     ----     >");
        System.exit(0);
    }

    public static void findItem(String currentRoomName, String item) {
        System.out.println(
                "\nAfter you enter the " +
                currentRoomName +
                " you found the following item " + item
        );
    }

    public static void showPlayerAfterItem(String player) {
        System.out.println(
            "After picking up the item, you feel a little stronger." +
                    "\n\n~~~ Player Status ~~~~\n" + player
        );
    }
    public static void showPlayerAfterCombat(String player) {
        System.out.println(
                "After combat, you feel like this" +
                        "\n\n~~~ Player Status ~~~~\n" + player + "\n"
        );
    }
}
