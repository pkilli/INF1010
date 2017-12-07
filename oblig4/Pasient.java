public class Pasient{
	static int teller = 0;
	private String foedselsnummer;
	private String navn;
	private String adresse;
	private String postnummer;
	private int pasientnummer;
	
	public Pasient(String _navn, String _foedselsnummer, String _adresse, String _postnummer){
		navn 			= _navn;
		foedselsnummer 	= _foedselsnummer;
		adresse 		= _adresse;
		postnummer 		= _postnummer;
		pasientnummer 	= teller++;
	}
	public String toString(){return navn;}
}