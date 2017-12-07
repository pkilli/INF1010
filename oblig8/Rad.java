public class Rad extends BrettDeler{
	private static int teller;
	private int radnummer=0;
	
	public Rad(Brett brett){
        super(brett);
		radnummer = teller++;
	}
	public int hentNummer(){return radnummer;}
	
	public String toString(){return " radnummer: " + radnummer;}
}