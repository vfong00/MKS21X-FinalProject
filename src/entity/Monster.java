import java.util.Random;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Monster extends Entity{

private int hp;
private int damage;
private int givenXP;

public Monster(int x, int y, int givenXP, double hp, double damage, double defense, int accuracy, TextCharacter sprite, String name, Maze map){
	super(x, y, hp, damage, defense, accuracy, sprite, name, map);
	this.givenXP = givenXP;
}

public void nextMove() {
	Random rng = new Random();
	int option = rng.nextInt(4);

	if (!this.getDead()) {
		if ((option == 0) && (!getMap().getMaze()[getX()][getY() + 1].getType().equals("entity")) && (!getMap().getMaze()[getX()][getY() + 1].getType().equals("collectible"))) {
			moveTo(getX(),getY() + 1, getMap());
		} else if ((option == 1) && (!getMap().getMaze()[getX()][getY() - 1].getType().equals("entity")) && (!getMap().getMaze()[getX()][getY() - 1].getType().equals("collectible"))) {
			moveTo(getX(),getY() - 1, getMap());
		} else if ((option == 2) && (!getMap().getMaze()[getX() - 1][getY()].getType().equals("entity")) && (!getMap().getMaze()[getX() - 1][getY()].getType().equals("collectible"))) {
			moveTo(getX() - 1,getY(), getMap());
		} else if ((!getMap().getMaze()[getX() + 1][getY()].getType().equals("entity")) && (!getMap().getMaze()[getX() + 1][getY()].getType().equals("collectible"))) {
			moveTo(getX() + 1,getY(), getMap());
		}

		if (this.getHP() <= 0) {
			this.die();
		}
	}
}

public int givenXP(){
	return givenXP;
}

}
