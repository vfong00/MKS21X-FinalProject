import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor.*;

public class HealthItem extends Collectible {
        private int x,y,power;
        private Maze map;
        private String type = "collectible";

        public HealthItem(int x, int y, int power, String name, Maze map) {
                super(x,y,new TextCharacter('\u2295'),name,map);
                this.power = power;
                this.x = x;
                this.y = y;
                this.map = map;
        }

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
