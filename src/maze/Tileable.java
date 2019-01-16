import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public interface Tileable{
	int getX();
	int getY();

	// this is so different Tileables can tell what neighboring Tileables are
	String getType();
	TextCharacter getSprite();
	Entity getEntity();
	Collectible getCollectible();
}
