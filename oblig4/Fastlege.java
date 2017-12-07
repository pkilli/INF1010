public class Fastlege extends Lege implements Avtale{
	private int avtalenummer;
	public Fastlege(String _navn){
		super(_navn);
	}
	public int avtaleNummer(){
		if(String.valueOf(avtalenummer) != null)
			return avtalenummer;
		return -1;
	}
}