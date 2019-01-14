import java.util.Random;

public class Player extends Entity {

private String toPrint;

public Player(int x, int y, String name, Maze map) {
	super(x,y,100, 9, 0, 75, '@', name, map);
}


public void damage(Entity e){
	toPrint = "";
	Random rng = new Random();
	if (rng.nextInt(100) <= this.getAccuracy()) {
		toPrint += "You hit " + e.getName() + " for " + this.getDamage() + " damage. ";
		e.setHP(e.getHP() - (this.getDamage() * (1 - (0.01 * e.getDefense()))));
		if (e.getHP() <= 0){
			e.die();
			toPrint = "Killed " + e.getName();
			return;
		}
	} else {
		toPrint += "You missed " + e.getName() + ". ";
	}
	if (rng.nextInt(100) <= e.getAccuracy()) {
		toPrint += e.getName() + " hit you for " + e.getDamage() + " damage.";
		this.setHP(this.getHP() - (e.getDamage() * (1 - (0.01 * this.getDefense()))));
	} else {
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
		if (d.getType() .equals("entity")){
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
