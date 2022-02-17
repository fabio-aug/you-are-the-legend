import java.util.Locale;
import java.util.Scanner;

public class Parser {
    private String firstCommand;
    private String secondCommand;

    public Parser() {
        firstCommand = null;
        secondCommand = null;
    }

    public String getSecondCommand() {
        return secondCommand;
    }

    public Command getCommand() {
        Scanner tokenizer = Interface.menu();
        firstCommand = valueWords(tokenizer);
        secondCommand = valueWords(tokenizer);

        return new Command(firstCommand, secondCommand);
    }

    public String valueWords(Scanner tokenizer) {
        return tokenizer.hasNext() ? tokenizer.next() : null;
    }

    public int processCommand() {
        Command command = getCommand();
        String commandWord = command.getCommandWord();

        switch (commandWord.toUpperCase(Locale.ROOT)) {
            case "HELP":
                return 1;
            case "GO":
                return 2;
            case "QUIT":
                return 3;
            case "LOOK":
                return 4;
            default:
                Interface.invalidWord();
                return 0;
        }
    }
}
