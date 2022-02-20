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
        this.player = new Player(name, 20, 80);
    }

    private void createRooms() {
        listRoom = new ArrayList<>();

        //Itens
        Item mask = new Item("Mask","With the mask you feel safer",10,20);
        Item vaccineFirstDose = new Item("Vaccine first dose","A super powerful first dose of vaccine",20,30);
        Item vaccineSecondDose = new Item("Vaccine second dose","A super powerful second dose of vaccine",25,35);
        Item alcoholGel = new Item("alcohol gel","What a relief an alcohol gel",15,10);

        //Enemy
        Enemy bolsonarista = new Enemy("Bolsonarista", "O famoso tiozão antivacina.", 15,55, "Digo manjubinha");
        Enemy virus = new Enemy("Omicron", "The omicron is heading your way.", 30,250, "Digo manjubinha");
        Enemy fakenews = new Enemy("FakeNews", "WhatsApp aunt attacked you. Will you believe?", 20,80, "Digo manjubinha");

        Room exit, reception, aWing, pharmacy, corridorOne, bWing, stock, cWing, bathroom, corridorTwo, corridorThree, infirmary, laboratory;

        reception = new Room(0, "reception");
        aWing = new Room(1, "aWing");
        pharmacy = new Room(2, "pharmacy", mask);
        corridorOne = new Room(3, "corridorOne",bolsonarista);
        bWing = new Room(4, "bWing");
        stock = new Room(5, "stock",vaccineFirstDose);
        cWing = new Room(6, "cWing",fakenews);
        bathroom = new Room(7, "bathroom",alcoholGel);
        corridorTwo = new Room(8, "corridorTwo");
        corridorThree = new Room(9, "corridorThree");
        infirmary = new Room(10, "infirmary",vaccineSecondDose);
        laboratory = new Room(11, "laboratory",virus);
        exit = new Room(12, "Exit");

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

        stock.setExit("west", bWing);

        cWing.setExit("north", corridorTwo);
        cWing.setExit("east", bWing);
        cWing.setExit("west", bathroom);

        bathroom.setExit("east", cWing);

        corridorTwo.setExit("north", corridorThree);
        corridorTwo.setExit("south", cWing);

        corridorThree.setExit("north", laboratory);
        corridorThree.setExit("east", infirmary);
        corridorThree.setExit("south", corridorTwo);

        infirmary.setExit("west", corridorThree);

        laboratory.setExit("south", corridorThree);
        laboratory.setExit("west", exit);

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
        Interface.showPlayerAfterCombat(player.toString());
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
