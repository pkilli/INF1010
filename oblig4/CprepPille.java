public class CprepPille extends Cpreparat implements Pille{
	private int antallPiller;
	private double virkestoffPerPille;
	
	public CprepPille(String _navn, double _pris, double _virkestoffMg, int _antallPiller, double _virkestoffPerPille){
		super(_navn, _pris, _virkestoffMg); 
		antallPiller = _antallPiller;
		virkestoffPerPille = _virkestoffPerPille;
	}
	public int hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffPerPille;}
}