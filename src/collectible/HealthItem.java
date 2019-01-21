import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class HealthItem extends Collectible {
        private int x,y,power;
        private Maze map;
        private String type = "collectible";

        /**
         * The constructor for the armor collectible.
         *
         * @param x      The x-coordinate that the health collectible is at.
         * @param y      The x-coordinate that the health collectible is at.
         * @param power  The amount that this collectible increases health by.
         * @param sprite The char that represents the health on the playfield.
         * @param name   The name of the health collectible.
         * @param map    The map that this health collectible belongs to.
         */
        public HealthItem(int x, int y, int power, String name, TextCharacter sprite, Maze map) {
                super(x,y,sprite,name,map);
                this.power = power;
                this.x = x;
                this.y = y;
                this.map = map;
        }

        /**
         * Increases HP by the intrisic "power" amount. HP is capped at 100.
         *
         * @param p The player to which the effect is being done to.
         */
        public void statusEffect(Player p) {
                p.setHP(p.getHP() + power);
                p.setToPrint("Picked up " + this.getName() + ". Health increased by " + power + ".");
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
                if (p.getHP() > 100) {
                        p.setHP(100);
                }
        }
}
