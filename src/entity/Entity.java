public abstract class Entity implements Tileable{
  private int x, y, hp;
  private char sprite;
  private Maze map;

  public Entity(int x, int y, int hp, char sprite, Maze map) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
    map.setTile(x, y, this);
    this.map = map;
    this.hp = hp;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getSprite() {
    return sprite;
  }

  public String getType(){
    return "entity";
  }

  public void moveTo(int x, int y, Maze map){
	map.setTile(this.x, this.y, new Air(this.x, this.y));
	this.x = x;
	this.y = y;
	map.setTile(this.x, this.y, this);
  }

  public Maze getMap(){
	return this.map;
  }

  public void decHP(int amt) {
          hp -= amt;
  }

  public int getHP() {
          return hp;
  }

  public void die() {
         map.setTile(this.x, this.y, new Air(this.x, this.y));
  }
}
