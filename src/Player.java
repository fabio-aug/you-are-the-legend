import java.util.ArrayList;

public class Player extends Mob {
    private ArrayList<Item> items;

    public Player(String name, String description, int force, int life, ArrayList<Item> items) {
        super(name, description, force, life);
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
