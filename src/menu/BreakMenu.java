public class BreakMenu{

	public static void main(String[] args) {
	    // Local variable
	    int swValue;

	    // Display menu graphics
	    System.out.println("============================");
	    System.out.println("|   MENU SELECTION DEMO    |");
	    System.out.println("============================");
	    System.out.println("| Options:                 |");
	    System.out.println("|        1. Option 1       |");
	    System.out.println("|        2. Option 2       |");
	    System.out.println("|        3. Exit           |");
	    System.out.println("============================");
	    swValue = Keyin.inInt(" Select option: ");

	    // Switch construct
	    switch (swValue) {
	    case 1:
	      System.out.println("Option 1 selected");
	      break;
	    case 2:
	      System.out.println("Option 2 selected");
	      break;
	    case 3:
	      System.out.println("Exit selected");
	      break;
	    default:
	      System.out.println("Invalid selection");
	      break; // This break is not really necessary
	    }
	  }
}
