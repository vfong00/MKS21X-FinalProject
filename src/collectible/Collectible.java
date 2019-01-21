import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public abstract class Collectible implements Tileable {

private int x, y;
private TextCharacter sprite;
private String name;
private String type = "collectible";


/**
 * Constructor for the collectible, the abstract class that represents an item
 * that the player can walk to and collect for an immediate status effect.
 *
 * @param x      The x-coordinate that the collectible is created at.
 * @param y      The x-coordinate that the collectible is created at.
 * @param sprite The char that represents the collectible on the playfield.
 * @param name   The name of the collectible.
 * @param map    The map that this collectible belongs to.
 */
public Collectible(int x, int y, TextCharacter sprite, String name, Maze map) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.name = name;
        map.setTile(x, y, this);
}

/**
 * Accessor method for the x-coordinate field of this object.
 *
 * @return The x-coordinate of this object.
 */
public int getX() {
        return x;
}

/**
 * Accessor method for the y-coordinate field of this object.
 *
 * @return The y-coordinate of this object.
 */
public int getY() {
        return y;
}

/**
 * Accessor method for the sprite field of this object.
 *
 * @return A TextCharacter that is the representation this object.
 */
public TextCharacter getSprite() {
	return sprite;
}

/**
 * Accessor method for the type field of this object.
 *
 * @return A String that says the type of this object.
 */
public String getType() {
	return type;
}

/**
 * Accessor method for the name field of this object.
 *
 * @return A String that says the name of this object.
 */
public String getName() {
        return name;
}

/**
 * To fulfill the Tileable interface, since the maze is of Tileables.
 * Used for the player when determining movement.
 *
 * @return This collectible.
 */
public Collectible getCollectible() {
        return this;
}

/**
 * To fulfill the Tileable interface, since the maze is of Tileables.
 * This is basically useless, but is needed, otherwise the code would break.
 *
 * @return null
 */
public Entity getEntity() {
        return null;
}

/**
 * Abstract method for extensions of this class.
 * When the player collects this item, this effect is done to the player.
 *
 * @param p The player to which the effect is being done to.
 */
public abstract void statusEffect(Player p);
}
