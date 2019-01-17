import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.SGR;

public class Stairs extends Collectible {
        private int x,y;
        private Maze map;
        private String type = "collectible";

        public Stairs(int x, int y, Maze map) {
                super(x,y,new TextCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK,ANSI.DEFAULT,ANSI.DEFAULT),"Stairs",map);
                this.x = x;
                this.y = y;
                this.map = map;
        }

        public void statusEffect(Player p) {
                p.setAtStairs(true);
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
        }
}
