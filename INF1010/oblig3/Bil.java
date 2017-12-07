public class Bil{
	protected String bilnummer;
	protected String beskrivelse;
	public Bil(String _bilnummer){
		bilnummer=_bilnummer;
	}
	public String kortInfo(){
		beskrivelse = ("Bil. Nummer: " + bilnummer);
		return beskrivelse;
	}
}