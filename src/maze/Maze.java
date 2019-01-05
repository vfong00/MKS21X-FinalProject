import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.terminal.ansi.*;
import java.io.IOException;


public class Maze{

Object[][] maze;

public Maze(){
	maze = new Object[40][100];
}

public Object getMaze(){
	return maze;
}

public void setTile(int x, int y, Object toSet){
	maze[x][y] = toSet;
}

public void printMaze(Terminal t) throws IOException{
	for (int y = 29; y >= 0; y--) {
                for (int x = 0; x < 100; x++) {
                        t.setCursorPosition(x, y);
                }
		System.out.println();
        }
}


}
