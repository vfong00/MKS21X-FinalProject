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

public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
	Generation g = new Generation(5);
        ExtendedTerminal terminal = new UnixTerminal();
        // terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
	TerminalScreen s = new TerminalScreen(terminal);
	s.startScreen();
	s.setCursorPosition(null);


        for (int i = 15; i < 26; i++) {
        	new Wall(12, i, maze);
        }

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

        Player p = new Player(10, 10, maze);

        boolean running = true;
	boolean init = false;

	while (running){

		maze.printMaze(s);
		// s.clear();
		if (!init){
			s.refresh(Screen.RefreshType.AUTOMATIC);
		}

		// ask for the keyStroke once, then feed into all the "feeder" functions
		try{Thread.sleep(50);}catch(Exception e){}
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
		}
		p.moveViaInput(c);
		s.refresh(Screen.RefreshType.DELTA);
		s.clear();
	}
}
}
