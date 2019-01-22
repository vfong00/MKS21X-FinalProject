import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.input.KeyType;
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
	int monpes = 24;

	boolean inMenu = true;
	// putString(0, 0, sc, "" + monpes);

	// ╔╗╔╔═╗╔╦╗╦ ╦╔═╗╔═╗╦╔═  ╦╦
	// ║║║║╣  ║ ╠═╣╠═╣║  ╠╩╗  ║║
	// ╝╚╝╚═╝ ╩ ╩ ╩╩ ╩╚═╝╩ ╩  ╩╩
	// ┌─┐┬  ┌─┐┌─┐┌┬┐┬─┐┬┌─┐  ┌─┐┌─┐┌─┐┌─┐┌─┐┬  ┌─┐┌─┐
	// ├┤ │  ├┤ │   │ ├┬┘││    ├┤ │ ││ ││ ┬├─┤│  │ ││ │
	// └─┘┴─┘└─┘└─┘ ┴ ┴└─┴└─┘  └─┘└─┘└─┘└─┘┴ ┴┴─┘└─┘└─┘


	// putString(21, 5 , sc, "  ______   _______           _______  _______  _______  _       ");
	// putString(21, 6 , sc, "(  ___ \\ (  ___  )|\\     /|(  ____ )(  ___  )(  ___  )( \\");
	putString(21, 7 , sc, " ╔╗╔╔═╗╔╦╗╦ ╦╔═╗╔═╗╦╔═  ╦╦    ");
	putString(21, 8 , sc, " ║║║║╣  ║ ╠═╣╠═╣║  ╠╩╗  ║║                       ");
	putString(21, 9 , sc, " ╝╚╝╚═╝ ╩ ╩ ╩╩ ╩╚═╝╩ ╩  ╩╩                       ");
	putString(21, 10, sc, "┌─┐┬  ┌─┐┌─┐┌┬┐┬─┐┬┌─┐  ┌─┐┌─┐┌─┐┌─┐┌─┐┬  ┌─┐┌─┐");
	putString(21, 11, sc, "├┤ │  ├┤ │   │ ├┬┘││    ├┤ │ ││ ││ ┬├─┤│  │ ││ │");
	putString(21, 12, sc, "└─┘┴─┘└─┘└─┘ ┴ ┴└─┴└─┘  └─┘└─┘└─┘└─┘┴ ┴┴─┘└─┘└─┘");

	putString(25, 24, sc, "start");
	putString(25, 25, sc, "help");
	putString(25, 26, sc, "credits");
	putString(25, 27, sc, "quit");
	putString(24, monpes, sc, ">");
	putString(45, 30, sc, "w and s to scroll");
	putString(45, 31, sc, "space to select");
	sc.refresh(Screen.RefreshType.DELTA);
	while (inMenu){
		sc.clear();
		KeyStroke k = term.readInput();
		while(k.getKeyType() == KeyType.ArrowDown || k.getKeyType() == KeyType.ArrowUp
			|| k.getKeyType() == KeyType.ArrowLeft || k.getKeyType() == KeyType.ArrowRight){
			k = term.readInput();
		}
		char ch = k.getCharacter();
		if (ch == 'w'){
			monpes--;
		}
		if (ch == 's'){
			monpes++;
		}
		// if (ch == 'q'){
		// 	System.exit(1);
		// }
		if (ch == ' '){
			int c = monpes % 4;
			if (c == 0){
				return;
			}
			if (c == 1){
				sc.clear();
				putString(8, 12, sc, "WASD to move around");
				putString(8, 13, sc, "Walk into enemies to damage them");
				putString(8, 14, sc, "Triangles are stairs to the next floor");
				putString(12, 18, sc, "≊≋≌≍≎≏≐≑≏≐≑≑≑≑     λμω*)(Ξ+ΨΩ     ⋒∘∎∿⥿⋮∫∬     abefjkqr");
				putString(12, 19, sc, "armor              monsters       weapons      food (health up)");

				sc.refresh(Screen.RefreshType.DELTA);
				KeyStroke z = term.readInput();

				putString(8, 22, sc, "PRO TIP");
				putString(8, 23, sc, "It's tempting to zoom to the stairs, but the monsters get real strong");
				putString(8, 24, sc, "You should grind weaker monsters and get more XP (which is also your final score)");
				sc.refresh(Screen.RefreshType.DELTA);
				z = term.readInput();
				sc.clear();
			}
			if (c == 2) {
				sc.clear();
				putString(12, 12, sc, "made by moody and vincent");
				putString(12, 13, sc, "we trade marked this too so dont get any funny ideas");
				putString(15, 20, sc, "░░░░░░░░░░░░▄█▀█▀▀▀▀▀▀▀▀▄▄░░░░░░░░ ");
				putString(15, 21, sc, "░░░░░░░░░░▄██▀░█░░░░░░░░░░▀▀▄▄░░░░ ");
				putString(15, 22, sc, "░░░░░░░░░░███▀█▀█▄▄▄▄▄▄▄▒▒▒▄███░░░ ");
				putString(15, 23, sc, "░░░░░░░░▄██░░░░█░░░░░░░░▀▀▀▀▀▀█░░░ ");
				putString(15, 24, sc, "░░░░░░▄███░░░░░░█░░░░░░░░░░░░░░░░░ ");
				putString(15, 25, sc, "░░░░░█████▄░░░░░█░░░░░░░░░░░░░░░░░ ");
				putString(15, 26, sc, "░░░░████████▄▄░█░░░░A░NEW░░░░░░░░░ ");
				putString(15, 27, sc, "░░░████████████░░░░░░TOUCAN░░░░░░░ ");
				putString(15, 28, sc, "░░░▀██████████░░░░░░░░HAS░░░░░░░░░ ");
				putString(15, 29, sc, "░░░░██▒▀█▒▀█▀░░░░░░░░░░ARRIVED░░░░ ");
				putString(15, 30, sc, "░■▓▓▓▓▓▄▓▓▄▓▓▓▓▓▓▓▓■░░░░░░░░░░░░░░ ");
				putString(15, 31, sc, "░░░▄▄███▀░░░░░░░░░░░░░░░░░░░░░░░░░");

				sc.refresh(Screen.RefreshType.DELTA);
				KeyStroke z = term.readInput();
				sc.clear();
			}
			if (c == 3) {
				System.exit(1);
			}
		}
		// putString(0, 0, sc, "" + monpes);
		putString(21, 7 , sc, " ╔╗╔╔═╗╔╦╗╦ ╦╔═╗╔═╗╦╔═  ╦╦    ");
		putString(21, 8 , sc, " ║║║║╣  ║ ╠═╣╠═╣║  ╠╩╗  ║║                       ");
		putString(21, 9 , sc, " ╝╚╝╚═╝ ╩ ╩ ╩╩ ╩╚═╝╩ ╩  ╩╩                       ");
		putString(21, 10, sc, "┌─┐┬  ┌─┐┌─┐┌┬┐┬─┐┬┌─┐  ┌─┐┌─┐┌─┐┌─┐┌─┐┬  ┌─┐┌─┐");
		putString(21, 11, sc, "├┤ │  ├┤ │   │ ├┬┘││    ├┤ │ ││ ││ ┬├─┤│  │ ││ │");
		putString(21, 12, sc, "└─┘┴─┘└─┘└─┘ ┴ ┴└─┴└─┘  └─┘└─┘└─┘└─┘┴ ┴┴─┘└─┘└─┘");
		putString(25, 24, sc, "start");
		putString(25, 25, sc, "help");
		putString(25, 26, sc, "credits");
		putString(25, 27, sc, "quit");

		// putString(45, 30, sc, "w and s to scroll");
		// putString(45, 31, sc, "space to select");
		putString(24, monpes % 4 + 24, sc, ">");
		sc.refresh(Screen.RefreshType.DELTA);
	}
	// try{Thread.sleep(2000);}catch(Exception e){}

}

}
