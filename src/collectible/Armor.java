public class Armor extends Collectible {
        private int power;
        public Armor(int x, int y, int power, char sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.power = power;
        }

        public void statusEffect(Player p) {
                p.setDefense(p.getDamage() + power);
                p.setToPrint("Picked up " + this.getName() + ". Defense increased by " + power + ".");
        }
}
