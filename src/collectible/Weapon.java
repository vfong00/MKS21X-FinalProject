public class Weapon extends Collectible {
        private int strength;
        public Weapon(int x, int y, int strength, char sprite, String name) {
                super(x,y,sprite,name);
                this.strength = strength;
        }

        public void statusEffect(Player p) {
                p.setDamage(p.getDamage() + strength);
                p.setToPrint("Picked up " + this.getName() + ". Attack increased by " + strength + ".");
        }
}
