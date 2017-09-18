import java.util.Scanner;

public class ElseIf {

	public static void main(String[] args) {
		System.out.println("Enter a number:");
		Scanner obj=new Scanner (System.in);
		int num=obj.nextInt();
		if (num==30){
			System.out.println("Number is equal to 30");
		}
		else if (num<30){
			if (num<10){
			System.out.println("Number is less than 10");
			}
			else{
				System.out.println("Number is equal to or greater than 10");
			}
	}
		else{
			System.out.println("Number is greater than 30");
	}
}
}
