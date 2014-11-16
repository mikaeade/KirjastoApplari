import java.util.Scanner;


public class ReadInput {
	
    Scanner scan = new Scanner(System.in);
	
    public Integer readInputInteger(){

	    System.out.println("Valitse: ");
		Integer I = scan.nextInt();
		System.out.println();
		return I;
	}
    public String readInputString(){
		String I = scan.nextLine();
		System.out.println();
		return I;
	}
	

}
