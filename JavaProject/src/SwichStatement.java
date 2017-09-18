import java.util.Scanner;

public class SwichStatement {

	public static void main(String[] args) {
		String name;
		Scanner nam=new Scanner(System.in);
		System.out.println("Enter the Name:");
		name=nam.next();
		switch (name){
		case "Munna":
			System.out.println("Munna is a programmer");
			break;
		case "Titas":
			System.out.println("Titas is a player");
			break;
		case "Shaon":
			System.out.println("Shaon is a good boy");
			break;
		default:
			System.out.println("Hello!! Stranger");
				
		}
	}

}
