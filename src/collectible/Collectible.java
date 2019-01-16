import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public abstract class Collectible implements Tileable {

private int x, y;
private TextCharacter sprite;
private String name;

public Collectible(int x, int y, TextCharacter sprite, String name, Maze map) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.name = name;
        map.setTile(x, y, this);
}

public int getX() {
        return x;
}

public int getY() {
        return y;
}

public TextCharacter getSprite() {
	return sprite;
}

public String getType() {
	return "collectible";
}

public String getName() {
        return name;
}

public Collectible getCollectible() {
        return this;
}

public Entity getEntity() {
        return null;
}

public abstract void statusEffect(Player p);
}
