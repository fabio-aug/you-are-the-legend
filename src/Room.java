import java.util.HashMap;
import java.util.Set;

public class Room {
    private final int id;
    private Item item;
    private Mob enemy;
    private String roomName;
    private String description;
    private HashMap<String, Room> exits;

    public Room(int id, String roomName, String description) {
        this.id = id;
        this.roomName = roomName;
        this.description = description;
        exits = new HashMap<>();
    }

    public Room(int id, String roomName, String description, Mob enemy) {
        this.id = id;
        this.roomName = roomName;
        this.description = description;
        this.enemy = enemy;
        exits = new HashMap<>();
    }

    public Room(int id, String roomName, String description, Item item) {
        this.id = id;
        this.roomName = roomName;
        this.description = description;
        this.item = item;
        exits = new HashMap<>();
    }

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }

    public Mob getEnemy() {
        return enemy;
    }

    public void setEnemy(Mob enemy) {
        this.enemy = enemy;
    }

    public Item getAndUseItem() {
        Item localItem = item;
        item = null;
        return localItem;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitsDescription() {
        StringBuilder exitsDescription = new StringBuilder("Exits:");

        Set<String> directions = exits.keySet();
        for (String exit : directions) {
            exitsDescription.append(" ").append(exit);
        }
        return exitsDescription.toString();
    }

    public String getDescription() {
        return description;
    }

    public String getDetailedDescription() {
        String detailedDescription;
        detailedDescription = "\nYou are in the " + roomName + "\n" + description + "\n" + getExitsDescription() + "\n";
        return detailedDescription;
    }

}