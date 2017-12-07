public class BprepMikstur extends Bpreparat implements Mikstur{
	private double storrelseCm3;
	private double virkestoffCm3;
	
	public BprepMikstur(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, double _storrelseCm3, double _virkestoffCm3){
		super(_navn, _pris, _virkestoffMg, _avhengighetsGrad);
		storrelseCm3 = _storrelseCm3;
		virkestoffCm3 = _virkestoffCm3;
	}
	public double hentStorrelseCm3(){return storrelseCm3;}
	public double hentVirkestoffCm3(){return virkestoffCm3;}
}