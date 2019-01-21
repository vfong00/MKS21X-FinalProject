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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlacerFactory{

ArrayList<Integer> blankx = new ArrayList<Integer>();
ArrayList<Integer> blanky = new ArrayList<Integer>();
Integer[] xers;
Integer[] yers;
Integer[] index;
Monster[] monsters;

String[] monName =     {"Skeletor", "Solomon",
			"Kolb", "Paxtn",
			"Abysshound", "Moldpaw",
			"Spitebug", "Sorrowling",
			"Brinebody", "Vicent" };
TextCharacter[] sprites =      {new TextCharacter('S'), new TextCharacter('L'),
				new TextCharacter('$'),new TextCharacter('*'),
				new TextCharacter(')'),new TextCharacter('('),
				new TextCharacter('^'),new TextCharacter('+'),
				new TextCharacter('>'),new TextCharacter('8') };

int[] baseDamage =     {2, 4,
			6, 7,
			10, 8,
			11, 12,
			15, 15};

int[] xp = 	       {5, 7,
			6, 9,
			11, 14,
			13, 20,
			25, 35};

int[] hp = 	       {20, 20,
			25, 30,
			34, 33,
			45, 55,
			50, 69};

public PlacerFactory(Maze m, Player p){
	int level = p.getFloor();
	Random randgen = new Random();
	// int x, int y, int givenXP, double hp, double damage, double defense, int accuracy, TextCharacter sprite, String name, Maze map

	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			if (m.getMaze()[x][y].getType().equals("air")){
				blankx.add(new Integer(x));
				blanky.add(new Integer(y));

			}
		}
	}
	ArrayList<Integer> indx = new ArrayList<Integer>();
	for(int x = 0; x < blankx.size(); x++){
		indx.add(new Integer(x));
	}
	Collections.shuffle(indx);
	xers = blankx.toArray(new Integer[blankx.size()]);
	yers = blanky.toArray(new Integer[blanky.size()]);
	index = indx.toArray(new Integer[indx.size()]);

	monsters = new Monster[25];
	for (int x = 0; x < 25; x++){
		int xcoor = xers[index[x]];
		int ycoor = yers[index[x]];
		int nameno = randgen.nextInt(monName.length);
		if (level <= 4 && level > -1){
			nameno = nameno % 2;
		} else if (level <= 8 && level >= 5){
			nameno = nameno % 4;
		} else if (level <=12 && level >= 9){
			nameno = nameno % 6;
		} else if (level <= 15 && level >= 13){
			nameno = nameno % 8;
		}

		int damage;
		int health;

		Monster mon = new Monster(xcoor, ycoor, xp[nameno], hp[nameno], 10.0, 5.0, 60, sprites[nameno], monName[nameno], m);
		monsters[x] = mon;
	}
}

public void mover(){
	for (int x = 0; x < monsters.length; x++){
		monsters[x].nextMove();
	}
}
}
