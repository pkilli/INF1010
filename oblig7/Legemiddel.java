public abstract class Legemiddel{
	static int teller = 0;
	protected String navn;
	protected int nummer;
	protected double pris;
	protected double virkestoffMg;
	
	// Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
	public Legemiddel(String _navn, double _pris, double _virkestoffMg){
		navn = _navn;
		pris = _pris;
		virkestoffMg = _virkestoffMg;
		nummer = teller++;
	}
	public double hentVirkestoff(){return virkestoffMg;}
	public int hentNummer(){return nummer;}
	public double hentPris(){return pris;}
	public String toString(){return navn;}
	public int sammeNavn(String _navn)
	{
		if(navn != null || navn != ""){
			if(navn.equals(_navn))
					return this.nummer;
			}
		return -1;
	}
}