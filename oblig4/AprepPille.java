public class AprepPille extends Apreparat implements Pille{
	private int antallPiller;
	private double virkestoffPerPille;
	
	public AprepPille(String _navn, double _pris, double _virkestoffMg, int _styrke, int _antallPiller, double _virkestoffPerPille){
		super(_navn, _pris, _virkestoffMg, _styrke); 
		antallPiller = _antallPiller;
		virkestoffPerPille = _virkestoffPerPille;
	}
	public int hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffPerPille;}
}