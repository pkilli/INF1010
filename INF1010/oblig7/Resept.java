public abstract class Resept implements Lik{
	static int teller = 0;
	protected int reseptNummer;
	protected Legemiddel legemiddel;
	protected int legemiddelNummer;
	protected Lege lege;
	protected String navnLege;
	protected Pasient pasient;
	protected int nummerPasient;
	protected int reit;
	protected boolean gyldigResept;
	public Resept(Legemiddel _legemiddel, Lege _lege, Pasient _pasient, int _reit){
		legemiddel = _legemiddel;
		legemiddelNummer	= _legemiddel.hentNummer();
		lege = _lege;
		navnLege		= _lege.toString();
		pasient = _pasient;
		nummerPasient 	= _pasient.hentNummer();
		reit 			= _reit;
		reseptNummer 	= teller++;
		gyldigResept	= true;
	}
	public boolean gyldigResept(){
		if(reit < 1)
		{
			gyldigResept = false;
			return false;
		}
		return true;
	}
	public void brukResept(){
		if(!gyldigResept())
		{
			System.out.println("Ikke gyldig resept!");
			return;
		}
		reit -= 1;
	}
	public boolean samme(String _reseptnummerFraBruker){
		boolean ret = false;
		int rnummerFraBruker= -1;
		rnummerFraBruker = Integer.parseInt(_reseptnummerFraBruker);
		if(reseptNummer==rnummerFraBruker)
				ret = true;
		
		return ret;
	}
	public abstract void skrivInfo();
	public String hentPasientPostnummer(){return pasient.hentPostNummer();}
	public Legemiddel hentLegemiddel(){return legemiddel;}
	public int hentReseptNummer(){
		return reseptNummer;
		}
}