import java.io.Serializable;
import java.time.LocalDateTime;


public class Kirja extends Teos implements Serializable{
 
	private Integer sivujenLkm;
    ReadInput read = new ReadInput();
	
	public Integer getSivujenLkm() {
		return sivujenLkm;
	}

	public void setSivujenLkm(Integer sivujenLkm) {
		this.sivujenLkm = sivujenLkm;
	}
	
	@Override
	public Teos teeHyodyke(){
		
		super.teeHyodyke();
		System.out.println("Anna sivujenLukumäärä");
		setSivujenLkm(read.readInputInteger());
		return this;
	}
	
	@Override 
	public String toString(){
		 super.toString();
		 return(super.toString() + "  sivujenLukumäärä:  " + this.getSivujenLkm()
				);
	}

	@Override
	public void borrowed() {
		lainassa = true;
		lainattuPaiva = LocalDateTime.now();
		palautusPaiva = lainattuPaiva.plusMonths(1);
		
	}

	@Override
	public void returned() {
		palautusPaiva = null;
		lainattuPaiva = null;
		lainassa = false;
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
