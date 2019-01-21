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
 * @param x      The x-coordinate that the collectible is at.
 * @param y      The x-coordinate that the collectible is at.
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
 * Accessor method for the x-coordinate field of this collectible.
 *
 * @return The x-coordinate of this collectible, as an integer
 */
public int getX() {
        return x;
}

/**
 * Accessor method for the y-coordinate field of this collectible.
 *
 * @return The y-coordinate of this collectible, as an integer
 */
public int getY() {
        return y;
}

/**
 * Accessor method for the sprite field of this collectible.
 *
 * @return A TextCharacter that is the representation this collectible.
 */
public TextCharacter getSprite() {
	return sprite;
}

/**
 * Accessor method for the type field of this collectible.
 *
 * @return A String that says the type of this collectible.
 */
public String getType() {
	return type;
}

/**
 * Accessor method for the name field of this collectible.
 *
 * @return A String that says the name of this collectible.
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
