import java.util.Random;

public class Generation{

public int seed;
public Random randgen;
public Tile[][] map = new Tile[100][30];

public Generation(int seed){
	randgen = new Random();
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			map[x][y] = new Tile();
		}
	}
}

public String getVal(int x, int y){
	return map[x][y].toString();
}

public void print(){
	for (int y = 29; y >= 0; y--) {
                for (int x = 0; x < 100; x++) {
                        System.out.print(map[x][y].getCurrent());
                }
		System.out.println();
        }
}

public char[][] getGenerated(){
	char[][] output = new char[100][30] ;
	for (int y = 29; y >= 0; y--) {
                for (int x = 0; x < 100; x++) {
                        System.out.print(map[x][y].getCurrent());
			output[x][y] = map[x][y].getCurrent();
                }
        }
	return output;
}

public String toString(){
	String output = "";
	for (int y = 29; y >= 0; y--) {
                for (int x = 0; x < 100; x++) {
                        output += map[x][y].getCurrent();
                }
		output += "\n";
        }
	return output;
}

public void randomPlacer(){
	int rnum;
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			rnum = randgen.nextInt();
			if (rnum < 38){
				map[x][y].setCurrent(' ');
			} else {
				map[x][y].setCurrent('0');
			}
			if (y == 10){
				map[x][y].setCurrent(' ');
			}
			if (y == 11){
				map[x][y].setCurrent(' ');
			}
			// if (y == 16){
			// 	map[x][y].setCurrent(' ');
			// }
			if (x == 10){
				map[x][y].setCurrent(' ');
			}
			if (x == 11){
				map[x][y].setCurrent(' ');
			}
		}
	}
}

public void caveGenerate(){
	int deadNeighbors;
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			Tile curr = map[x][y];
			curr.setNext(curr.getCurrent());
			if (curr.getCurrent() == '0'){
				if (countAliveNeighbours(x, y) > 4){
					curr.setNext(' ');
				}
			} else{
				if (countAliveNeighbours(x, y) < 3){
					curr.setNext('0');
				}
			}
		}
	}
}

public int countAliveNeighbours(int x, int y){
	int count = 0;
	for (int xinc = -1; xinc < 2; xinc++){
		for (int yinc = -1; yinc < 2; yinc++){
			try {
				if (xinc == 0 && yinc == 0){

				} else if (map[x + xinc][y + yinc].getCurrent() == ' '){
					count++;
				}
			} catch (Exception e){

			}
		}
	}
	return count;
}

public void update(){
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			map[x][y].trans();
		}
	}
}

public void generate(){
	randomPlacer();
	for (int z = 0; z < 2; z++){
		caveGenerate();
		update();
	}
}

public static void main(String[] args) {
	Generation m = new Generation(13);
	System.out.println();
	// for (int x = 0; x < 100; x++){
	// 	for (int y = 0; y < 30; y++){
	// 		m.map[x][y].setCurrent(' ');
	// 	}
	// }
	m.generate();
	m.print();
	// System.out.println(m.getVal(99, 29));



}


private class Tile{
	public char current;
	public char next;

	public Tile() {
	}

	public void trans(){
		current = next;
	}

	public String toString(){
		return this.getCurrent() + "";
	}

	public char getCurrent(){
		return current;
	}

	public void setCurrent(char inp){
		current = inp;
	}

	public void setNext(char inp){
		next = inp;
	}

}


}
