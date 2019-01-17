import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class Armor extends Collectible {
        private int x,y,power;
        private Maze map;
        private String type = "collectible";

        public Armor(int x, int y, int power, TextCharacter sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.power = power;
                this.x = x;
                this.y = y;
                this.map = map;
        }

        public void statusEffect(Player p) {
                p.setDefense(p.getDefense() + power);
                p.setToPrint("Picked up " + this.getName() + ". Defense increased by " + power + ".");
                map.setTile(x,y,new Air(x,y));
                this.type = "air";
        }
}
