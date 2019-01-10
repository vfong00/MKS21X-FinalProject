import java.util.Random;
import java.util.ArrayList;

public class Monster extends Entity {


public Monster(int x, int y, int hp, int damage, char sprite, Maze map) {
	super(x,y,hp, damage, sprite, map);
}

public void nextMove() {
	Random rng = new Random();
	int option = rng.nextInt(4);

	if ((option == 0) && (!getMap().getMaze()[getX()][getY() + 1].getType().equals("entity"))) {
		moveTo(getX(),getY() + 1, getMap());
	} else if ((option == 1) && (!getMap().getMaze()[getX()][getY() - 1].getType().equals("entity"))) {
		moveTo(getX(),getY() - 1, getMap());
	} else if ((option == 2) && (!getMap().getMaze()[getX() - 1][getY()].getType().equals("entity"))) {
		moveTo(getX() - 1,getY(), getMap());
	} else if (!getMap().getMaze()[getX() + 1][getY()].getType().equals("entity") ){
		moveTo(getX() + 1,getY(), getMap());
	}

	if (this.getHP() <= 0) {
		this.setDead(true);
		this.die();
	}
}

public String getType(){
	return "monster";
}

}
