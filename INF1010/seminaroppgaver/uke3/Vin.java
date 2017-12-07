public class Vin extends AlkoholholdigDrikke{
	protected int aargang;

	public String kortInfo(){
		beskrivelse += volum + ", " + kanSelgesTil() + aargang;
		return beskrivelse;
	}
}
