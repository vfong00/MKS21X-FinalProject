import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.SGR;

public class Wall extends Entity {
  public Wall(int x, int y, Maze map) {
    super(x,y, 99999, 0, 0, 0, new TextCharacter(Symbols.BLOCK_DENSE, ANSI.DEFAULT, ANSI.DEFAULT), "Wall", map);
  }

  public void easterEgg() {
          this.setHP(25);
          this.setName("oh?");
  }
}
