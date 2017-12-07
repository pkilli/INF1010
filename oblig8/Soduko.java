import java.util.*;
import java.io.*;

public class Soduko{
	private Brett brett;
    private static char TOM_RUTE_TEGN = '.';
	private String filnavn;
    private String utfilnavn;
    
    public Soduko(String filnavn, String utfilnavn){
        this.filnavn = filnavn;
        this.utfilnavn = utfilnavn;
        lesFil(filnavn);
    }
	private int parseInt(String value)
	{
		int ret = -1;
		try
		{
			ret = Integer.parseInt(value);
		}
		catch(NumberFormatException e)
		{
			System.out.println("feil format paa tall");
		}
		return ret;
	}
	public Brett lesFil(String data)
	{
		Brett tmp = null;
		int boksHoyde = 0;
		int boksBredde = 0;
		List<Rute> ruteVerdi;
		int stoerrelse;
		try
		{
		Scanner in = new Scanner(new File(data));
		boksHoyde = parseInt(in.nextLine());
		boksBredde = parseInt(in.nextLine());
		ruteVerdi = new ArrayList<Rute>();
		stoerrelse = (boksHoyde*boksBredde);
		int antRuter = stoerrelse*stoerrelse;
        
		while(in.hasNext())
		{
			String[] n = in.nextLine().split("|");
            char c;
            int verdi = 0;
			for(int i = 0;i<n.length;i++){
                c = n[i].charAt(0);
                verdi = tegnTilVerdi(c);
                if(verdi == 0)
                    ruteVerdi.add(new VariabelRute(verdi));
                else
                    ruteVerdi.add(new FastRute(verdi));
            }
		}
		if(ruteVerdi.size() != antRuter)
		{
			System.out.println("feil paa brettet");
		}
		tmp = new Brett(ruteVerdi, boksHoyde, boksBredde);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("fant ikke filen");
		}
		return tmp;
	}
    
    /**
     * Oversetter et tegn (char) til en tallverdi (int)
     *
     * @param tegn      tegnet som skal oversettes
     * @return          verdien som tegnet tilsvarer
     */
    public int tegnTilVerdi(char tegn) {
        if (tegn == TOM_RUTE_TEGN) {                // tom rute
            // DENNE KONSTANTEN MAA DEKLARERES
            return 0;
        } else if ('1' <= tegn && tegn <= '9') {    // tegn er i [1, 9]
            return tegn - '0';
        } else if ('A' <= tegn && tegn <= 'Z') {    // tegn er i [A, Z]
            return tegn - 'A' + 10;
        } else if (tegn == '@') {                   // tegn er @
            return 36;
        } else if (tegn == '#') {                   // tegn er #
            return 37;
        } else if (tegn == '&') {                   // tegn er &
            return 38;
        } else if ('a' <= tegn && tegn <= 'z') {    // tegn er i [a, z]
            return tegn - 'a' + 39;
        } else {                                    // tegn er ugyldig
            return -1;
        }
    }

}