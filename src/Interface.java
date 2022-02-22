import java.util.Locale;
import java.util.Scanner;

public class Interface {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void welcome() {
        System.out.print(" ----Welcome to You are the legend! ----\n");
        System.out.println("---- You are the legend is adventure game. ---- \n");
    }

    public static Scanner menu() {
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
        System.exit(0);
    }

    public static String namePlayer() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Your name: ");
        return reader.nextLine();
    }

    public static void nameEnemy(String enemyDetails) {
        System.out.println("\n~~~ Enemy ~~~");
        System.out.println(enemyDetails);
        System.out.println("~~~~~~~~~~~~~\n");
    }

    public static void combatPhrase(String whoHit, int numberPhrase) {
        String[] enemyPhrases = new String[] { "The enemy is attacking you", "The enemy is really hurt" , "The enemy is getting worse and tired", "The enemy is not reacting", "The enemy is getting weak" };
        String[] playerPhrases = new String[] { "Your attack hit the enemy", "You are really hurt" , "You are getting worse and tired", "You need to react", "You are felling weak" };

        if (whoHit.equals("player")) {
            System.out.println(ANSI_BLUE + "\uD83D\uDDE1️ " + playerPhrases[numberPhrase] + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "\uD83D\uDDE1️ " + enemyPhrases[numberPhrase] + ANSI_RESET);
        }
    }

    public static void missAttack(boolean isPlayer) {
        if (isPlayer) {
            System.out.println(ANSI_BLUE + "\uD83D\uDEE1️ You missed the attack" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "\uD83D\uDEE1️ The enemy missed the attack" + ANSI_RESET);
        }
    }

    public static void youWin(String player) {
        showPlayer(player);
        System.out.print("\n✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
        System.out.print("\n✨ Congratulations! You beat Covid! ✨\n");
        System.out.print("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨\n\n");
        thanks();
    }

    public static void youLose(String player) {
        showPlayer(player);
        System.out.print("\n\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80");
        System.out.print("\n\uD83D\uDC80 You lose the game! \uD83D\uDC80\n");
        System.out.print("\uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80 \uD83D\uDC80\n");
        thanks();
    }

    public static void showPlayer(String player) {
        System.out.println(player);
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
                "\nAfter combat, you feel like this:" +
                        "\n\n~~~ Player Status ~~~~\n" + player + "\n"
        );
    }

}