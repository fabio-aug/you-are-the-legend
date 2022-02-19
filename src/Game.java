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
        Interface.welcome();
        String name = Interface.namePlayer();
        this.player = new Player(name, 20, 100);
    }

    private void createRooms() {
        listRoom = new ArrayList<>();

        //Itens
        Item teste = new Item("Vaccine","A super powerful vaccine",2,0);

        //Enemy
        Enemy enemyTest = new Enemy("Grogu", "Vai te matar de fofura", 10,30, "Digo manjubinha");


        Room reception, aWing, pharmacy, corridorOne, bWing, stock, cWing, bathroom, corridorTwo, corridorThree, infirmary, laboratory;

        reception = new Room(0, "reception");
        aWing = new Room(1, "aWing", enemyTest);
        pharmacy = new Room(2, "pharmacy", teste);
        corridorOne = new Room(3, "corridorOne");
        bWing = new Room(4, "bWing");
        stock = new Room(5, "stock");
        cWing = new Room(6, "cWing");
        bathroom = new Room(7, "bathroom");
        corridorTwo = new Room(8, "corridorTwo");
        corridorThree = new Room(9, "corridorThree");
        infirmary = new Room(10, "infirmary");
        laboratory = new Room(11, "laboratory");

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
            currentRoom = roomDirection;
            Interface.look(currentRoom.getDetailedDescription());
            if (checkEnemyRoom()) executeCombat();
            if (checkItemRoom()) pickUpItem();
        }
    }

    private boolean checkEnemyRoom() {
        return (currentRoom.getEnemy() != null);
    }

    private void executeCombat() {
        Combat combat = new Combat(player, currentRoom.getEnemy());
        combat = Combat.execute(combat);

        currentRoom.setEnemy(combat.getEnemy());
        listRoom.set(currentRoom.getId(), currentRoom);
        player = combat.getPlayer();
    }

    private boolean checkItemRoom() {
        return (currentRoom.getItem() != null);
    }

    private void pickUpItem() {
        Item item = currentRoom.getAndUseItem();
        player.addItem(item);
        listRoom.set(currentRoom.getId(), currentRoom);
        Interface.findItem(currentRoom.getDescription(), item.getName());
        Interface.showPlayerAfterItem(player.toString());
    }
}
