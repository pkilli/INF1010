public class BprepPille extends Bpreparat implements Pille{
	private double antallPiller;
	
	public BprepPille(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, double _antallPiller)
	{
		super(_navn, _pris, _virkestoffMg, _avhengighetsGrad); 
		antallPiller = _antallPiller;
	}
	public double hentAntallPiller(){return antallPiller;}
	public double hentVirkestoffPerPille(){return virkestoffMg/antallPiller;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"pille"+", "+"b"+", "+pris+", "+antallPiller+", "+avhengighetsGrad;
	}
}