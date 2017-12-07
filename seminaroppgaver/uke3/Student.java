public class Student implements AnsvarligAlkoholkonsument, Chauffeur{
	protected double promille;
	protected String navn;
	public Student(String _navn){
		navn = _navn;
	}
	public String hentNavn(){return navn;}
	public double hentPromille(){return promille;}
	
	public void drikkAv(Flaske<AlkoholholdigDrikke> alkoholflaske){
		promille = alkoholflaske.hentInnhold().hentVolum()*alkoholflaske.hentKapasitet()*0.014;
		System.out.printf("Studenten har  %.1f i promille. \n", promille );
	}
	public void sovUtRusen(){
		promille = 0.0;
		System.out.println("Studenten sover ut rusen......");
	}
	public boolean kanKjoere(){
		boolean ret = false;
		if(promille < 0.2)
			ret = true;
		return ret;
	}
}
