public class Armor extends Collectible {
        private int strength;
        public Armor(int x, int y, int strength, char sprite, String name, Maze map) {
                super(x,y,sprite,name,map);
                this.strength = strength;
        }

        public void statusEffect(Player p) {
                p.setDamage(p.getDamage() + strength);
                p.setToPrint("Picked up " + this.getName() + ". Attack increased by " + strength + ".");
        }
}
