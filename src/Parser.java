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

        try {
            commandWord = commandWord.toUpperCase(Locale.ROOT);
            if(commandWord.equals("HELP")) return 1;
            if(commandWord.equals("GO")) return 2;
            if(commandWord.equals("QUIT")) return 3;
            if(commandWord.equals("LOOK")) return 4;
            Interface.invalidWord();
            return 0;
        } catch (Exception ex) {
            Interface.invalidWord();
            return 0;
        }
    }
}
