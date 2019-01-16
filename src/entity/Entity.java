import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public abstract class Entity implements Tileable{
  private int x, y, accuracy;
  private double hp, damage, defense;
  private TextCharacter sprite;
  private Maze map;
  private String type = "entity";
  private String name;
  private boolean dead = false;

  public Entity(int x, int y, double hp, double damage, double defense, int accuracy, TextCharacter sprite, String name, Maze map) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
    map.setTile(x, y, this);
    this.map = map;
    this.hp = hp;
    this.defense = defense;
    this.accuracy = accuracy;
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

  public TextCharacter getSprite() {
    return sprite;
  }

  public String getType(){
    return type;
  }

  public double getHP(){
	  return this.hp;
  }

  public void setHP(double hp){
	  this.hp = hp;
  }

  public double getDamage(){
	  return this.damage;
  }

  public void setDamage(double dam){
	  this.damage = dam;
  }

  public double getDefense(){
	  return this.defense;
  }

  public void setDefense(double def){
	  this.defense = def;
  }

  public int getAccuracy(){
	  return this.accuracy;
  }

  public void setAccuracy(int acc){
	  this.accuracy = acc;
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
