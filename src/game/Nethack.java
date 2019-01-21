import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;
import java.util.Random;

public class Nethack {

public static void putString(int r, int c,TerminalScreen t, String s) throws IOException{
	for(int i = 0; i < s.length();i++){
                t.setCharacter(r,c,new TextCharacter(s.charAt(i)));
                r++;
        }
}



public static void statusMessageUpdate(Player p, TerminalScreen s, String top) throws IOException {
	String bottomBar1 = "Player Name: " + p.getName() + "          HP: " + p.getHP();
	String bottomBar2 = "ATK: " + p.getDamage() + "          DEF: " + p.getDefense() + "          SKILL: " + p.getAccuracy();
	String bottomBar3 = "XP: " + p.getXP() + "          Floor: " + p.getFloor();

        putString(0,0,s,top);
	putString(0,35,s,bottomBar1);
	putString(0,36,s,bottomBar2);
	putString(0,37,s,bottomBar3);
}



public static void run() throws IOException{
	Maze maze = new Maze();
	Generation g = new Generation(5);
        ExtendedTerminal terminal = new UnixTerminal();
        // terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
	TerminalScreen s = new TerminalScreen(terminal);
	s.startScreen();
	s.setCursorPosition(null);

	Mena ma = new Mena(s, terminal);
	s.refresh(Screen.RefreshType.DELTA);
	try{Thread.sleep(1000);}catch(Exception e){}
	s.refresh(Screen.RefreshType.DELTA);

	Maze.regenMaze(maze,terminal,g);

        Player p = new Player(10, 10, "bread", maze);
	// Monster m0 = new Monster(11, 11, 10, 10, 5, 1, 75, new TextCharacter('\u0D95'), "Ghost", maze);
	// Monster m1 = new Monster(11, 14, 10, 10, 5, 1, 75, new TextCharacter('\u0D95'), "Ghost", maze);
	// Monster m2 = new Monster(11, 8, 10, 10, 5, 1, 75, new TextCharacter('\u0D95'), "Ghost", maze);
	// Monster boss = new Monster(15,10,(2 * (15 + (p.getFloor() * 2))),(2 * (15 + (p.getFloor() * 2))), 30 + (p.getFloor() * 2), 40 + (p.getFloor() * 4), 85 + p.getFloor(), new TextCharacter('\u2F24'), "Boss", maze);
	// boss.die();`
	PlacerFactory fact = new PlacerFactory(maze, p);
	int monsCycleCount = 0;
        Weapon w = new Weapon(12,12,4,new TextCharacter('\u262d',ANSI.RED,ANSI.RED),"Soviet Sickle", maze);
	Armor d = new Armor(13,13,4,new TextCharacter(Symbols.OUTLINED_SQUARE,ANSI.YELLOW,ANSI.YELLOW),"Golden Shield", maze);
	HealthItem h = new HealthItem(15,15,10,"Mom's Spaghetti", maze);
	Stairs st = new Stairs(16,16,maze);
	boolean temp = false;
        boolean running = true;
	boolean init = false;
	statusMessageUpdate(p,s,"Begin game");
	putString(0,1,s,"X: " + p.getX() + "   Y: " + p.getY());

	TextCharacter[] monsChars = {new TextCharacter('\u0D95'), new TextCharacter('\u03B6'), new TextCharacter('\u2124'), new TextCharacter('\uA025'), new TextCharacter('G')};
	String[] monsNames = {"Ghost", "Snake Person", "Zombie", "Spider", "Goblin"};

	while (running){

		maze.printMaze(s);
		// s.clear();
		if (!init){
			s.refresh(Screen.RefreshType.AUTOMATIC);
		}

		// ask for the keyStroke once, then feed into all the "feeder" functions
		KeyStroke key = terminal.readInput();
		while(key.getKeyType() == KeyType.ArrowDown || key.getKeyType() == KeyType.ArrowUp
			|| key.getKeyType() == KeyType.ArrowLeft || key.getKeyType() == KeyType.ArrowRight){
			key = terminal.readInput();
		}
		char c = key.getCharacter();
		if (c == 'q'){
			terminal.exitPrivateMode();
			System.exit(0);
		}

		//test code for on the fly generation
		if (c == 'p') {
			Maze.regenMaze(maze, terminal, g);
			p.moveTo(10,10,maze);
			st = new Stairs(16,16,maze);
			// m0 = new Monster(11, 8, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (2 * monsCycleCount), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
			// m1 = new Monster(11, 11, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (monsCycleCount * 2), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
			// m2 = new Monster(11, 14, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (monsCycleCount * 2), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
			fact = new PlacerFactory(maze, p);
			w = new Weapon(12,12,4,new TextCharacter('\u262d',ANSI.RED,ANSI.RED),"Excalibur", maze);
			d = new Armor(13,13,4,new TextCharacter(Symbols.OUTLINED_SQUARE,ANSI.YELLOW,ANSI.YELLOW),"Golden Shield", maze);
			h = new HealthItem(15,15,10,"Mom's Spaghetti", maze);
		}
		p.moveViaInput(c);
                // m0.nextMove();
		// m1.nextMove();
		// m2.nextMove();
		fact.mover();
		if (p.getAtStairs()) {
			Maze.regenMaze(maze, terminal, g);
			p.moveTo(10,10,maze);
			if (p.getFloor() % 5 == 0) {
				monsCycleCount++;
				// boss = new Monster(15,10,(2 * (15 + (p.getFloor() * 2))),(2 * (15 + (p.getFloor() * 2))), 30 + (p.getFloor() * 2), 40 + (p.getFloor() * 4), 85 + p.getFloor(), new TextCharacter('\u2F24'), "Boss", maze);
			}
			st = new Stairs(16,16,maze);
			// m0 = new Monster(11, 8, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (2 * monsCycleCount), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
			// m1 = new Monster(11, 11, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (monsCycleCount * 2), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
			// m2 = new Monster(11, 14, (2 * (15 + (p.getFloor() * 2))) / 3, 15 + p.getFloor(), 5 + p.getFloor(), 1 + monsCycleCount, 75 + (monsCycleCount * 2), monsChars[(monsCycleCount % 5)], monsNames[(monsCycleCount % 5)], maze);
		        w = new Weapon(12,12,4,new TextCharacter('\u262d',ANSI.RED,ANSI.RED),"Excalibur", maze);
			d = new Armor(13,13,4,new TextCharacter(Symbols.OUTLINED_SQUARE,ANSI.YELLOW,ANSI.YELLOW),"Golden Shield", maze);
			h = new HealthItem(15,15,10,"Mom's Spaghetti", maze);
			p.setAtStairs(false);
		}
		if (p.getFloor() % 5 == 0) {
			// boss.nextMove();
		}
		s.refresh(Screen.RefreshType.DELTA);
		s.clear();
		statusMessageUpdate(p,s,p.getToPrint());
		putString(0,1,s,"X: " + p.getX() + "   Y: " + p.getY());
	}
}

public static void main(String[] args) throws IOException {
	run();
}
}
