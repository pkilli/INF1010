public class Personbil extends Fossilbil{
	protected int passasjerer;
	
	public Personbil(String _bilnummer, double _utslipp, int _passasjerer){
		super(_bilnummer, _utslipp);
		passasjerer = _passasjerer;
	}
	public String kortInfo(){
		beskrivelse = ("Personbil. Nummer: " + bilnummer + ", co2Utslipp: " + utslipp + ", passasjerer: " + passasjerer);
		return beskrivelse;
	}
}