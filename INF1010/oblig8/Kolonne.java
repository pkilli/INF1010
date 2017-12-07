public class Kolonne extends BrettDeler{
	private static int teller;
	private int kolonnenummer = 0;
	public Kolonne(Brett brett)
	{
        super(brett);
		kolonnenummer = teller++;
	}
	public int hentNummer(){return kolonnenummer;}
	
	public String toString(){return " kolonnenummer: " + kolonnenummer;}
}