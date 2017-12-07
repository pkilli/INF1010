public class AprepPille extends Apreparat implements Pille{
	private double antallPiller;

	
	public AprepPille(String _navn, double _pris, double _virkestoffMg, int _styrke, double _antallPiller){
		super(_navn, _pris, _virkestoffMg, _styrke); 
		antallPiller = _antallPiller;
	}
	public double hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffMg/antallPiller;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"pille"+", "+"a"+", "+pris+", "+antallPiller+", "+styrke;
	}
}