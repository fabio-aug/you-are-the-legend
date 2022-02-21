import java.util.HashMap;
import java.util.Set;

public class Room {
    private final int id;
    private Item item;
    private Enemy enemy;
    private String roomName;
    private String description;
    private HashMap<String, Room> exits;

    public Room(int id, String roomName, String description) {
        this.id = id;
        this.roomName = roomName;
        this.description = description;
        exits = new HashMap<>();
    }

    public Room(int id, String roomName, String description, Enemy enemy) {
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

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
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
        detailedDescription = "You are " + roomName + "\n" + description + "\n" + getExitsDescription();
        return detailedDescription;
    }

}