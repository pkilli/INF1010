public abstract class Apreparat extends Legemiddel{
	protected int styrke;
	public Apreparat(String _navn, double _pris, double _virkestoffMg, int _styrke){
		super(_navn, _pris, _virkestoffMg); 
		styrke =_styrke;
	}
}