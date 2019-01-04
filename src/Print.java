import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;

public class Print{


// CREATE ONE TERMINAL AT THE START OF MAIN
// FEED THAT ONE INSTANCE INTO ALL THAT PRINTS INTO TERMINAL


public static void printString(int x, int y, String input,Color cinp, Terminal term){
	try {
		term.setForegroundColor(cinp.getFore());
		term.setBackgroundColor(cinp.getBack());
		term.setCursorPosition(x,y);
		for (int z = 0; z < input.length(); z++){
			term.putCharacter(input.charAt(z));
		}

	} catch(Exception e){

	}
}

}
