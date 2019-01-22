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

/**
 * Adapted from Mr. K's model, this places a string starting at (r,c) in the terminal.
 *
 * @param  r           The row position that this string begins at.
 * @param  c           The column position that this string begins at.
 * @param  t           The screen to place this string onto.
 * @param  s           The string to place.
 */
public static void putString(int r, int c,TerminalScreen t, String s) throws IOException{
	for(int i = 0; i < s.length();i++){
                t.setCharacter(r,c,new TextCharacter(s.charAt(i)));
                r++;
        }
}


/**
 * Used for listing of a message above the maze,
 * and player stats below the maze.
 *
 * @param  p           The player that this method gets stats from.
 * @param  s           The screen to display these stats on.
 * @param  top         The top message to be displayed.
 */
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
	// initialization of maze and terminal together
	Maze maze = new Maze();
	Generation g = new Generation(5);
        ExtendedTerminal terminal = new UnixTerminal();
        terminal.setCursorVisible(false);
	TerminalScreen s = new TerminalScreen(terminal);
	s.startScreen();
	s.setCursorPosition(null);

	// menu creation
	Mena ma = new Mena(s, terminal);
	s.refresh(Screen.RefreshType.DELTA);
	try{Thread.sleep(1000);}catch(Exception e){}
	s.refresh(Screen.RefreshType.DELTA);

	// beginning of maze generation, walls placed
	Maze.regenMaze(maze,terminal,g);

	// placing of entities and collectibles that do things
        Player p = new Player(10, 10, "bread", maze);
	PlacerFactory fact = new PlacerFactory(maze, p);
	Stairs st = new Stairs(90,10,maze);
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

		// handles crashing from arrow keys
		while(key.getKeyType() == KeyType.ArrowDown || key.getKeyType() == KeyType.ArrowUp
			|| key.getKeyType() == KeyType.ArrowLeft || key.getKeyType() == KeyType.ArrowRight){
			key = terminal.readInput();
		}

		char c = key.getCharacter();
		// quits game
		if (c == 'q'){
			terminal.exitPrivateMode();
			System.exit(0);
		}

		//test code for on the fly generation
		if (c == 'p') {
			Maze.regenMaze(maze, terminal, g);
			p.moveTo(10,10,maze);
			st = new Stairs(90, 10,maze);
			fact = new PlacerFactory(maze, p);
		}

		// if nothing is wrong and the game is operated like it's meant to
		p.moveViaInput(c);
		fact.mover();
		if (p.getAtStairs()) {
			Maze.regenMaze(maze, terminal, g);
			p.moveTo(10,10,maze);
			st = new Stairs(90, 10,maze);
			fact = new PlacerFactory(maze, p);
			p.setAtStairs(false);
		}
		if (p.getFloor() % 5 == 0) {
			// boss.nextMove();
		}
		s.refresh(Screen.RefreshType.DELTA);
		s.clear();
		statusMessageUpdate(p,s,p.getToPrint());
		putString(0,1,s,"X: " + p.getX() + "   Y: " + p.getY());
		// p.levelup();

		// game over screen
		if (p.getHP() <= 0){
			s.clear();
			//_______________________________     __________ _________________
			// 7     77  _  77        77     7     7     77  V  77     77  _  7
			// |   __!|  _  ||  _  _  ||  ___!     |  7  ||  |  ||  ___!|    _|
			// |  !  7|  7  ||  7  7  ||  __|_     |  |  ||  !  ||  __|_|  _ \
			// |     ||  |  ||  |  |  ||     7     |  !  ||     ||     7|  7  |
			// !_____!!__!__!!__!__!__!!_____!     !_____!!_____!!_____!!__!__!
			//
			putString(10, 10, s, " _______________________________     __________ _________________");
			putString(10, 11, s, " 7     77  _  77        77     7     7     77  V  77     77  _  7");
			putString(10, 12, s, " |   __!|  _  ||  _  _  ||  ___!     |  7  ||  |  ||  ___!|    _|");
			putString(10, 13, s, " |  !  7|  7  ||  7  7  ||  __|_     |  |  ||  !  ||  __|_|  _ \\ ");
			putString(10, 14, s, " |     ||  |  ||  |  |  ||     7     |  !  ||     ||     7|  7  |");
			putString(10, 15, s, " !_____!!__!__!!__!__!__!!_____!     !_____!!_____!!_____!!__!__!");

			putString(15, 20, s, "SCORE");
			putString(15, 21, s, "" + p.getXP());
			s.refresh(Screen.RefreshType.DELTA);
			KeyStroke ko = terminal.readInput();
			System.exit(1);
		}
	}
}

public static void main(String[] args) throws IOException {
	run();
}
}
