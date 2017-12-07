public class HvitResept extends Resept{
	private int pris = 0;
	public HvitResept(Legemiddel _legemiddel, Lege _navnLege, Pasient _navnPasient, int _reit, int _pris){
		super(_legemiddel, _navnLege, _navnPasient, _reit);
		pris = _pris;
	}
}
