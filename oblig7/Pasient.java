public class Pasient implements Lik{
	static int teller = 0;
	private String foedselsnummer;
	private String navn;
	private String adresse;
	private String postnummer;
	private int pasientnummer;
	private int antallNarkotiskeResepter = 0;
	private EnkelReseptListe pasientReseptListe = new YngsteForstReseptListe();
	
	public Pasient(String _navn, String _foedselsnummer, String _adresse, String _postnummer){
		navn 			= _navn;
		foedselsnummer 	= _foedselsnummer;
		adresse 		= _adresse;
		postnummer 		= _postnummer;
		pasientnummer 	= teller++;
	}
	//0, Jens Hans Olsen, 11111143521, Veigata 9, 1323
	public String toString()
	{
		return pasientnummer + ", " +navn+", "+foedselsnummer+", "+adresse+", "+postnummer;	
	}
	public String hentNavn(){return navn;}
	public int hentNummer(){return pasientnummer;}
	public String hentPostNummer(){return postnummer;}
	
	public boolean samme(String _verdi){
		boolean ret = false;
		if(foedselsnummer != null || foedselsnummer != ""){
			if(foedselsnummer.equals(_verdi))
					ret = true;
			}	
		return ret;
	}
	public boolean sammeNavn(String _navn)
	{
		if(navn != null || navn != "")
		{
			if(navn.equals(_navn))
					return true;
		}
		return false;
			
	}
	public int hentAntallGyldigeNarkotiskeResepter()
	{
		int gyldigNarkotiskResepter = 0;
		for(Resept r : pasientReseptListe)
		{
			if(r.gyldigResept() && r instanceof BlaaResept)
				gyldigNarkotiskResepter++;
		}
		return gyldigNarkotiskResepter;
	}
	public void hentLegemiddel(String _reseptnummer)
	{
		
		for(Resept r : pasientReseptListe )
		{
			if(r.samme(_reseptnummer))
			{
				r.brukResept();
				r.skrivInfo();
			}
		}

	}
	public void skrivUtBlaaResepter()
	{
		System.out.println("***Liste over blaa resepter***");
		boolean finnesBlaResept = false;
		for(Resept r : pasientReseptListe)
		{
			if (r instanceof BlaaResept)
			{
				finnesBlaResept = true;
				System.out.println(r);
			}
		}
		if(!finnesBlaResept) System.out.println("Pasient har ingen blaa resepter");
	}
	
	public void settInnResept(Resept _resept)
	{
		if(_resept instanceof BlaaResept) antallNarkotiskeResepter++;
		pasientReseptListe.settInn(_resept);
	}
}