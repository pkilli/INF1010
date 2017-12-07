class Handlevogn{
	public static void main(String[] args){
		Avgiftsbar[] handlevogn = new Avgiftsbar[4];
		handlevogn[0] = new Mat("Melk", 12.77);
		handlevogn[1] = new IkkeMat("Vaskemiddel", 24.36);
		handlevogn[2] = new Mat("Sjokolade", 19.48);
		handlevogn[3] = new IkkeMat("Ikke-Les-Meg-Magasinet", 40.00);
		double totpris 	= 0;
		double totmvapris 	= 0;
		for(Avgiftsbar vare: handlevogn){
			totpris 	+= vare.pris();
			totmvapris 	+= vare.avgift();
		}
		System.out.println("Den totale prisen paa varene er : " + totpris + " Kr.");
		System.out.println("Den totale merverdiavgiften paa varene er : " + totmvapris + " Kr.");
	}
}