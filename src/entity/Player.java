public class Player extends Entity {


public Player(int x, int y, Maze map) {
	super(x,y,'@', map);
}

public boolean moveViaInput(char dir){
	if(dir == 'w'){
		//get the locally linked version of map and it's internal maze
		//check for it's neighbor, and act accordingly
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
