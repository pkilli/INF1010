class Mus{
	private String navn;
	private boolean lever;
	
	Mus(String _navn){ //setter parameter med _ for oversikt og skille fra variabler.
	navn = _navn;
	lever = true;
	}
	
	public void angrepet(){
		lever = false; // musen doer naar den blir angrepet.
		System.out.println("Musen " + navn + " gikk fra aa vaere levende til aa vaere dod. ");	
	}
	
	public boolean erLevende(){return lever;}
	public String toString(){return navn;} //for pen utskrift
}