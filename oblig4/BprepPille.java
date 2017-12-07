public class BprepPille extends Bpreparat implements Pille{
	private int antallPiller;
	private double virkestoffPerPille;
	
	public BprepPille(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, int _antallPiller, double _virkestoffPerPille){
		super(_navn, _pris, _virkestoffMg, _avhengighetsGrad); 
		antallPiller = _antallPiller;
		virkestoffPerPille = _virkestoffPerPille;
	}
	public int hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffPerPille;}
}