public interface Tileable{
	int getX();
	int getY();

	// this is so different Tileables can tell what neighboring Tileables are
	String getType();
	char getSprite();
	void decHP(int amt);
	int getHP();
}
