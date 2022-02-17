public class Enemy extends Mob
 {
     private String type;

    public Enemy (String Name, String Description, int Force, int Life)
    {
        super(Name, Description, Force, Life);
    }
    
    public String getType()
    {
        return type;
    }
}
