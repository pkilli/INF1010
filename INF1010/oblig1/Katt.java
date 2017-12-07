class Katt{
	private String navn;
	
	Katt(String _navn){  //setter parameter med _ for oversikt og skille fra variabler.
		navn = _navn;
	}
	
	public void jakt(Bol<Mus> _musebol, Bol<Rotte> _rottebol){ 
		//sjekker om det er noe der  og om det er spiselig
		if(!_musebol.erTomt() && _musebol.beboer().erLevende()){ 
			System.out.println("Katten " + navn + " gjorde et angrep paa musen " + _musebol.beboer().toString() + ".");
			_musebol.beboer().angrepet();
		}
		//sjekker det nest beste
		else if(!_rottebol.erTomt() && _rottebol.beboer().erLevende()){ 
			System.out.println("Katten " + navn + " gjorde et angrep paa rotten " + _rottebol.beboer().toString() + ".");
			_rottebol.beboer().angrepet();
		}
		// Ingen gnager denne gang.
		else
			System.out.println("Katten Tom fant ingen gnagere. Jakten avsluttes.");
	}
}