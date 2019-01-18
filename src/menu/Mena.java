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

public static void putString(int x, int y,TerminalScreen t, String s) throws IOException{
	for(int i = 0; i < s.length(); i++){
		t.setCharacter(x, y, new TextCharacter(s.charAt(i), ANSI.DEFAULT, ANSI.DEFAULT));
		x++;
	}
}
public Mena(TerminalScreen t) throws IOException{
	this.sc = t;
	putString(0, 0, sc, "broop");
}

}
