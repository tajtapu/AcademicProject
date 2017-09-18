import java.util.Scanner;

public class InputData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a integer Number:");
		int number=sc.nextInt();
		System.out.println("Enter a float Number:");
		float number2=sc.nextFloat();
		System.out.println("Second Number:"+number2);
		Scanner st=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name=st.nextLine();
		System.out.println("Your name:"+name);
	}

}
