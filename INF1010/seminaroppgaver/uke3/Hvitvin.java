public class Hvitvin extends Vin{
	protected boolean toerr;
	
	public Hvitvin(String _beskrivelse, double _volum, int _aargang, boolean _toerr){
		this.beskrivelse 	= _beskrivelse;
		this.volum 		= _volum;
		this.aargang 		= _aargang;
		this.toerr 		= _toerr;
	}
	
	public String kortInfo(){
		if(toerr){
			beskrivelse += volum + ", " + kanSelgesTil() + ", " + aargang + ", toerr";
		}else
			beskrivelse += volum + ", " + kanSelgesTil() + ", " + aargang + ", ikke toerr";
		
		return beskrivelse;
	}
}
