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

public static void menuer(Terminal t){
	Color c = new Color(ANSI.RED, ANSI.BLACK);
	Print.printString(0, 0, "derp", c, t);
}

}
