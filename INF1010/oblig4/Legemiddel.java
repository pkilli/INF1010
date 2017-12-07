public abstract class Legemiddel{
	static int teller = 0;
	protected String navn;
	protected int nummer;
	protected double pris;
	protected double virkestoffMg;
	public Legemiddel(String _navn, double _pris, double _virkestoffMg){
		navn = _navn;
		pris = _pris;
		virkestoffMg = _virkestoffMg;
		nummer = teller++;
	}
	public int hentNummer(){return nummer;}
	public String toString(){return navn;}
}