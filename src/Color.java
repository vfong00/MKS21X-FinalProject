import com.googlecode.lanterna.terminal.ansi.*;
import com.googlecode.lanterna.TextColor.*;
public class Color{

private ANSI fore;
private ANSI back;

public Color(ANSI foree, ANSI backk){
	this.fore = foree;
	this.back = backk;
}

public ANSI getBack(){
	return back;
}

public ANSI getFore(){
	return fore;
}

}
