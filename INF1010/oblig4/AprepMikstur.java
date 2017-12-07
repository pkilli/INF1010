public class AprepMikstur extends Apreparat implements Mikstur{
	private double storrelseCm3;
	private double virkestoffCm3;
	
	public AprepMikstur(String _navn, double _pris, double _virkestoffMg, int _styrke, double _storrelseCm3, double _virkestoffCm3){
		super(_navn, _pris, _virkestoffMg, _styrke);
		storrelseCm3 = _storrelseCm3;
		virkestoffCm3 = _virkestoffCm3;
	}
	public double hentStorrelseCm3(){return storrelseCm3;}
	public double hentVirkestoffCm3(){return virkestoffCm3;}
}