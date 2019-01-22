import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;


public class Maze{

private Tileable[][] maze;

/**
 * A 100 by 30 maze, which is just a 2D array of Tileables.
 */
public Maze(){
	maze = new Tileable[100][30];
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			// initally make everything air
			maze[x][y] = new Air(x, y);
		}
	}
}

/**
 * Accessor method for maze field.
 *
 * @return The maze.
 */
public Tileable[][] getMaze(){
	return maze;
}

/**
 * Places tileable into maze.
 *
 * @param x     The x-coordinate where the tileable is placed.
 * @param y     The y-coordinate where the tileable is placed.
 * @param toSet The tileable.
 */
public void setTile(int x, int y, Tileable toSet){
	maze[x][y] = toSet;
}

/**
 * Prints the contents of the maze onto the terminal
 *
 * @param  t           The screen to print this maze onto.
 */
public void printMaze(TerminalScreen t) throws IOException{
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			// t.setCursorPosition(x, y + 5);
			// char c = maze[x][y].getSprite();
			// t.putCharacter(c);
			t.setCharacter(x, y + 5, new TextCharacter(maze[x][y].getSprite().getCharacter(), ANSI.DEFAULT, ANSI.DEFAULT));
		}
	}
}

/**
 * [regenMaze description]
 *
 * @param  maze        The maze
 * @param  terminal    The terminal to print this maze onto
 * @param  g           The generation object
 */
public static void regenMaze(Maze maze, Terminal terminal, Generation g) throws IOException{
	terminal.clearScreen();
	maze.calcGenerated(g, maze);

	// game crashes if border is overreached,
	// this draws in border walls
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			if (x == 0 || x == 99){
				new Wall(x, y, maze);
			}
			if (y == 0 || y == 29){
				new Wall(x, y, maze);
			}
		}
	}
	Wall y = new Wall(10, 0, maze);
	y.easterEgg();
}

/**
 * Uses Moody's code for maze generation,
 * and translates it to a useable array of objects for this game.
 *
 * @param g    The generation object
 * @param maze The maze to build.
 */
public void calcGenerated(Generation g, Maze maze){
	g.generate();
	char[][] gen = g.getGenerated();
	for(int x = 0; x < 100; x++){
		for(int y = 0; y < 30; y++){
			if (gen[x][y] == '0'){
				maze.setTile(x, y, new Wall(x, y, maze));
			}
			else{
				maze.setTile(x, y, new Air(x, y));
			}
			if (x == 0 || x == 99){
				new Wall(x, y, maze);
			}
			if (y == 0 || y == 29){
				new Wall(x, y, maze);
			}
		}
	}
}

}
