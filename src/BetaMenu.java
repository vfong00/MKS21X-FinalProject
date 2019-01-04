import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import java.io.IOException;


public class BetaMenu{

private Terminal terminal;
private int menpos;

public BetaMenu(){
	try {
		Terminal terminal = new UnixTerminal();
		terminal.enterPrivateMode();
		terminal.setCursorVisible(false);
	}catch (Exception e){

	}
}

public static void putString(int r, int c,Terminal t, String s){
	try {
		t.setCursorPosition(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}

	} catch (Exception e){

	}
}


public void printMenu(){
	BetaMenu.putString(20, 15, terminal, "start");
}

public static void main(String[] args) {
	BetaMenu b = new BetaMenu();
	b.printMenu();
	try {
		Thread.sleep(2000);
	} catch(Exception e){

	}
}


}
