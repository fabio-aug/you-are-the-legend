import java.util.Locale;
import java.util.Scanner;

public class Interface {

    public static void welcome() {
        System.out.println("WELCOME");
    }

    public static Scanner menu(){
        Scanner reader = new Scanner(System.in);
        System.out.println(
                " What you want to do? \n" +
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
        System.out.println("Go where?");
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
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("   go quit help look");
    }

    public static void look(String description) {
        System.out.print(description);
    }

    public static void thanks() {
        System.out.println("Thank you for playing.  Good bye.");
    }

    public static String namePlayer() {
        Scanner reader = new Scanner(System.in);
        System.out.println("namePlayer");
        return reader.nextLine();
    }

    public static String descriptionPlayer() {
        Scanner reader = new Scanner(System.in);
        System.out.println("descriptionPlayer");
        return reader.nextLine();
    }

    public static void phrase1(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("phrase1#PLAYER");
        } else {
            System.out.println("phrase1#ENEMY");
        }
    }

    public static void phrase2(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("phrase2#PLAYER");
        } else {
            System.out.println("phrase2#ENEMY");
        }
    }

    public static void phrase3(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("phrase3#PLAYER");
        } else {
            System.out.println("phrase3#ENEMY");
        }
    }

    public static void phrase4(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("phrase4#PLAYER");
        } else {
            System.out.println("phrase4#ENEMY");
        }
    }

    public static void phrase5(String whoHit){
        if(whoHit.equals("player")) {
            System.out.println("phrase5#PLAYER");
        } else {
            System.out.println("phrase5#ENEMY");
        }
    }

}
