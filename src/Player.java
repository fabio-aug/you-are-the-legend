import java.util.ArrayList;

public class Player extends Mob {
    private ArrayList<Item> items;

    public Player(String name, int force, int life) {
        super(name, (name + ", the hero of this adventure"), force, life);
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        super.setLife(item.getVitality() + super.getLife());
        super.setForce(item.getDamage() + super.getForce());
        items.add(item);
    }

    private String returnItens() {
        String itemsString = "";
        for (Item item : items) {
            itemsString += "[" + item.getName() + "] ";
        }
        return itemsString;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getName() +
                "\nForce: " + super.getForce() +
                "\nLife: " + super.getLife() +
                "\nItems: " + returnItens();
    }
}
