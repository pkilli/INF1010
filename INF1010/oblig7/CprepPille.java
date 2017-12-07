public class CprepPille extends Cpreparat implements Pille{
	private double antallPiller;
	
	public CprepPille(String _navn, double _pris, double _virkestoffMg, double _antallPiller)
	{
		super(_navn, _pris, _virkestoffMg); 
		antallPiller = _antallPiller;
	}
	public double hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffMg/antallPiller;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"pille"+", "+"c"+", "+pris+", "+antallPiller+", "+styrke;
	}
}