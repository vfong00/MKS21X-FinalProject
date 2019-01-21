import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Weapon extends Collectible {
        private int x,y,strength;
        private Maze map;
        private String type = "collectible";

        /**
         * The constructor for the weapon collectible.
         *
         * @param x      The x-coordinate that the weapon collectible is at.
         * @param y      The x-coordinate that the weapon collectible is at.
         * @param power  The amount that this collectible increases attack power by.
         * @param sprite The char that represents the weapon on the playfield.
         * @param name   The name of the weapon collectible.
         * @param map    The map that this weapon collectible belongs to.
         */
        public Weapon(int x, int y, int strength, TextCharacter sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.strength = strength;
                this.x = x;
                this.y = y;
                this.map = map;
        }

        /**
         * Gives a player a buff in attacking power.
         *
         * @param p The player to which the effect is being done to.
         */
        public void statusEffect(Player p) {
                p.setDamage(p.getDamage() + strength);
                p.setToPrint("Picked up " + this.getName() + ". Attack increased by " + strength + ".");
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
        }
}
