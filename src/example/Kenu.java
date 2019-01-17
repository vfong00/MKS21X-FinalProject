import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;
public class Kenu{


public static void putString(int r, int c,Terminal t, String s) throws IOException{
	t.setCursorPosition(r,c);
	for(int i = 0; i < s.length();i++){
		t.putCharacter(s.charAt(i));
	}
}


public static void main(String[] args) throws IOException{

	Terminal terminal = new UnixTerminal();
	terminal.enterPrivateMode();
	terminal.setCursorVisible(false);

	long tStart = System.currentTimeMillis();
	long lastSecond = 0;
	int x = 10;
	int y = 10;

	boolean running = true;

	while(running){
		terminal.setCursorPosition(x,y);
		terminal.setBackgroundColor(ANSI.YELLOW);
		terminal.setForegroundColor(ANSI.RED);
		terminal.putCharacter('@');
		terminal.setBackgroundColor(ANSI.DEFAULT);
		terminal.setForegroundColor(ANSI.DEFAULT);

		KeyStroke key = terminal.readInput();

		if (key != null){

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

			putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
		}

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis);
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);
			}
	}

}

}
