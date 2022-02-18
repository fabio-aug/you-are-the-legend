import java.util.HashMap;
import java.util.Set;

public class Room {
    public String description;
    private int id;
    private HashMap<String, Room> exits;
    private Enemy enemy;

    public Room(String description, int id) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.id = id;
    }

    public Room(String description, int id, Enemy enemy) {
        this.description = description;
        exits = new HashMap<String, Room>();
        this.enemy = enemy;
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

    public void setExit(String direction, Room neighboor) {
        exits.put(direction, neighboor);
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
        return "This item is beautiful";
    }

    public String getDetailedDescription() {
        String detailedDescription;
        detailedDescription = "You are " + description + "\n" + getExitsDescription() + "\n" + getItemDescription();
        return detailedDescription;
    }

}
