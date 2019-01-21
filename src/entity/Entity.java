import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public abstract class Entity implements Tileable{
  private int x, y, accuracy, givenXP;
  private double hp, damage, defense;
  private TextCharacter sprite;
  private Maze map;
  private String type = "entity";
  private String name;
  private boolean dead = false;

  /**
   * Constructor for the abstract entity object: an entity is able to move around
   * and interact with its environment.
   *
   * @param x        The x-coordinate of this entity.
   * @param y        The y-coordinate of this entity.
   * @param hp       The health that this entity has.
   * @param damage   The damage that this entity deals.
   * @param defense  The percentage of damage that this entity recieves from enemies.
   * @param accuracy The percent chance that this entity lands a hit.
   * @param sprite   The char that represents the entity on the playfield.
   * @param name     The name of this entity.
   * @param map      The map that this entity belongs to.
   */
  public Entity(int x, int y, double hp, double damage, double defense, int accuracy, TextCharacter sprite, String name, Maze map) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
    map.setTile(x, y, this);
    this.map = map;
    this.hp = hp;
    if (hp > 100) {
            hp = 100;
    }
    this.defense = defense;
    if (defense > 100) {
            defense = 100;
    }
    this.accuracy = accuracy;
    this.damage = damage;
    this.name = name;
  }

  /**
   * Accessor method for the name field of this entity.
   *
   * @return A String that says the name of this entity.
   */
  public String getName() {
          return name;
  }

  /**
   * Mutator method for the name field of this entity.
   *
   * @param name The String that this entity's name will be set to.
   */
  public void setName(String name) {
          this.name = name;
  }

  /**
   * Accessor method for the x-coordinate field of this entity.
   *
   * @return The x-coordinate of this entity, as an integer.
   */
  public int getX() {
    return x;
  }

  /**
   * Accessor method for the y-coordinate field of this entity.
   *
   * @return The y-coordinate of this entity, as an integer.
   */
  public int getY() {
    return y;
  }

  /**
   * Accessor method for the sprite field of this entity.
   *
   * @return A TextCharacter that is the representation this entity.
   */
  public TextCharacter getSprite() {
    return sprite;
  }

  /**
   * Mutator method for the sprite field of this entity.
   *
   * @return A TextCharacter that is the representation this entity.
   */
  public void setSprite(TextCharacter t) {
    sprite = t;
  }

  /**
   * Accessor method for the type field of this entity.
   *
   * @return A String that says the type of this entity.
   */
  public String getType(){
    return type;
  }

  /**
   * Accessor method for the HP field of this entity.
   *
   * @return A double for how much HP this entity has.
   */
  public double getHP(){
	  return this.hp;
  }

  /**
   * Mutator method for the HP field of this entity.
   *
   * @param hp The amount of HP that this entity will now have.
   */
  public void setHP(double hp){
	  this.hp = hp;
  }

  /**
   * Accessor method for the damage field of this entity.
   * (against objects of 0 defense, it is equal to the
   * HP taken from that object)
   *
   * @return A double for how much damage this entity deals per hit.
   */
  public double getDamage(){
	  return this.damage;
  }

  /**
   * Mutator method for the damage field of this entity.
   *
   * @param dam The new amount of damage the entity deals per hit
   */
  public void setDamage(double dam){
	  this.damage = dam;
  }

  /**
   * Accessor method for the defense field of this entity.
   * (Decreases damage taken by defense%)
   * (This maxes out at 100, because it would be dumb to have the entity take no damage)
   *
   * @return A double for how much defense this entity has.
   */
  public double getDefense(){
	  return this.defense;
  }

  /**
   * Mutator method for the defense field of this entity.
   *
   * @param def The new amount of defense the entity deals per hit
   */
  public void setDefense(double def){
	  this.defense = def;
  }

  /**
   * Accessor method for the accuracy field of this entity.
   * (This is compared to a random generation of a number from 1 to 100, and
   * if the number is less than or equal to this accuracy value, the hit lands)
   *
   * @return The hit accuracy of this entity.
   */
  public int getAccuracy(){
	  return this.accuracy;
  }

  /**
   * Mutator method for the accuracy field of this entity.
   *
   * @param acc The new accuracy of this entity.
   */
  public void setAccuracy(int acc){
	  this.accuracy = acc;
  }

  /**
   * Accessor method for the given XP of an entity.
   * This is basically here for monsters only, since the only way players
   * can get to monsters is as an entity.
   *
   * @return The given XP upon death of this entity.
   */
  public int givenXP(){
  	return givenXP;
  }

  /**
   * Accessor method for the map to which this entity belongs to.
   *
   * @return The map to which this entity belongs to.
   */
  public Maze getMap(){
	return this.map;
  }

  /**
   * Returns the death status of this entity.
   *
   * @return A boolean on whether this entity is dead or not.
   */
  public boolean getDead() {
          return dead;
  }

  /**
   * To fulfill the Tileable interface, since the maze is of Tileables.
   * Used for the player when determining movement.
   *
   * @return This collectible.
   */
  public Entity getEntity(){
	  return this;
  }

  /**
   * To fulfill the Tileable interface, since the maze is of Tileables.
   * This is basically useless, but is needed, otherwise the code would break.
   *
   * @return null
   */

  public Collectible getCollectible() {
          return null;
  }

  /**
   * Moves this entity from one position on the terminal to another.
   * Employs setTile: basically make the current position nothing (air),
   * and make the new position have an entity.
   *
   * @param x   The new x-coordinate to which this entity is moved.
   * @param y   The new y-coordinate to which this entity is moved.
   * @param map The map to which this entity belongs to.
   */
  public void moveTo(int x, int y, Maze map){
	map.setTile(this.x, this.y, new Air(this.x, this.y));
	this.x = x;
	this.y = y;
	map.setTile(this.x, this.y, this);
  }

  /**
   * Makes the entity die, by setting itself to an air tile.
   */
  public void die(){
          map.setTile(this.x, this.y, new Air(this.x, this.y));
	  this.type = "air";
          this.dead = true;
  }
}
