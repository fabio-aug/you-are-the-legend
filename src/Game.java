import java.util.ArrayList;

public class Game {

    private Parser parser;
    private ArrayList<Room> listRoom;
    private Room currentRoom;
    private Player player;

    public Game() {
        createPlayer();
        createRooms();
    }

    private void createPlayer() {
        String name = Interface.namePlayer();
        String description = Interface.descriptionPlayer();
        this.player = new Player(name, description, 10, 10);
    }

    private void createRooms() {
        listRoom = new ArrayList<>();

        Room reception, aWing, pharmacy, corridorOne, bWing, stock, cWing, bathroom, corridorTwo, corridorThree, infirmary, laboratory;

        reception = new Room("reception", 0);
        aWing = new Room("aWing", 1);
        pharmacy = new Room("pharmacy", 2);
        corridorOne = new Room("corridorOne", 3);
        bWing = new Room("bWing", 4);
        stock = new Room("stock", 5);
        cWing = new Room("cWing", 6);
        bathroom = new Room("bathroom", 7);
        corridorTwo = new Room("corridorTwo", 8);
        corridorThree = new Room("corridorThree", 9);
        infirmary = new Room("infirmary", 10);
        laboratory = new Room("laboratory", 11);

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

        listRoom.add(reception);
        listRoom.add(aWing);
        listRoom.add(pharmacy);
        listRoom.add(corridorOne);
        listRoom.add(bWing);
        listRoom.add(stock);
        listRoom.add(cWing);
        listRoom.add(bathroom);
        listRoom.add(corridorTwo);
        listRoom.add(corridorThree);
        listRoom.add(infirmary);
        listRoom.add(laboratory);

        currentRoom = listRoom.get(0);
    }

    public void play() {
        Interface.welcome();
        boolean finished = false;

        while (!finished && (player.getLife() > 0)) {
            parser = new Parser();
            finished = selectedCommand(parser.processCommand());
        }

        Interface.thanks();
    }

    private boolean selectedCommand(int option) {
        if (option == 0) return false;
        if (option == 1) Interface.help();
        if (option == 2) goRoom();
        if (option == 3) return Interface.quit();
        if (option == 4) Interface.look(currentRoom.getDetailedDescription());

        return false;
    }

    private void goRoom() {
        String direction = parser.getSecondCommand();

        if (direction == null) {
            Interface.goWhere();
            return;
        }

        Room roomDirection = currentRoom.getExit(direction);

        if (roomDirection == null) {
            Interface.noDoor();
        } else {
            for (Room room : listRoom) {
                if (room.getId() == roomDirection.getId()) roomDirection = room;
            }
            currentRoom = roomDirection;
            Interface.look(currentRoom.getDetailedDescription());
            if (checkEnemyRoom()) executeCombat();
        }
    }

    private void executeCombat() {
        Combat combat = new Combat(player, currentRoom.getEnemy());
        combat = Combat.execute(combat);

        currentRoom.setEnemy(combat.getEnemy());
        listRoom.set(currentRoom.getId(),currentRoom);
        player = combat.getPlayer();
    }

    private boolean checkEnemyRoom() {
        return (currentRoom.getEnemy() != null);
    }
}
