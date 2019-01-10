public abstract class Collectible implements Tileable {

private int x, y;
private char sprite;

public Collectible(int x, int y, char sprite, String name) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
}

public int getX(){
        return x;
}

public int getY(){
        return y;
}

public char getSprite(){
	return sprite;
}

public String getType(){
	return "collectible";
}

}
