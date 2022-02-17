public class Game {

    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
    }

    private void createRooms() {
        Room reception, aWing, pharmacy, corridorOne, bWing, stock, cWing, bathroom, corridorTwo, corridorThree, infirmary, laboratory;

        reception = new Room("reception");
        aWing = new Room("aWing");
        pharmacy = new Room("pharmacy");
        corridorOne = new Room("corridorOne");
        bWing = new Room("bWing");
        stock = new Room("stock");
        cWing = new Room("cWing");
        bathroom = new Room("bathroom");
        corridorTwo = new Room("corridorTwo");
        corridorThree = new Room("corridorThree");
        infirmary = new Room("infirmary");
        laboratory = new Room("laboratory");

        reception.setExit("north", aWing);

        aWing.setExit("north", pharmacy);
        aWing.setExit("south", reception);
        aWing.setExit("west", corridorOne);

        pharmacy.setExit("south", aWing);

        corridorOne.setExit("east", aWing);
        corridorOne.setExit("south", bWing);

        bWing.setExit("north", corridorOne);
        bWing.setExit("east", stock);
        bWing.setExit("west", cWing);

        cWing.setExit("north", corridorTwo);
        cWing.setExit("east", bWing);
        cWing.setExit("west", bathroom);

        corridorTwo.setExit("north", corridorThree);
        corridorTwo.setExit("south", cWing);

        corridorThree.setExit("north", laboratory);
        corridorThree.setExit("east", infirmary);
        corridorThree.setExit("south", corridorTwo);

        laboratory.setExit("south", corridorThree);

        currentRoom = reception;
    }

    public void play() {
        Interface.welcome();
        boolean finished = false;

        while (!finished) {
            parser = new Parser();
            finished = selectedCommand(parser.processCommand());
        }

        Interface.thanks();
    }

    private boolean selectedCommand(int option) {
        if(option == 0) return false;
        if(option == 1) Interface.help();
        if(option == 2) goRoom();
        if(option == 3) return Interface.quit();
        if(option == 4) Interface.look(currentRoom.getDetailedDescription());

        return false;
    }

    private void goRoom() {
        String direction = parser.getSecondCommand();

        if (direction == null) {
            Interface.goWhere();
            return;
        }

        Room room = currentRoom.getExit(direction);

        if (room == null) {
            Interface.noDoor();
        } else {
            currentRoom = room;
            Interface.look(currentRoom.getDetailedDescription());
        }
    }
}
