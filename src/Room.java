import java.util.HashMap;
import java.util.Set;

public class Room {
    private int id;
    private Item item;
    private Enemy enemy;
    public String description;
    private HashMap<String, Room> exits;

    public Room(int id, String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.id = id;
    }

    public Room(int id, String description, Enemy enemy) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.enemy = enemy;
    }

    public Room(int id, String description, Item item) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.item = item;
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
        String exitsDescription = "Exits: ";

        Set<String> directions = exits.keySet();
        for (String exit : directions) {
            exitsDescription += " " + exit;
        }
        return exitsDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getItemDescription() {
        return description + "\n";
    }

    public String getDetailedDescription() {
        String detailedDescription;
        detailedDescription = "You are " + description + "\n" + getExitsDescription() + "\n" + getItemDescription();
        return detailedDescription;
    }

}