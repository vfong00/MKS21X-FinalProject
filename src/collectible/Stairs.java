import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.SGR;

public class Stairs extends Collectible {
        public Stairs(int x, int y, String name, Maze map) {
                super(x,y,new TextCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK,ANSI.DEFAULT,ANSI.DEFAULT),name,map);
        }

        public void statusEffect(Player p) {
                
        }
}
