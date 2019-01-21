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

Monster[] m = new Monster[20];
ArrayList<Integer> blankx = new ArrayList<Integer>();
ArrayList<Integer> blanky = new ArrayList<Integer>();
Integer[] xers;
Integer[] yers;
Integer[] index;
Monster[] monsters;

public PlacerFactory(Maze m, Player p){
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
		Monster mon = new Monster(xcoor, ycoor, 5, 20.0, 5.0, 5.0, 6, new TextCharacter('B'), "big mood", m);
		monsters[x] = mon;
	}
}

}
