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
        terminal.setTerminalSize(140,40);
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        TextGraphics textGraphics = terminal.newTextGraphics();

        // wall generation??
        for (int i = 15; i < 26; i++) {
        	textGraphics.setCharacter(12, i, '#');
        	maze.setTile(15, i, new Wall(15, i));
        }

        // player movement
        Player p = new Player(10,10);
        maze.setTile(p.getX(),p.getY(), p);

        int x = p.getX();
        int y = p.getY();
        boolean running = true;

	while (running){
		terminal.setCursorPosition(x,y);
		terminal.setBackgroundColor(ANSI.YELLOW);
		terminal.setForegroundColor(ANSI.RED);
		terminal.putCharacter(p.getSprite());
		terminal.setBackgroundColor(ANSI.DEFAULT);
		terminal.setForegroundColor(ANSI.DEFAULT);
		KeyStroke key = terminal.readInput();

		if (key.getCharacter().equals('q')) {
			terminal.exitPrivateMode();
			System.exit(0);
		}

		if ((key.getCharacter().equals('a')) && (maze[x - 1][y] == null)) {
                        p.moveX(-1);
                        maze.setTile(x - 1,y,p);
                        maze.setTile(x,y,null);

			terminal.setCursorPosition(x,y);
			terminal.putCharacter(' ');
			x--;
		}

		if ((key.getCharacter().equals('d')) && (maze[x + 1][y] == null)) {
                        p.moveX(1);
                        maze.setTile(x + 1,y,p);
                        maze.setTile(x,y,null);

			terminal.setCursorPosition(x,y);
			terminal.putCharacter(' ');
			x++;
		}

		if ((key.getCharacter().equals('w')) && (maze[x][y - 1] == null)) {
                        p.moveY(-1);
                        maze.setTile(x,y - 1,p);
                        maze.setTile(x,y,null);

                        terminal.setCursorPosition(x,y);
			terminal.putCharacter(' ');
			y--;
		}

		if ((key.getCharacter().equals('s')) && (maze[x][y + 1] == null)) {
                        p.moveY(1);
                        maze.setTile(x,y + 1,p);
                        maze.setTile(x,y,null);

                        terminal.setCursorPosition(x,y);
			terminal.putCharacter(' ');
			y++;
		}
	}
}
}
