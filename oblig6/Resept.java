public class Resept{
	static int teller = 0;
	int reseptNummer;
	
	public Resept(){
		reseptNummer = teller;
		teller ++;
	}
	public int getReseptNummer(){return reseptNummer;}
	
}