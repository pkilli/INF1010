public abstract class Bpreparat extends Legemiddel{
	protected int avhengighetsGrad;
	public Bpreparat(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad){
		super(_navn, _pris, _virkestoffMg);
		avhengighetsGrad = _avhengighetsGrad;
	}
}