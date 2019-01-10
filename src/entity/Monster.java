import java.util.Random;

public class Monster extends Entity{

private int hp;
private int damage;

public Monster(int x, int y, int hp, int damage, Maze map){
	super(x, y, hp, 5, 'Q', map);
}

public void move(Random r){
	int movx = r.nextInt();
	int movy = r.nextInt();
}

}
