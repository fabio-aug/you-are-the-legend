package classes;

public class Item {
    private String name;
    private String description;
    private int damage;
    private int vitality;

    public Item(String name, String description, int damage, int vitality) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.vitality = vitality;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }

    public int getVitality() {
        return vitality;
    }
}