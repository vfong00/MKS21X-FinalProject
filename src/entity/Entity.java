public abstract class Entity implements Tileable{
  private int x, y;
  private char sprite;

  public Entity(int x, int y, char sprite, Maze map) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
    map.setTile(x, y, this);
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
}
