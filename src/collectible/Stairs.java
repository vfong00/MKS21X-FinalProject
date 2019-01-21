import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.SGR;

public class Stairs extends Collectible {
        private int x,y;
        private Maze map;
        private String type = "collectible";

        /**
         * The constructor for the stairs collectible.
         *
         * @param x      The x-coordinate that the stairs is at.
         * @param y      The x-coordinate that the stairs is at.
         * @param map    The map that these stairs belongs to.
         */
        public Stairs(int x, int y, Maze map) {
                super(x,y,new TextCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK,ANSI.DEFAULT,ANSI.DEFAULT),"Stairs",map);
                this.x = x;
                this.y = y;
                this.map = map;
        }

        /**
         * Tells player, which tells main game + terminal, to update the maze
         * to a new level.
         *
         * @param p The player to which the effect is being done to.
         */
        public void statusEffect(Player p) {
                p.incFloor();
                p.setAtStairs(true);
                p.setToPrint("Went up stairs. Now at level " + p.getFloor());
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
        }
}
