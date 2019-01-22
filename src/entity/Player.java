import java.util.Random;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;
import java.lang.Math.*;


public class Player extends Entity {

private boolean atStairs = false;
private String toPrint;
private int xp = 0;
private int floor = 1;

public Player(int x, int y, String name, Maze map) {
	super(x,y,100, 9, 0, 75, new TextCharacter('@'), name, map);
}

public int getXP() {
	return xp;
}

public void incXP(int inc) {
	xp += inc;
}

public int getFloor() {
	return floor;
}

public void incFloor() {
	floor++;
}

public boolean getAtStairs() {
	return atStairs;
}

public void setAtStairs(boolean v) {
	atStairs = v;
}

public void levelup(){
	this.setDamage(this.getDamage() + (0.05 * Math.sqrt(Math.sqrt(this.getXP()))));
}


public void damage(Entity e){
	toPrint = "";
	boolean isWall = e.getName().equals("Wall");
	double actDamageDone = this.getDamage() * (1 - (0.0075 * e.getDefense()));
	double actDamageTaken = e.getDamage() * (1 - (0.0075 * this.getDefense()));
	Random rng = new Random();
	if (e.getName().equals("oh?")) {
		toPrint = "You hit a wall. But it feels weird. It's all squishy.";
		e.setHP(e.getHP() - 5);
		if ((e.getHP() <= 0) && (e.getHP() >= -15)) {
			incXP(1);
			e.setSprite(new TextCharacter('O'));
			toPrint = "You found the easter egg!";
		} else if ((e.getHP() < -15) && (e.getHP() >= -50)) {
			toPrint = "Hey now, stop touching the egg. That's weird.";
		} else if (e.getHP() < -50) {
			e.setSprite(new TextCharacter('\u03B8'));
			toPrint = "You broke the egg... we said to stop touching it...";
		}
		return;

	}
	if (rng.nextInt(100) <= this.getAccuracy() && !isWall) {
		toPrint += "You hit " + e.getName() + " for " + actDamageDone + " damage. ";
		e.setHP(e.getHP() - actDamageDone);
		if (e.getHP() <= 0){
			incXP(e.givenXP());

			this.levelup();

			e.die();
			toPrint = "Killed " + e.getName() + ". Got " + e.givenXP() + ".";
			return;
		}
	} else if (!isWall) {
		toPrint += "You missed " + e.getName() + ". ";
	}
	if (rng.nextInt(100) <= e.getAccuracy() && !isWall) {
		toPrint += e.getName() + " hit you for " + actDamageTaken + " damage.";
		this.setHP(this.getHP() - actDamageTaken);
	} else if (!isWall) {
		 toPrint += e.getName() + " missed.";
	}
	return;
}

public String getToPrint() {
	return toPrint;
}

public void setToPrint(String s) {
	toPrint = s;
}

public boolean moveViaInput(char dir){
	toPrint = "";

	Tileable w, a, s, d;
	w = getMap().getMaze()[getX()][getY() - 1];
	a = getMap().getMaze()[getX() - 1][getY()];
	s = getMap().getMaze()[getX()][getY() + 1];
	d = getMap().getMaze()[getX() + 1][getY()];

	Entity we, ae, se, de;
	Collectible wc, ac, sc, dc;
	we = w.getEntity();
	ae = a.getEntity();
	se = s.getEntity();
	de = d.getEntity();
	wc = w.getCollectible();
	ac = a.getCollectible();
	sc = s.getCollectible();
	dc = d.getCollectible();

	if(dir == 'w'){
		//get the locally linked version of map and it's internal maze
		//check for it's neighbor, and act accordingly
		if ( w.getType().equals("entity") ) {
			damage(we);
			return false;
		} else if (w.getType().equals("collectible")) {
			wc.statusEffect(this);
		}
		moveTo(getX(), getY() - 1, getMap());
		return true;
	}

	if(dir == 'a'){
		if ( a.getType().equals("entity") ) {
			damage(ae);
			return false;
		} else if (a.getType().equals("collectible")) {
			ac.statusEffect(this);
		}
		moveTo(getX() - 1, getY(), getMap());
		return true;
	}

	if(dir == 's'){
		if ( s.getType().equals("entity") ) {
			damage(se);
			return false;
		} else if (s.getType().equals("collectible")) {
			sc.statusEffect(this);
		}
		moveTo(getX(), getY() + 1, getMap());
		return true;
	}

	if(dir == 'd'){
		if (d.getType().equals("entity")){
			damage(de);
			return false;
		} else if (d.getType().equals("collectible")) {
			dc.statusEffect(this);
		}
		moveTo(getX() + 1, getY(), getMap());
		return true;
	}
	return false;
}

}
