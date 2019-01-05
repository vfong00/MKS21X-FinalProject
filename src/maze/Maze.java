import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;

public class Maze{

Object[][] maze;

public Maze(){
	maze = new Object[40][140];
}

public Object getMaze(){
	return maze;
}

public void setTile(int x, int y, Object toSet){
	maze[x][y] = toSet;
}

public void printMaze(Terminal t){
}


}
