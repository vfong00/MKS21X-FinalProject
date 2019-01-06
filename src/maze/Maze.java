import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
import com.googlecode.lanterna.Symbols.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;


public class Maze{

private Tileable[][] maze;

public Maze(){
	maze = new Tileable[30][100];
	for (int x = 0; x < 30; x++){
		for (int y = 0; y < 100; y++){
			maze[x][y] = new Air(x, y);
		}
	}
}

public Tileable[][] getMaze(){
	return maze;
}

public void setTile(int x, int y, Tileable toSet){
	maze[x][y] = toSet;
}

public void printMaze(Terminal t) throws IOException{
	for (int x = 0; x < 30; x++){
		for (int y = 0; y < 100; y++){
			t.setCursorPosition(x, y);
			char c = maze[x][y].getSprite();
			t.putCharacter(c);
		}
	}
}

}
