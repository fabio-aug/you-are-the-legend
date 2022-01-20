package classes;

import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    public String description;
    private HashMap<String,Room> exits;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String,Room>();
    } 

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExit( String direction, Room neighboor) 
    {
  
        exits.put(direction,neighboor);

    }
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    public String getExitsDescription()
    {
        String exitsDescription = "Exits: ";
    
        Set<String> directions = exits.keySet();
        for(String exit : directions) {
             exitsDescription += " " + exit;
        }
        return exitsDescription;
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getItemDescription(){
        return "This item is beautiful";
    }
    
        public String getDetailedDescription(){
        String detailedDescription;
        detailedDescription ="You are " + description + "\n" + getExitsDescription() + "\n" + getItemDescription();
        return detailedDescription;
    }

}
