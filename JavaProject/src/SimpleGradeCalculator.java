import java.util.Scanner;

public class SimpleGradeCalculator {

	public static void main(String[] args) {
		float num;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter your Marks:");
		num=obj.nextFloat();
		if (num<=100 && num>=80){
			System.out.println("Your Grade is A+");
		}
		else if (num<=80 && num>=70){
			System.out.println("Your Grade is A");
		}
		else if (num<=70&& num>=60){
			System.out.println("Your Grade is B");
		}
		else if (num<=60 && num>=0){
			System.out.println("Your Failed");
		}
		else {
			System.out.println("Your enter number is not valid");
		}
		
	}

}
