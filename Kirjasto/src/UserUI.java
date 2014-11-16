import java.util.Scanner;


public class UserUI {

	User user;
	Scanner scan;
	KirjastoToiminnot toiminnot = new KirjastoToiminnot();

	//constructor
	public UserUI(String[] args)
	{
		ShowUI(args);
	}

	private void ShowUI(String[] args){

		switch (args.length)
		{
		case 0:	
			System.out.println("no parameters, se on moro");
			System.exit(0);
			break;
		case 1: 
			if(args[0].contains("user")){	
				createUserName();
				printUserUI();
			}
			else if(args[0].contains("admin")){
				printAdminUI();
			}	
			else{
				System.out.println("wrong selection, se on moro");
				System.exit(0);
			}

		default:{
			System.out.println("wrong selectio, se on moro");
			System.exit(0);
		}
		}

	}

	private void printAdminUI() {
		int selection  = -1;


		while(selection != 7 )
		{
			scan = new Scanner(System.in);
			System.out.println("**********Admin User************\n"
					+ "1. Lisää hyödyke\n"
					+ "2. Poista hyödyke.\n"
					+ "3. Listaa kaikki\n"
					+ "4. Etsi nimellä\n"
					+ "5. Etsi ISBN numerolla\n"
					+ "6. Näytä myöhässä olevat\n"
					+ "7. Poistu\n");

			System.out.println("Valitse: ");
			selection = scan.nextInt();
			kirjastoOperaatioAdmin(selection);
		}
	}

	private void kirjastoOperaatioAdmin(Integer selection){

		switch (selection){
		case 1: toiminnot.lisaaHyodyke();
		break;
		case 2: toiminnot.poistaHyodyke();
		break;
		case 3: toiminnot.listaaHyodyke();
		break;
		case 4: toiminnot.etsiNimellaHyodyke(); 
		break;
		case 5: toiminnot.etsiISBNHyodyke();
		break;
		case 6: toiminnot.etsiMyöhassaHyodyke();
		break;
		case 7: System.exit(0);
		break;

		}
	}

	private void printUserUI() {
		int selection  = -1;
		scan = new Scanner(System.in);

		while(selection != 5 )
		{
			System.out.println("*************Kirjasto****************\n"
					+ "1. Lainaa kirjastosta\n"
					+ "2. Etsi nimellä\n"
					+ "3. Etsi ISBN numerolla\n"
					+ "4. Palauta hyödyke\n"
					+ "5. Lopeta");
			System.out.println("Valitse: ");
			selection = scan.nextInt();
			kirjastoOperaatioUser(selection);
		}
	}

	private void kirjastoOperaatioUser(Integer selection){

		switch (selection){
		case 1: toiminnot.lainaa();
		break;
		case 2: toiminnot.etsiNimellaHyodyke(); 
		break;
		case 3: toiminnot.etsiISBNHyodyke();
		break;
		case 4: toiminnot.palauta(); 
		break;
		case 5: System.exit(0);
		break;
		}
	}

	public void createUserName(){
		Scanner s = new Scanner(System.in);
		System.out.println("Your first name please:");
		String fName = s.next();
		System.out.println("Your last name please:");
		String lName = s.next();
		user = new User(fName,lName);
		toiminnot.setUser(user);
	}
}

