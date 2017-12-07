public class Bok implements TilUtlaan{
	private String tittel;
	private String forfatter;
	private boolean utlaant;
	private String laaner;
	public Bok(String _tittel, String _forfatter){
		tittel 		= _tittel;
		forfatter 	= _forfatter;
		utlaant 	= false;
	}
	public void laanUt(String _navn){
		if(!utlaant){
			utlaant = true;
			laaner = _navn;
		} else
			System.out.println("Boken er laant ut allerede");
	}
	public void leverTilbake(){
		if(utlaant){
			laaner = null;
			utlaant = false;
		} else
			System.out.println("Boken er ikke laant ut! ");
	}
	public String toString(){return tittel;}
	public String getForfatter(){return forfatter;}
	
}