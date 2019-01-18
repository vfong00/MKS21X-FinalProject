import jcurses.system.*;

public class Menu{


CharColor red = new CharColor(CharColor.BLACK, CharColor.RED);
CharColor blue = new CharColor(CharColor.BLACK, CharColor.BLUE);

public Menu(){
}

public char read(){
        InputChar c = Toolkit.readCharacter();
        return c.getCharacter();
}

// *
//  * returns a random number via random.org
//  * @return integer that is pretty random
//  */
public int randomNumberGen(){
        return 147;
}

public void printMenu(int menpos){
        Toolkit.clearScreen(red);
        Toolkit.printString("wack\nboom\n", 0, 0, red);
        Toolkit.printString("start", 20, 15, blue);
        Toolkit.printString("help", 20, 16, blue);
        Toolkit.printString(">", 19, menpos, red);
        Toolkit.printString("select with space, w and s to select options, q to quit", 30, 30, red);
        Toolkit.printString("DO NOT HIT THE ARROW KEYS OR ELSE U DIE", 30, 32, blue);
}

public void gameStart(){
        Toolkit.clearScreen(red);
        // Toolkit.printString("START GAME CODE", 20, 20, red);
	Toolkit.shutdown();
	try{
		Nethack.run();
	} catch (Exception e){
		System.out.println("AAAAAAAAAAAA");
	}
	System.out.println("AAAAAAA");
	try{Thread.sleep(2000);}catch (Exception e){}

}

public void help(){
        Toolkit.clearScreen(red);
        Toolkit.printString("made by moody and vincent", 20, 20, red);
        Toolkit.printString("shits trademarked dont even try bro", 20, 22, red);
        char d = read();
}

public void main(){
	System.out.println("AAAAAAAAA");
        Toolkit.init();
        Toolkit.clearScreen(red);
        int menpos = 15;                       //menpos doubles as the y-coor and the identifier for the option
        CharColor red = new CharColor(CharColor.BLACK, CharColor.RED);
        printMenu(menpos);
        while (true){
                char input = read();
                if (input == 'w'){
                        menpos = 15;
                        printMenu(menpos);
                        // System.out.println(menpos);
                        // Toolkit.printString("boom", 5, 5, red);
                }
                if (input == 's'){
                        menpos = 16;
                        printMenu(menpos);
                }
                if (input == ' '){
                        if (menpos == 15){
                                gameStart();
                        }
                        if (menpos == 16){
                                help();
                        }
                }
                if (input == 'q'){
                        Toolkit.shutdown();
                        System.exit(1);
                }
        }
}


public static void main(String[] args){
        Menu x = new Menu();
        x.main();
    }


}
