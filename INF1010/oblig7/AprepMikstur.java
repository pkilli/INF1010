public class AprepMikstur extends Apreparat implements Mikstur{
	private double storrelseCm3;
	
	public AprepMikstur(String _navn, double _pris, double _virkestoffMg, int _styrke, double _storrelseCm3)
	{
		super(_navn, _pris, _virkestoffMg, _styrke);
		storrelseCm3 = _storrelseCm3;
	}
	public double hentStorrelseCm3(){return storrelseCm3;}
	public double hentVirkestoffCm3(){return virkestoffMg/storrelseCm3;}
	public String toString()
	{
		//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
		return nummer+", "+navn+", "+"mikstur"+", "+"a"+", "+pris+", "+ storrelseCm3+", "+styrke;
	}

}