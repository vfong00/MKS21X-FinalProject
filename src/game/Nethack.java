import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;
import java.util.Random;

public class Nethack {

public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
        ExtendedTerminal terminal = new UnixTerminal();
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        // TextGraphics textGraphics = terminal.newTextGraphics();

        // wall generation??
        for (int i = 15; i < 26; i++) {
        	// textGraphics.setCharacter(12, i, '#');
        	new Wall(12, i, maze);
        }

        // player movement
        Player p = new Player(10, 10, maze);

        boolean running = true;

	while (running){
		// maze.printMaze(terminal);
		terminal.setCursorPosition(0, 0);
		maze.printMaze(terminal);
		try {
			Thread.sleep(2000);
		} catch (Exception e){}

		KeyStroke key = terminal.readInput();
		terminal.exitPrivateMode();
		System.exit(0);
	}
}
}
