public abstract class Entity implements Tileable{
  private int x, y;
  private char sprite;
  private Maze map;
  private int hp;
  private int damage;
  private String type = "entity";
  private String name;
  private boolean dead = false;

  public Entity(int x, int y, int hp, int damage, char sprite, String name, Maze map) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
    map.setTile(x, y, this);
    this.map = map;
    this.hp = hp;
    this.damage = damage;
    this.name = name;
  }

  public String getName() {
          return name;
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
    return type;
  }

  public int getHP(){
	  return this.hp;
  }

  public void setHP(int hp){
	  this.hp = hp;
  }

  public int getDamage(){
	  return this.damage;
  }

  public void setDamage(int dam){
	  this.damage = dam;
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

  public Entity getEntity(){
	  return this;
  }

  public boolean getDead() {
          return dead;
  }

  public Collectible getCollectible() {
          return null;
  }

  public void die(){
          map.setTile(this.x, this.y, new Air(this.x, this.y));
	  this.type = "air";
          this.dead = true;
  }

  public void setDead(boolean amidead){
	  this.dead = amidead;
  }
}
