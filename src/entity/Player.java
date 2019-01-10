public class Player extends Entity {


public Player(int x, int y, Maze map) {
	super(x,y,100, 9, '@', map);
}


public void damage(Entity e){
	e.setHP(e.getHP() - this.getDamage());
	if (e.getHP() <= 0){
		e.die();
		return;
	}
	this.setHP(this.getHP() - e.getDamage());
	return;
}

public boolean moveViaInput(char dir){
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

		}
		moveTo(getX(), getY() - 1, getMap());
		return true;
	}

	if(dir == 'a'){
		if ( a.getType().equals("entity") ) {
			damage(ae);
			return false;
		}
		moveTo(getX() - 1, getY(), getMap());
		return true;
	}

	if(dir == 's'){
		if ( s.getType().equals("entity") ) {
			damage(se);
			return false;
		}
		moveTo(getX(), getY() + 1, getMap());
		return true;
	}

	if(dir == 'd'){
		if (d.getType() .equals("entity")){
			damage(de);
			return false;
		}
		moveTo(getX() + 1, getY(), getMap());
		return true;
	}
	return false;
}

}
