import java.time.LocalDateTime;


public class DVD extends Teos{
 
	private String ikaRaja;     // ikaRaja S, k11, k16.   
    ReadInput read = new ReadInput();
	
	public String getIkaRaja() {
		return ikaRaja;
	}

	public void setIkaRaja(String ikaRaja) {
		this.ikaRaja = ikaRaja;
	}
	
	@Override
	public Teos teeHyodyke(){
		//yhteiset piirteet superissa
		super.teeHyodyke();
		System.out.println("Anna DVD:n ikäraja");
		setIkaRaja(read.readInputString());
		return this;
	}
	
	@Override 
	public String toString(){
		 
		 return(super.toString() + "   IkaRaja:  " + this.getIkaRaja()
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
	