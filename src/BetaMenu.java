import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;


public class BetaMenu{

public static void main(String[] args) throws IOException {
	Terminal t = new UnixTerminal();
	t.enterPrivateMode();
	t.setCursorVisible(false);
	int menpos = 15;
	Color red = new Color(ANSI.RED, ANSI.DEFAULT);
	Print.printString(20, 15, "start", red, t);
	Print.printString(20, 16, "help", red, t);
	Print.printString(19, menpos, ">", red, t);
	Print.printString(30, 30, "select with space, w and s to select options, q to quit", red, t);
	Print.printString(30, 21, "DO NOT HIT THE ARROW KEYS OR ELSE U DIE", red, t);


	try {
		Thread.sleep(2000);
	} catch (Exception e){

	}
}


}
