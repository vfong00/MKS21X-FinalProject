import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.terminal.ansi.ANSITerminal;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;


public class BetaMenu{

public static void printMenu(int menpos, Terminal t){
	Color red = new Color(ANSI.RED, ANSI.DEFAULT);
	Print.printString(20, 15, "start", red, t);
	Print.printString(20, 16, "help", red, t);
	Print.printString(19, menpos, ">", red, t);
	Print.printString(30, 30, "select with space, w and s to select options, q to quit", red, t);
	Print.printString(30, 21, "DO NOT HIT THE ARROW KEYS OR ELSE U DIE", red, t);
}

public static void main(String[] args) throws IOException {
	int menpos = 15;
	Terminal t = new UnixTerminal();
	t.enterPrivateMode();
	t.setCursorVisible(false);
	boolean running = true;

	while (running){
		t.clearScreen();
		BetaMenu.printMenu(menpos, t);
		KeyStroke key = t.readInput();
		if (key.getCharacter().equals('q')) {
			t.exitPrivateMode();
			System.exit(0);
		}

		if (key.getCharacter().equals('w')) {
			menpos = 15;
		}

		if (key.getCharacter().equals('s')) {
			menpos = 16;
		}

	}


	try {
		Thread.sleep(2000);
	} catch (Exception e){

	}
}


}
