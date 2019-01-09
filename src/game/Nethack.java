import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import java.util.ArrayList;
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

	maze.calcGenerated(g, maze);

        ArrayList<Monster> monsters = new ArrayList<Monster>();
        Player p = new Player(10, 10, maze);
        Monster m = new Monster(20, 20, 10, 'Q', maze);
        monsters.add(m);

        boolean running = true;
	boolean init = false;

	while (running){

		maze.printMaze(s);
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
		}
		p.moveViaInput(c);
                for (Monster monster : monsters) {
                                monster.nextMove();
                }
		s.refresh(Screen.RefreshType.DELTA);
		s.clear();
	}
}
}
