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
        Object[][] maze = new Object[40][140];
        maze[10][10] = new Player();
        ExtendedTerminal terminal = new UnixTerminal();
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        TextGraphics textGraphics = terminal.newTextGraphics();

        // wall generation??
        for (int i = 15; i < 26; i++) {
        	textGraphics.setCharacter(12, i, '#');
        }

        // player movement
        Player p = new Player();

        int x = p.getX();
        int y = p.getY();
        boolean running = true;

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

	if ((key.getCharacter().equals('a')) && (textGraphics.getCharacter(x - 1, y) == null)) {
                terminal.setCursorPosition(x,y);
		terminal.putCharacter(' ');
	        x--;
	}

	if ((key.getCharacter().equals('d')) && (textGraphics.getCharacter(x + 1, y) == null)) {
		terminal.setCursorPosition(x,y);
		terminal.putCharacter(' ');
		x++;
	}

	if ((key.getCharacter().equals('w')) && (textGraphics.getCharacter(x, y - 1) == null)) {
		terminal.setCursorPosition(x,y);
		terminal.putCharacter(' ');
		y--;
	}

	if ((key.getCharacter().equals('s')) && (textGraphics.getCharacter(x, y + 1) == null)) {
		terminal.setCursorPosition(x,y);
		terminal.putCharacter(' ');
		y++;
	}
}
}
