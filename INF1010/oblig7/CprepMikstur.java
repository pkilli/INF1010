public class CprepMikstur extends Cpreparat implements Mikstur{
	private double storrelseCm3;
	
	public CprepMikstur(String _navn, double _pris, double _virkestoffMg, double _storrelseCm3)
	{
		super(_navn, _pris, _virkestoffMg );
		storrelseCm3 = _storrelseCm3;
	}
	public double hentStorrelseCm3(){return storrelseCm3;}
	public double hentVirkestoffCm3(){return virkestoffMg/storrelseCm3;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"mikstur"+", "+"c"+", "+pris+", "+ storrelseCm3+", "+styrke;
	}
}