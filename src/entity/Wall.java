public class Wall extends Entity {
  public Wall(int x, int y, Maze map) {
    super(x,y, 99999, 0, '#', "Wall", map);
  }
}
