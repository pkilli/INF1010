public abstract class Resept{
	static int teller = 0;
	protected int reseptNummer;
	protected Legemiddel navnLegemiddel;
	protected Lege navnLege;
	protected Pasient navnPasient;
	protected int reit;
	protected boolean gyldigResept;
	public Resept(Legemiddel _legemiddel, Lege _navnLege, Pasient _navnPasient, int _reit){
		navnLegemiddel	= _legemiddel;
		navnLege		= _navnLege;
		navnPasient 	= _navnPasient;
		reit 			= _reit;
		reseptNummer 	= teller++;
		gyldigResept	= true;
	}
	public boolean gyldigResept(){
		if(reit < 1)
			return false;
		return true;
	}
	public void brukResept(){
		if(!gyldigResept()){
			return;
		}
		reit -= 1;
	}
	public String toString(){
		return "Reseptnummer: " + reseptNummer + ", Legemiddel: " + navnLegemiddel + ", Lege: " + navnLege + ", Pasient: "
				+ navnPasient + ", Reit: " + reit + ", Gyldig resept: " + gyldigResept;
	}
	public int getReseptNummer(){
		return reseptNummer;
		}
}