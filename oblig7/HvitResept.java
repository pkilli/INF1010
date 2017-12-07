public class HvitResept extends Resept{
	private double pris = 0;
	public HvitResept(Legemiddel _legemiddel, Lege _lege, Pasient _pasient, int _reit){
		super(_legemiddel, _lege, _pasient, _reit);
		pris = _legemiddel.hentPris();
	}
	public String toString()
	{
		//0, blaa, 4, Dr. Hillestad Lovold, 2, 2
		return String.format("%d, %s, %d, %s, %d, %d", reseptNummer,"hvit",nummerPasient,navnLege,legemiddelNummer,reit);
	}
	public void skrivInfo()
	{
		String data = String.format("pris aa betale: %s, lege: %s, pasient: %s", pris,lege.toString(),pasient.hentNavn());
		System.out.println(data);
		System.out.println("Legemidel(nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke]):");
		System.out.println(legemiddel.toString());
	}
}
