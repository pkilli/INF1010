public abstract class AlkoholholdigDrikke implements Drikkbar{
	protected String beskrivelse;
	protected double volum;
	
	public double hentVolum(){ return volum;}
	
	public String kortInfo(){
		beskrivelse = volum + ", " + kanSelgesTil();
		return beskrivelse;
	}
	
	public Aldersgrense kanSelgesTil(){
		if(hentVolum()> 0.22){
			return Aldersgrense.OVER20;
		}
		else if(hentVolum() > 0.07){
			return Aldersgrense.OVER18;
		}
		return Aldersgrense.ALLE;
	}
	
}
