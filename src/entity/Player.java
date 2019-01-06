public class Player extends Entity {


public Player(int x, int y, Maze map) {
	super(x,y,'@', map);
}

private boolean toMove(char dir){
	if(dir == 'w'){
		if ( getMap().getMaze()[getX()][getY() - 1].getType().equals("entity") ) {
			return false;
		}
		moveTo(getX(), getY() - 1, getMap());
		return true;
	}

	if(dir == 'a'){
		if (getMap().getMaze()[getX() - 1][getY()].getType() .equals("entity")){
			return false;
		}
		moveTo(getX() - 1, getY(), getMap());
		return true;
	}

	if(dir == 's'){
		if (getMap().getMaze()[getX()][getY() + 1].getType() .equals("entity")){
			return false;
		}
		moveTo(getX(), getY() + 1, getMap());
		return true;
	}

	if(dir == 'd'){
		if (getMap().getMaze()[getX() + 1][getY()].getType() .equals("entity")){
			return false;
		}
		moveTo(getX() + 1, getY(), getMap());
		return true;
	}
	return false;
}

}
