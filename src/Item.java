public class Item {
    private String name;
    private int damage;
    private int vitality;

    public Item(String name, int damage, int vitality) {
        this.name = name;
        this.damage = damage;
        this.vitality = vitality;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getVitality() {
        return vitality;
    }
}