public abstract class Collectible implements Tileable {

private int x, y;
private char sprite;
private String name;

public Collectible(int x, int y, char sprite, String name) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.name = name;
}

public int getX() {
        return x;
}

public int getY() {
        return y;
}

public char getSprite() {
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
