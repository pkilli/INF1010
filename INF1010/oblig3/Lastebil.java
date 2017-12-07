public class Lastebil extends Fossilbil{
	protected double nyttevekt;
	
	public Lastebil(String _bilnummer, double _utslipp, double _nyttevekt){
		super(_bilnummer, _utslipp);
		nyttevekt = _nyttevekt;
	}
	
	public String kortInfo(){
		beskrivelse = ("Lastebil. Nummer: " + bilnummer + ", co2Utslipp: " + utslipp + ", nyttevekt: " + nyttevekt);
		return beskrivelse;
	}
}