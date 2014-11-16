
import java.time.LocalDateTime;



abstract public class Teos{

	private User theUser;
	ReadInput read = new ReadInput();
	private String teoksenTekija;
	private String teoksenNimi;
	private String teoksenISBN;
	protected Boolean lainassa;
	protected LocalDateTime lainattuPaiva;
	protected LocalDateTime palautusPaiva;
	
	abstract public void borrowed();
	
	abstract public void returned();

	
	public String getTeoksenNimi() {
		return teoksenNimi;
	}
	public void setTeoksenNimi(String teoksenNimi) {
		this.teoksenNimi = teoksenNimi;
	}
	public String getTeoksenTekija() {
		return teoksenTekija;
	}
	public void setTeoksenTekija(String teoksenTekijä) {
		this.teoksenTekija = teoksenTekijä;
	}
	public String getTeoksenISBN() {
		return teoksenISBN;
	}
	public void setTeoksenISBN(String teoksenISBN) {
		this.teoksenISBN = teoksenISBN;
	}
	
	public Teos teeHyodyke(){	
		System.out.println("Anna teoksenTekijä");
		setTeoksenTekija(read.readInputString());
		System.out.println("Anna teoksenNimi");
		setTeoksenNimi(read.readInputString());
		System.out.println("Anna teoksenISBN");
		setTeoksenISBN(read.readInputString());
	    return this;
		
	}
	
	 public void setUser(User user){
		 theUser = user;
		 }
	
	@Override 
	public String toString(){

		if(theUser == null)
		{	
			return("  teoksenTekijä:   " + this.getTeoksenTekija() +
					"  teoksenNimi:     " + this.getTeoksenNimi() +
					"  teoksenISBN:     " + this.getTeoksenISBN()
					);
		}
		else
		{
			return( "  teoksenTekijä:   " + this.getTeoksenTekija() +
					"  teoksenNimi:     " + this.getTeoksenNimi() +
					"  teoksenISBN:     " + this.getTeoksenISBN() +
					"  teoksenLainaaja  " + theUser.getFirstName()
					);
		}
	}
	
	
	
	
	
	
}
