public class BlaaResept extends Resept{
	private int pris;
	public BlaaResept(Legemiddel _legemiddel, Lege _navnLege, Pasient _navnPasient, int _reit){
		super(_legemiddel, _navnLege, _navnPasient, _reit);
		pris = 0;
	}
}