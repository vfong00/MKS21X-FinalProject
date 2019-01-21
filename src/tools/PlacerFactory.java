public class PlacerFactory{

Monster[] m = new Monster[20];
int[] blankx = new int[20];
int[] blanky = new int[20];
public PlacerFactory(Maze m){
	// int x, int y, int givenXP, double hp, double damage, double defense, int accuracy, TextCharacter sprite, String name, Maze map

	int c = 0;
	for (int x = 0; x < 100; x++){
		for (int y = 0; y < 30; y++){
			if (m.getMaze()[x][y].getType().equals("air") && c < 21){
				blankx[c] = x;
				blanky[c] = y;
				c++;
			}
		}
	}
	for (int x = 0; x < 20; x++){
		// m[x] = new Monster()
	}
}
}
