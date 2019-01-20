import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;

public class Mena{

TerminalScreen sc;
ExtendedTerminal tr;

public static void putString(int x, int y,TerminalScreen t, String s) throws IOException{
	for(int i = 0; i < s.length(); i++){
		t.setCharacter(x, y, new TextCharacter(s.charAt(i), ANSI.DEFAULT, ANSI.DEFAULT));
		x++;
	}
}

public Mena(TerminalScreen t, ExtendedTerminal term) throws IOException{
	this.sc = t;
	this.tr = term;
	int monpes = 25;

	boolean inMenu = true;
	putString(25, 25, sc, "start");
	putString(25, 26, sc, "help");
	sc.refresh(Screen.RefreshType.DELTA);
	while (inMenu){
		sc.clear();
		KeyStroke k = term.readInput();
		char ch = k.getCharacter();
		if (ch == 'w'){
			monpes = 25;
		}
		if (ch == 's'){
			monpes = 26;
		}
		if (ch == 'q'){
			System.exit(1);
		}
		putString(25, 25, sc, "start");
		putString(25, 26, sc, "help");
		putString(24, monpes, sc, ">");
		sc.refresh(Screen.RefreshType.DELTA);
	}
	// try{Thread.sleep(2000);}catch(Exception e){}

}

}
