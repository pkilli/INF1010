public class Lege implements Lik, Comparable<Lege>{
	protected String navn;
	protected int antallNarkotiskeResepter = 0;
	protected EnkelReseptListe legeReseptListe = new EldsteForstReseptListe();
	
	public Lege(String _navn){
		navn = _navn;
	}
	
	public boolean samme(String _verdi){
		boolean ret = false;
		if(navn != null || navn != ""){
			if(navn.equalsIgnoreCase(_verdi))
					ret = true;
			}	
		return ret;
	}
	public String toString(){return navn;}
	public int hentAntallNarkotiskeResepter(){return antallNarkotiskeResepter;}	
	
	public int compareTo(Lege _l)
	{
		return navn.compareTo(_l.navn);
	}
	public void settInnResept(Resept _resept)
	{
		if(_resept instanceof BlaaResept) antallNarkotiskeResepter++;
		legeReseptListe.settInn(_resept);
	}
	public void skrivReseptListe()
	{
		for(Resept resept:legeReseptListe)
			System.out.println(resept.toString());
	}
	
	public void skrivMiksturPreparater()
	{
		double samletMengdeVirkestoff = 0;
		double samletMengdeMikstur = 0;
		double samletMengdePille = 0;
		for(Resept r : legeReseptListe )
		{
			samletMengdeVirkestoff += r.hentLegemiddel().hentVirkestoff();
			if(r.hentLegemiddel() instanceof Mikstur)
			{
				samletMengdeMikstur +=r.hentLegemiddel().hentVirkestoff();
				System.out.println(r);	
			}else if(r.hentLegemiddel() instanceof Pille)
			{
				samletMengdePille += r.hentLegemiddel().hentVirkestoff();
			}
		}
		System.out.println("Samlet mengde Mg virkestoff legen har skrevet ut: "+samletMengdeVirkestoff);
		System.out.println("Andel som er mikstur: "+samletMengdeMikstur);
		System.out.println("Andel som er Pille: "+samletMengdePille);
	}
	public String hentInfo()
	{
		return navn+", "+0;
	}
	
}
