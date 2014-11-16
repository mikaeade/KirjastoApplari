
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class KirjastoToiminnot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String filename = "/Users/library.txt";
	static List<Teos> teokset = new ArrayList<Teos>();

	ReadInput read = new ReadInput();
	private User theUser;

	private Scanner scan;

	public void lisaaHyodyke(){

		System.out.println("**********Hyodyke************\n"
				+ "1. Lisää Kirja\n"
				+ "2. Lisää DVD.\n"
				+ "3. Lisää CD\n"
				+ "4. Lisää Magazine\n"
				+ "5. Poistu\n");	

		switch(read.readInputInteger()){
		case 1: 
			// lisää kirja
			Teos kirja = new Kirja();
			teokset.add(kirja.teeHyodyke());
			XMLcomposer.createXmlDocument();
			break;
		case 2: 
			// lisää DVD
			Teos dvd = new DVD();
			teokset.add(dvd.teeHyodyke());
			break;
		case 3: 
			// lisää CD
			Teos cd = new CD();
			teokset.add(cd.teeHyodyke());
			break;
		case 4: 
			// lisää DVD
			Teos magazine = new Magazine();
			teokset.add(magazine.teeHyodyke());
			break;		
		}
	}	

	public void poistaHyodyke(){

		System.out.println("Anna ISBN numero:");
		scan = new Scanner(System.in);
		String isbn = scan.next();
		int index = 0;  //ehkä vektori, jos useita samalla ISBN:llä
		for(Teos teos: teokset) // tämä ei toimi
		{
			if(teos.getTeoksenISBN().equalsIgnoreCase(isbn)){
				index = teokset.indexOf(teos);
			}	
		}
		File file = new File("/Users/mikaeade/kirjasto/kirjasto.xml");
		file.delete();
		System.out.println(index);
		teokset.remove(index);
		XMLcomposer.createXmlDocument();
	}

	public void listaaHyodyke(){

		for(Teos teos : teokset)
		{
			System.out.println(teos);
		}
	}	

	public void etsiNimellaHyodyke(){
		scan = new Scanner(System.in);
		System.out.println("Anna teokset Nimi :");
		String etsittyNimi= scan.next();

		for(Teos teos: teokset)
		{
			if(teos.getTeoksenNimi().equalsIgnoreCase(etsittyNimi)){
				System.out.println(teos);
			}	
		}
	}

	public void etsiISBNHyodyke(){
		scan = new Scanner(System.in);
		System.out.println("Anna teokset ISBN:");
		String ISBN = scan.next();
		for(Teos teos: teokset)
		{
			if(teos.getTeoksenISBN().equalsIgnoreCase(ISBN)){
				System.out.println(teos);
			}	
		}
	}

	public void etsiMyöhassaHyodyke(){

		for(Teos teos: teokset)
		{
			if(teos.lainassa)
			{
				System.out.println(teos);
			}
		}
	}
	
	public void lainaa(){

		System.out.println("Anna lainattavan ISBN");
		scan = new Scanner(System.in);
		String ISBN = scan.next();
		for(Teos teos: teokset)
		{
			if(teos.getTeoksenISBN().equalsIgnoreCase(ISBN)){
				System.out.println(teos);
				if(!(teos.lainassa)){		
					teos.borrowed();
				}
				else{
					System.out.println("teos on jo lainassa");				
				}
		   }	
		}
	}
	
	 public void setUser(User user){
		 theUser = user;
    }
	
	public void palauta(){

		System.out.println("Anna palautettavan ISBN");
		scan = new Scanner(System.in);
		String ISBN = scan.next();
		for(Teos teos: teokset)
		{
			if(teos.getTeoksenISBN().equalsIgnoreCase(ISBN)){
				System.out.println(teos);
				if(teos.lainassa){		
					teos.borrowed();
				}
				else{
					System.out.println("teosta ei ole edes lainattu");				
				}
		   }	
		}
	}
	
}
