import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Armor extends Collectible {
        private int x,y,power;
        private Maze map;
        private String type = "collectible";

        /**
         * The constructor for the armor collectible.
         *
         * @param x      The x-coordinate that the armor collectible is at.
         * @param y      The x-coordinate that the armor collectible is at.
         * @param power  The amount that this collectible increases defense by.
         * @param sprite The char that represents the armor on the playfield.
         * @param name   The name of the armor collectible.
         * @param map    The map that this armor collectible belongs to.
         */
        public Armor(int x, int y, int power, TextCharacter sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.power = power;
                this.x = x;
                this.y = y;
                this.map = map;
        }

        /**
         * Gives a player a buff in defense.
         *
         * @param p The player to which the effect is being done to.
         */
        public void statusEffect(Player p) {
                p.setDefense(p.getDefense() + power);
                p.setToPrint("Picked up " + this.getName() + ". Defense increased by " + power + ".");
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
                if (p.getDefense() > 100) {
                        p.setDefense(100);
                }
        }
}
