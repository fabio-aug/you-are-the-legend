import java.util.ArrayList;

public class Player extends Mob {
    private final ArrayList<Item> items;

    public Player(String name, int force, int life) {
        super(name, (name + ", the hero of this adventure"), force, life);
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        super.setLife(item.getVitality() + super.getLife());
        super.setForce(item.getDamage() + super.getForce());
        items.add(item);
    }

    private String returnItems() {
        StringBuilder itemsString = new StringBuilder();
        for (Item item : items) {
            itemsString.append("[").append(item.getName()).append("] ");
        }
        return itemsString.toString();
    }

    @Override
    public String toString() {
        return "Nome: " + super.getName() +
                "\nForce: " + super.getForce() +
                "\nLife: " + super.getLife() +
                "\nItems: " + returnItems();
    }
}
