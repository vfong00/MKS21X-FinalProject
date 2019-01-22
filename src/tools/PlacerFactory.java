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
			"Spitebug", "Sorrowling",
			"Abysshound", "Moldpaw",
			"Brinebody", "Vicent" };

TextCharacter[] sprites =      {new TextCharacter('λ'), new TextCharacter('μ'),
				new TextCharacter('ω'),new TextCharacter('*'),
				new TextCharacter(')'),new TextCharacter('('),
				new TextCharacter('Ξ'),new TextCharacter('+'),
				new TextCharacter('Ψ'),new TextCharacter('Ω') };

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

int[] accuracy =       {88, 59,
 			63, 65,
			72, 78,
			68, 85,
			77, 88};

int[] damages =        {15, 20,
 			20, 20,
			25, 29,
			31, 38,
			45, 59};

int[] defense =        {10, 10,
 			15, 15,
			20, 20,
			25, 25,
			25, 25};

String[] healthNames = {"Mom's Spaghetti", "Fruit Loaf",
			"Spirit Soup", "Astronaut Food",
		 	"Hot Cat", "Potato",
		 	"Spirit Sauce", "Sharingan"};

int[] power =		{5, 7,
			11, 15,
			17, 25,
			35, 55};

TextCharacter[] healthSprites =      {new TextCharacter('a'), new TextCharacter('b'),
				new TextCharacter('e'),new TextCharacter('f'),
				new TextCharacter('j'),new TextCharacter('k'),
				new TextCharacter('q'),new TextCharacter('r')};



String[] weaponNames = {"Dirk", "Balasong",
			"Ragespike", "Florance",
			"Crucifer", "Legacy of the Gladiator",
			"Mithril Touch", "Mithril Hand"};

int[] strng =		{10, 12,
			14, 17,
			22, 27,
			32, 39};

TextCharacter[] weaponSprites = 	{new TextCharacter('⋒'),new TextCharacter('∘'),
 					new TextCharacter('∎'), new TextCharacter('∿'),
					new TextCharacter('⥿'), new TextCharacter('⋮'),
					new TextCharacter('∫'), new TextCharacter('∬') };



String[] armorNames = {"Tunic of Broken Dreams", "Jerkin",
			"Palladium Boots", "Orchalium Greaves",
		 	"Titanium Chainmail", "Admantine Chestpiece",
		 	"Aether Shield", "Aether Amulet"};

int[] arstrng =		{10, 15,
			20, 22,
			30, 38,
			45, 55};
//≊ ≋ ≌ ≍ ≎ ≏ ≐ ≑
TextCharacter[] armorSprites = 	{new TextCharacter('≊'),new TextCharacter('≋'),
 					new TextCharacter('≌'), new TextCharacter('≍'),
					new TextCharacter('≎'), new TextCharacter('≏'),
					new TextCharacter('≐'), new TextCharacter('≑') };

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

		Monster mon = new Monster(xcoor, ycoor, xp[nameno], hp[nameno], damages[nameno],
					defense[nameno], accuracy[nameno], sprites[nameno], monName[nameno],
					m);
		monsters[x] = mon;
	}

	for (int x = 26; x < 31; x++){
		int xcoor = xers[index[x]];
		int ycoor = yers[index[x]];
		int itemno = randgen.nextInt(healthNames.length);
		if (level <= 4 && level > -1){
			itemno = itemno % 2;
		} else if (level <= 8 && level >= 5){
			itemno = itemno % 4;
		} else if (level <=12 && level >= 9){
			itemno = itemno % 6;
		}
		HealthItem h = new HealthItem(xcoor, ycoor, power[itemno], healthNames[itemno], healthSprites[itemno], m);
	}

	for (int x = 31; x < 35; x++){
		int xcoor = xers[index[x]];
		int ycoor = yers[index[x]];
		int weaponno = randgen.nextInt(healthNames.length);
		if (level <= 6 && level > -1){
			weaponno = weaponno % 2;
		} else if (level <= 14 && level >= 7){
			weaponno = weaponno % 4;
		} else if (level <=20 && level >= 15){
			weaponno = weaponno % 6;
		}
		if (randgen.nextInt() % 100 <= 25){
			Weapon w = new Weapon(xcoor, ycoor, strng[weaponno],
			weaponSprites[weaponno],
			weaponNames[weaponno],  m);
		}
	}

	for (int x = 35; x < 40; x++){
		int xcoor = xers[index[x]];
		int ycoor = yers[index[x]];
		int armorno = randgen.nextInt(armorNames.length);
		if (level <= 6 && level > -1){
			armorno = armorno % 2;
		} else if (level <= 14 && level >= 7){
			armorno = armorno % 4;
		} else if (level <=20 && level >= 15){
			armorno = armorno % 6;
		}
		if (randgen.nextInt() % 100 <= 35){
			Armor a = new Armor(xcoor, ycoor, arstrng[armorno],
			armorSprites[armorno], armorNames[armorno], m);
		}
	}
}

public void mover(){
	for (int x = 0; x < monsters.length; x++){
		monsters[x].nextMove();
	}
}
}
