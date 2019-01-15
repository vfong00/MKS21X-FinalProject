import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.util.Random;

public class Nethack {

public static void putString(int r, int c,TerminalScreen t, String s) throws IOException{
	for(int i = 0; i < s.length();i++){
                t.setCharacter(r,c,new TextCharacter(s.charAt(i)));
                r++;
        }
}


public static void menu() throws IOException{
	ExtendedTerminal terminal = new UnixTerminal();
	terminal.setCursorVisible(false);
	TerminalScreen s = new TerminalScreen(terminal);
	s.startScreen();
	s.setCursorPosition(null);
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

<<<<<<< HEAD
	Menu.menuer(s);
	try{Thread.sleep(2000);}catch(Exception e){}


        for (int i = 15; i < 26; i++) {
        	new Wall(12, i, maze);
        }

=======
>>>>>>> momsterv3
	// g.generate();
	// char[][] gen = g.getGenerated();
	// for(int x = 0; x < 100; x++){
	// 	for(int y = 0; y < 30; y++){
	// 		if (gen[x][y] == '0'){
	// 			new Wall(x, y, maze);
	// 		}
	// 	}
	// }
	maze.calcGenerated(g, maze);

	// game crashes if border is overreached,
	// this draws in border walls
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			if (x == 0 || x == 99){
				new Wall(x, y, maze);
			}
			if (y == 0 || y == 29){
				new Wall(x, y, maze);
			}
		}
	}

        Player p = new Player(10, 10, "bread", maze);
	Monster m = new Monster(11, 11, 15, 5, 1, 75, 'Q', "Skeletor", maze);
        Weapon w = new Weapon(12,12,4,'/',"Excalibur", maze);
	Armor d = new Armor(13,13,4,'D',"Golden Shield", maze);

        boolean running = true;
	boolean init = false;
	String bottomBar1 = "Player Name: " + p.getName() + "          HP: " + p.getHP();
	String bottomBar2 = "ATK: " + p.getDamage() + "          DEF: " + p.getDefense() + "          SKILL: " + p.getAccuracy();

        putString(0,0,s,"Begin game");
	putString(0,35,s,bottomBar1);
	putString(0,36,s,bottomBar2);

	while (running){

		maze.printMaze(s);
		// s.clear();
		if (!init){
			s.refresh(Screen.RefreshType.AUTOMATIC);
		}

		// ask for the keyStroke once, then feed into all the "feeder" functions
		KeyStroke key = terminal.readInput();
		char c = key.getCharacter();
		if (c == 'q'){
			terminal.exitPrivateMode();
			System.exit(0);
		}

		//test code for on the fly generation
		if (c == 'p'){
			terminal.clearScreen();
			maze.calcGenerated(g, maze);
                        for (int x = 0; x < 100; x++){
                		for (int y = 0; y < 30; y++){
                			if (x == 0 || x == 99){
                				new Wall(x, y, maze);
                			}
                			if (y == 0 || y == 29){
                				new Wall(x, y, maze);
                			}
                		}
                	}
		}
		p.moveViaInput(c);
                m.nextMove();
		s.refresh(Screen.RefreshType.DELTA);
		s.clear();
                putString(0,0,s,p.getToPrint());
		bottomBar1 = "Player Name: " + p.getName() + "          HP: " + p.getHP();
		bottomBar2 = "ATK: " + p.getDamage() + "          DEF: " + p.getDefense() + "          SKILL: " + p.getAccuracy();
		putString(0,35,s,bottomBar1);
		putString(0,36,s,bottomBar2);
	}
}

public static void main(String[] args) throws IOException {
	Nethack.menu();
	try{
		Thread.sleep(2000);
	} catch (Exception e){}
	Nethack.run();
}
}
