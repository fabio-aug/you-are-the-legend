public class Mob {
    private String name;
    private String description;
    private int force;
    private int life;

    public Mob(String name, String description, int force, int life) {
        this.name = name;
        this.description = description;
        this.force = force;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nForce: " + force +
                "\nLife: " + life;
    }
}