
import asg.cliche.Command;
import asg.cliche.ShellFactory;
import java.io.IOException;



public class ClicheMenu{

    @Command // One,
    public String start() {
        return "Hello, World!";
    }

    @Command // two,
    public int add(int a, int b) {
        return a + b;
    }

    @Command // two,
    public void game() throws IOException{
        Nethack.run();
    }

    public static void main(String[] args) throws IOException {
	    System.out.println("WELCOME");
        ShellFactory.createConsoleShell(">", "", new ClicheMenu())
            .commandLoop(); // and three.
    }
}
