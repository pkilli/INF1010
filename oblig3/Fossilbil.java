public class Fossilbil extends Bil{
	protected double utslipp;
	
	
	public Fossilbil(String _bilnummer, double _utslipp){
		super(_bilnummer);
		utslipp = _utslipp;
	}
	public String kortInfo(){
		beskrivelse = ("Fossilbil: Nummer: " + bilnummer + ", co2Utslipp: " + utslipp);
		return beskrivelse;
	}
}