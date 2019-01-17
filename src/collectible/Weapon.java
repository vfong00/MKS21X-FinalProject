import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Weapon extends Collectible {
        private int x,y,strength;
        private Map map;
        private String type = "collectible";
        public Weapon(int x, int y, int strength, TextCharacter sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.strength = strength;
                this.x = x;
                this.y = y;
                this.map = map;
        }

        public void statusEffect(Player p) {
                p.setDamage(p.getDamage() + strength);
                p.setToPrint("Picked up " + this.getName() + ". Attack increased by " + strength + ".");
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
        }
}
