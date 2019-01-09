import java.util.Random;
import java.util.ArrayList;

public class Monster extends Entity {


public Monster(int x, int y, int hp, char sprite, Maze map) {
	super(x,y,hp,sprite, map);
}

public void nextMove(ArrayList<Monster> t) {
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

	for (Monster monster : t) {
		if (monster.getHP() <= 0) {
			monster.die();
		}
	}
}

public String getType(){
	return "monster";
}

}
