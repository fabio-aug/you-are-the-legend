import java.util.ArrayList;

public class Game {

    private Parser parser;
    private ArrayList<Room> listRoom;
    private Room currentRoom;
    private Player player;

    public Game() {
        createPlayer();
        ArrayList<Item> listItem = createItems();
        ArrayList<Mob> listEnemy = createMob();
        createRooms(listItem, listEnemy);
    }

    private void createPlayer() {
        Interface.welcome();
        String name = Interface.namePlayer();
        this.player = new Player(name, 25, 100);
    }

    private ArrayList<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Mask \uD83D\uDE37", 10, 20));
        items.add(new Item("Vaccine first dose \uD83D\uDC89",  20, 30));
        items.add(new Item("Vaccine second dose \uD83D\uDC89\uD83D\uDC89",  25, 35));
        items.add(new Item("Alcohol gel", 15, 10));

        return items;
    }

    private ArrayList<Mob> createMob() {
        ArrayList<Mob> items = new ArrayList<>();

        items.add(new Mob("Bolsonarista 1️⃣7️⃣", "The famous anti-vaccine uncle.", 15, 55));
        items.add(new Mob("Omicron \uD83E\uDDA0", "The omicron is heading your way.", 30, 250));
        items.add(new Mob("FakeNews \uD83D\uDCE8", "WhatsApp aunt attacked you. Will you believe?", 20, 80));

        return items;
    }

    private void createRooms(ArrayList<Item> items, ArrayList<Mob> enemys) {
        listRoom = new ArrayList<>();

        Room exit, reception, aWing, pharmacy, corridorOne, bWing, stock, cWing, bathroom, corridorTwo, corridorThree, infirmary, laboratory;

        reception = new Room(0, "Reception", "This is the reception area of the hospital. It is the first room in the building.");
        aWing = new Room(1, "AWing", "This is the hospital's A-wing.");
        pharmacy = new Room(2, "Pharmacy", "This is the pharmacy of the hospital. Here are all the medicines.", items.get(0));
        corridorOne = new Room(3, "CorridorOne", "This is corridor one of the hospital.", enemys.get(0));
        bWing = new Room(4, "BWing", "Ward that was intended for patients with internal fractures.");
        stock = new Room(5, "Stock", "Room where medical supplies were stored.", items.get(1));
        cWing = new Room(6, "CWing", "Ward that was intended for patients with contagious diseases.", enemys.get(1));
        bathroom = new Room(7, "Bathroom", "Hospital main abandoned toilet.", items.get(2));
        corridorTwo = new Room(8, "CorridorTwo", "This is corridor 2 of the hospital, a long, narrow place, a little dark, but nothing unusual.");
        corridorThree = new Room(9, "CorridorThree", "This is corridor 3, the last corridor of the hospital, you feel something when you enter it, but nothing happens.");
        infirmary = new Room(10, "Infirmary", "This is the hospital ward. Here are all the strongest medications in the hospital.", items.get(3));
        laboratory = new Room(11, "Laboratory", "Abandoned laboratory where doctors performed tests.", enemys.get(2));
        exit = new Room(12, "Exit", "");

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
    }

    private boolean selectedCommand(int option) {
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
        combat = combat.execute();

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

    public static void main(String[] args) {
        Game gamePlay = new Game();
        gamePlay.play();
    }
}
