public class Boks extends BrettDeler{
	private static int teller;
	private int boksnummer = 0;
	public Boks(Brett brett)
	{
        super(brett);
		boksnummer = teller++;
	}
	public int hentNummer(){return boksnummer;}
    
	public String toString(){return " boksnummer: " + boksnummer;}
}