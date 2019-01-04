public abstract class Entity {
  private int x, y;
  private char sprite;

  public Entity(int x, int y, char sprite) {
    this.x = x;
    this.y = y;
    this.sprite = sprite;
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
}
