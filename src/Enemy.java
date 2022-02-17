public class Enemy extends Mob {
    private String type;

    public Enemy(String Name, String Description, int Force, int Life, String type) {
        super(Name, Description, Force, Life);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
