import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;

public class Nethack {
  public static void main(String[] args) throws IOException {
    Terminal terminal = new UnixTerminal();
  	terminal.enterPrivateMode();
  	terminal.setCursorVisible(false);

    Player p = new Player();

    int x = p.getX();
  	int y = p.getY();
    boolean running = true;

  	while(running) {
  		terminal.setCursorPosition(x,y);
  		terminal.setBackgroundColor(ANSI.YELLOW);
  		terminal.setForegroundColor(ANSI.RED);
  		terminal.putCharacter(p.getSprite());
  		terminal.setBackgroundColor(ANSI.DEFAULT);
  		terminal.setForegroundColor(ANSI.DEFAULT);

  		KeyStroke key = terminal.readInput();

  		if (key != null) {

  			if (key.getCharacter().equals('q')) {
  				terminal.exitPrivateMode();
  				System.exit(0);
  			}

  			if (key.getCharacter().equals('a')) {
  				terminal.setCursorPosition(x,y);
  				terminal.putCharacter(' ');
  				x--;
  			}

  			if (key.getCharacter().equals('d')) {
  				terminal.setCursorPosition(x,y);
  				terminal.putCharacter(' ');
  				x++;
  			}

  			if (key.getCharacter().equals('w')) {
  				terminal.setCursorPosition(x,y);
  				terminal.putCharacter(' ');
  				y--;
  			}

  			if (key.getCharacter().equals('s')) {
  				terminal.setCursorPosition(x,y);
  				terminal.putCharacter(' ');
  				y++;
  			}
      }
    }
  }
}
