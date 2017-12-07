class Rotte{
	private String navn;
	private boolean lever;
	private boolean skadet;
	
	
	Rotte(String _navn){  //setter parameter med _ for oversikt og skille fra variabler.
	navn = _navn;
	lever = true;
	skadet = false;
	}
	
	public void angrepet(){
		if(skadet){   // Er rotta skadet, saa doer den
			System.out.println("Rotten " + navn + " gikk fra aa vaere levende til aa vaere dod. ");
			lever = false;
		}
		else{ // dersom den ikke er skadet fra foer, blir den det.
			skadet = true;
			System.out.println("Rotten " + navn + " gikk fra aa vaere levende til aa vaere skadet. ");
		}
	}
	
	public boolean erLevende(){return lever;}
	public String toString(){return navn;} // for aa faa pen utskrift
}