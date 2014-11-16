import java.time.LocalDateTime;


public class Magazine extends Teos{
 
	private String lehdenHinta;       
    ReadInput read = new ReadInput();
	
	public String getLehdenHinta() {
		return lehdenHinta;
	}

	public void setLehdenHinta(String lehdenHinta) {
		this.lehdenHinta = lehdenHinta;
	}
	
	@Override
	public Teos teeHyodyke(){
		//yhteiset piirteet superissa
		super.teeHyodyke();
		System.out.println("Anna lehden Hinta");
		setLehdenHinta(read.readInputString());
		return this;
	}
	
	@Override 
	public String toString(){
		 super.toString();
		 return(super.toString() + "  lehdenHinta:  " + this.getLehdenHinta()
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