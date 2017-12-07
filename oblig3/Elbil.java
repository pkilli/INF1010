public class Elbil extends Bil{
	protected int kw;
	
	public Elbil(String _bilnummer, int _kw){
		super(_bilnummer);
		kw = _kw;
	}
	public String kortInfo(){
		beskrivelse = ("Elbil: nummer: " + bilnummer + " Batterikapasitet: " + kw);
		return beskrivelse;
	}
}