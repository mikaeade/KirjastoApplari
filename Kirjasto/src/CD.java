import java.time.LocalDateTime;


public class CD extends Teos{
 
	private String kappaleidenLkm;       
    ReadInput read = new ReadInput();
	
	public String getKappaleidenLkm() {
		return kappaleidenLkm;
	}

	public void setKappaleidenLkm(String kappaleidenLkm) {
		this.kappaleidenLkm = kappaleidenLkm;
	}
	
	@Override
	public Teos teeHyodyke(){
		//yhteiset piirteet superissa
		super.teeHyodyke();
		System.out.println("Anna CD:n kappaleiden lukumäärä");
		setKappaleidenLkm(read.readInputString());
		return this;
	}
	
	@Override 
	public String toString(){
		
		 return( super.toString() + "   kappaleidenLkm:  " + this.getKappaleidenLkm()
				);
	}
	@Override
	public void borrowed() {
		lainassa = true;
		lainattuPaiva = LocalDateTime.now();
		palautusPaiva = lainattuPaiva.plusDays(10);
		
	}

	@Override
	public void returned() {
		palautusPaiva = null;
		lainattuPaiva = null;
		lainassa = false;
		// TODO Auto-generated method stub
		
	}
}