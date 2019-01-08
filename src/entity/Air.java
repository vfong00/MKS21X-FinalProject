public class Air implements Tileable{

private int x, y;
private char sprite = ' ';

public Air(int x, int y){}

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
	return "air";
}

public void decHP(int amt) {
	
}

}
