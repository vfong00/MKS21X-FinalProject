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

public class Menu{

public static void putString(int r, int c,TerminalScreen t, String s) throws IOException{
	t.setCursorPosition(new TerminalPosition(c,r));
	for(int i = 0; i < s.length();i++){
                t.setCharacter(r,c,new TextCharacter(s.charAt(i)));
                r++;
        }
        t.setCursorPosition(null);
}

public static void menuer(TerminalScreen t) throws IOException{
	Color c = new Color(ANSI.RED, ANSI.BLACK);
	// Print.printString(0, 0, "derp", c, t);
	putString(0,0,t,"derp");
}

}
