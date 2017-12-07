public class Fastlege extends Lege implements Avtale{
	private int avtalenummer;
	public Fastlege(String _navn, int _avtalenummer){
		super(_navn);
		avtalenummer = _avtalenummer;
	}
	public int avtaleNummer(){
		if(String.valueOf(avtalenummer) != null)
			return avtalenummer;
		return -1;
	}
	public String hentInfo()
	{
		return navn+", "+avtalenummer;
	}
}