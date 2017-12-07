public class Roedvin extends Vin{
	protected boolean fyldig;
	
	public Roedvin(String _beskrivelse, double _volum, int _aargang, boolean _fyldig){
		this.beskrivelse 	= _beskrivelse;
		this.volum 		= _volum;
		this.aargang 		= _aargang;
		this.fyldig 		= _fyldig;
	}
	public String kortInfo(){

	beskrivelse = " Har drukket " + beskrivelse + ", den har " + volum + "% alkohol i seg";

	return beskrivelse;
	}
}
