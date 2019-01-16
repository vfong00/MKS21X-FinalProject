import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Air implements Tileable{

private int x, y;
private TextCharacter sprite = new TextCharacter(' ');

public Air(int x, int y){}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public TextCharacter getSprite(){
	return sprite;
}

public String getType(){
	return "air";
}

public Entity getEntity(){
	return null;
}

public Collectible getCollectible() {
	return null;
}

}
