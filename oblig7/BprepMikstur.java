public class BprepMikstur extends Bpreparat implements Mikstur{
	private double storrelseCm3;

	

	public BprepMikstur(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, double _storrelseCm3)
	{
		super(_navn, _pris, _virkestoffMg, _avhengighetsGrad);
		storrelseCm3 = _storrelseCm3;

	}
	public double hentStorrelseCm3(){return storrelseCm3;}
	public double hentVirkestoffCm3(){return virkestoffMg/storrelseCm3;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"mikstur"+", "+"b"+", "+pris+", "+ storrelseCm3+", "+avhengighetsGrad;
	}
}