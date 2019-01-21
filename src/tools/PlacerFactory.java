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
import java.util.Random;

public class PlacerFactory{

Monster[] m = new Monster[20];
ArrayList<Integer> blankx = new ArrayList<Integer>();
ArrayList<Integer> blanky = new ArrayList<Integer>();
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
	Integer[] xers = blankx.toArray(new Integer[blankx.size()]);
	Integer[] yers = blanky.toArray(new Integer[blanky.size()]);

	// for (){
	//
	// }
}
}
