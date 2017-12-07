import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Oblig7
{
	private static Tabell<Legemiddel> legemiddelTabell = new Tabell<Legemiddel>(100);
	private static Tabell<Pasient> pasientTabell = new Tabell<Pasient>(100);
	private static SortertEnkelListe<Lege> legeListe = new SortertEnkelListe<Lege>();
	private static EnkelReseptListe reseptListe = new EldsteForstReseptListe();
	private static Scanner tastatur = new Scanner(System.in);
	
	private static void finnMedisinskMisbruk()
	{
		System.out.println(">>Liste over leger som har skrevet ut en eller fler narkotiske resepter<<");
		for(Lege l: legeListe)
		{
			if(l.hentAntallNarkotiskeResepter() >= 1)
			{
				System.out.print(l);
				System.out.println(", antall: " + l.hentAntallNarkotiskeResepter());
			}
		}
		System.out.println("----------------------------------------------------------");
		System.out.println(">>Liste over pasienter med gyldige narkotiske resepter<<");
		for(Pasient p : pasientTabell)
		{
			if(p.hentAntallGyldigeNarkotiskeResepter() > 0)
			{
				System.out.print(p.hentNavn());
				System.out.println(", antall: "+ p.hentAntallGyldigeNarkotiskeResepter());
			}
				
		}
		
	}
	
	private static void legeOversikt()
	{
		String legefrabruker = hentInput("legens navn");
		boolean legeOK = false;
		Lege lege=null;
		for (Lege l : legeListe)
		{
			if( l.samme(legefrabruker))
			{
				legeOK = true;
				lege = l;
			}
		}
		if(legeOK)
			lege.skrivMiksturPreparater();
		else
			System.out.println("Ingen lege ved det navnet registrert");
	}
	
	private static void skrivPasientSineBlaaResepter()
	{
		String pasientInput = hentInput("oppgi foedselsnummer");
		boolean PasientOK = false;
		Pasient pasient = null;
		for(Pasient p: pasientTabell)
		{
			if(p.samme(pasientInput))
			{
				PasientOK = true;
				pasient = p;
			}
		}
		if(PasientOK)
			pasient.skrivUtBlaaResepter();
		else
			System.out.println("ingen registrert med det foedselsnummeret");
	}
	
	private static void hentStatestikOverVanedannendeResepter()
	{
		int antallVanedannendeResepter = 0;
		int antallBoendeIOslo = 0;
		for(Resept resept : reseptListe)
		{
			if( resept instanceof BlaaResept)
				antallVanedannendeResepter++;
			String postnummer = resept.hentPasientPostnummer();
			if(postnummer.startsWith("0")||postnummer.startsWith("10")||postnummer.startsWith("11")||postnummer.startsWith("12"))
				antallBoendeIOslo++;
		}
		System.out.println("Totale Antallet vanedannende resepter: "+antallVanedannendeResepter);
		System.out.println("Antallet av disse som bor i Oslo: "+ antallBoendeIOslo);
	}
	
	private static void hentLegemiddelPaaResept()
	{
		String foedselsnummer = hentInput("pasientens foedselsnummer");
		String reseptnummerFraBruker = hentInput("reseptnummeret");
		boolean foedselsnummerOK = false;
		Pasient pasient = null;
		int reseptnummer = 0;
				try
		{
			reseptnummer = Integer.parseInt(reseptnummerFraBruker);
		}
		catch (NumberFormatException e)
		{
			System.out.println("feil reseptnummer. maa skrive et nummer.");
			return;
		}
		for(Pasient p : pasientTabell)
		{
			if(p.samme(foedselsnummer))
			{
				foedselsnummerOK = true;
				pasient = p;
			}
		}
		if(foedselsnummerOK)
			pasient.hentLegemiddel(reseptnummerFraBruker);
		else
		{
			System.out.println("ingen registrert pasient");
			return;
		}	
	}
	
	private static void lagReseptFraBruker()
	{
		//(nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)
		String form = hentInput("form paa resepten(blaa/hvit)");
		String pasientNummer = hentInput("pasientnummer");
		String legenavn = hentInput("legens navn");
		String legemiddelNummer = hentInput("Legemiddelnummer");
		String reit = hentInput("oppgi reit");
		int tmp = 0;
		String data = String.format("%d, %s, %s, %s, %s, %s", tmp, form, pasientNummer, legenavn, legemiddelNummer, reit);
		lagResept(data);
	}
	
	private static void lagLegeFraBruker()
	{
		String navn = hentInput("navn");
		for(Lege lege : legeListe)
		{
			if(lege.samme(navn))
			{
				System.out.println("det er en lege med det navnet");
				return;
			}
		}
		String avtale = hentInput("avtale(0 hvis ingen)");
		String data = String.format("%s, %s", navn,avtale);
		lagLege(data);
	}
	
	private static void lagPasientFraBruker()
	{
		//(nr, navn, fnr, adresse, postnr)
		String navn = hentInput("Pasientens navn");
		String fnr = hentInput("foedselsnummer");
		for(Pasient pasient : pasientTabell)
		{
			if(pasient.samme(fnr))
			{
				System.out.println("Personen eksisterer allerde");
				return;
			}
				
		}
		String adresse = hentInput("adresse");
		String postnr = hentInput("postnummer");
		int plass = pasientTabell.ledigPlass();
		String data = String.format("%d, %s, %s, %s, %s ", plass,navn,fnr,adresse,postnr);
		lagPerson(data);
	}
	
	private static void lagLegemiddelFraBruker()
	{
		String navn = hentInput("navnet paa legemiddelet");
		String form = hentInput("form paa legemiddelet(mikstur/pille)");
		String type = hentInput("type legemiddel(a/b/c-preparat)");
		String pris = hentInput("pris");
		String antall = hentInput("antall piller eller mengde av mikstur");
		String virkestoff = hentInput("mengde virkestoff");
		String styrke = hentInput("styrke eller avhengighetsgrad");
		int plass = 0;
		try
		{
			plass = legemiddelTabell.ledigPlass();
		}
		catch(NumberFormatException e)
		{
			System.out.println("ingen ledig plass");
		}
		String data = String.format("%d, %s, %s, %s, %s, %s, %s, %s", plass,navn,form,type,pris,antall,virkestoff,styrke);
		lagLegemiddel(data);
	}
	
	private static void skrivUtInfo()
	{
		System.out.println("# Personer (nr, navn, fnr, adresse, postnr)");
		for(Pasient p : pasientTabell)
			System.out.println(p);
		System.out.println("");
		
		System.out.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");
		for(Legemiddel l : legemiddelTabell)
			System.out.println(l);
		System.out.println("");
		
		System.out.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
		for(Lege lege : legeListe)
			System.out.println(lege.hentInfo());
		System.out.println("");
		
		System.out.println("# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)");
		for(Resept resept : reseptListe)
			System.out.println(resept);
		System.out.println("");
		
		System.out.println("# Slutt");
		System.out.println("");
		
	}
	
	private static void kommandoloekke()
	{
		skrivMeny();
		String kommando = hentInput("Kommando");
		while(!kommando.equals("q"))
		{
			if(kommando.equals("h"))
				skrivMeny();
			else if(kommando.equals("1"))
			{
				skrivUtInfo();
			}
			else if(kommando.equals("2"))
			{
				lagLegemiddelFraBruker();
			}
			else if(kommando.equals("3"))
			{
				lagPasientFraBruker();
			}
			else if(kommando.equals("4"))
			{
				lagLegeFraBruker();
			}
			else if(kommando.equals("5"))
			{
				lagReseptFraBruker();
			}
			else if(kommando.equals("6"))
			{
				hentLegemiddelPaaResept();
			}
			else if(kommando.equals("7"))
			{
				hentStatestikOverVanedannendeResepter();
			}
			else if(kommando.equals("8"))
			{
				skrivPasientSineBlaaResepter();
			}
			else if(kommando.equals("9"))
			{
				legeOversikt();
			}
			else if(kommando.equals("10"))
			{
				finnMedisinskMisbruk();
			}else
				skrivMeny();
			System.out.println("*******************************");
			System.out.println("Hva vil du gjoere?(enter for meny)");
			kommando = hentInput("Kommando");
			
		}
		
	}
	
	private static String hentInput(String _forklaring)
	{
		System.out.println(_forklaring + ": ");
		return tastatur.nextLine();
	}
	
	private static void skrivMeny()
	{
		System.out.println("===================================");
		System.out.println(">>>Kommandoer<<<");
		System.out.println("h  -  ");
		System.out.println("1  -  Skriv ut info ");
		System.out.println("2  -  Nytt Legemiddel ");
		System.out.println("3  -  Ny Pasient ");
		System.out.println("4  -  Ny Lege ");
		System.out.println("5  -  Ny Resept ");
		System.out.println("6  -  Hent Legemiddel paa Resept ");
		System.out.println("7  -  Oversikt over vanedannende legemidler, \n      samt antallet av disse i Oslo");
		System.out.println("8  -  Skriv en Pasient sine Blaa Resepter ");
		System.out.println("9  -  Skriv en Leges Resepter paa Mikstur \n      og samlet mengde virkestoff paa alle Resepter");
		System.out.println("10 -  Finn medisinsk misbruk");
		System.out.println("q  -  Avslutt program");
		System.out.println("===================================");
	}
	
	private static void lagPerson(String _data)
	{		
		String[] info = _data.split(", ");
		int plass = Integer.parseInt(info[0]);
		String navn = info[1];
		String fodselsnummer = info[2];
		String adresse = info[3];
		String postnummer = info[4];
		pasientTabell.settInn(new Pasient(navn,fodselsnummer,adresse,postnummer), plass);
	}
	
	private static void lagLegemiddel(String _data)
	{
		String[] info = _data.split(", ");
		int plass = 0;
		String navn = info[1];
		String form = info[2];
		String type = info[3];
		double pris = 0;
		double antall = 0;
		double virkestoff = 0;
		try
		{
			plass = Integer.parseInt(info[0]);
			pris = Double.parseDouble(info[4]);
			antall = Double.parseDouble(info[5]);
			virkestoff = Double.parseDouble(info[6]);
		}
		catch (NumberFormatException e)
		{
			System.out.println(" plass, pris antall eller virkestoff er feil");
			return;
		}
		int styrke = 0;
		if(info.length == 8) 
			styrke = Integer.parseInt(info[7]);
		try
		{
			if(form.equals("mikstur"))
			{
				if(type.equals("a"))
				{
					//AprepMikstur(String _navn, double _pris, double _virkestoffMg, int _styrke, double _storrelseCm3)
					legemiddelTabell.settInn(new AprepMikstur(navn,pris,virkestoff,styrke,antall), plass);
				}
				else if(type.equals("b"))
				{
					//BprepMikstur(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, double _storrelseCm3)
					legemiddelTabell.settInn(new BprepMikstur(navn,pris,virkestoff,styrke,antall), plass);
				}
				else
				{
					//CprepMikstur(String _navn, double _pris, double _virkestoffMg, double _storrelseCm3)
					legemiddelTabell.settInn(new CprepMikstur(navn,pris,virkestoff,antall),plass);
				}
			}
		
			else if(form.equals("pille"))
			{
				if(type.equals("a"))
				{
					//AprepPille(String _navn, double _pris, double _virkestoffMg, int _styrke, int _antallPiller)
					legemiddelTabell.settInn(new AprepPille(navn,pris,virkestoff,styrke,antall),plass);
				}
				else if(type.equals("b"))
				{
					//BprepPille(String _navn, double _pris, double _virkestoffMg, int _avhengighetsGrad, int _antallPiller)
					legemiddelTabell.settInn(new BprepPille(navn,pris,virkestoff,styrke,antall),plass);
				}
				else
				{
					//CprepPille(String _navn, double _pris, double _virkestoffMg, int _antallPiller)
					legemiddelTabell.settInn(new CprepPille(navn,pris,virkestoff,antall), plass);
				}
			}
			else
			{
				System.out.println("Maa oppgi riktig form(pille/mikstur)");
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("array er full");
			return;
		}
	}
	
	private static void lagLege(String _data)
	{
		String[] info = _data.split(", ");
		String navn = info[0];
		int avtale = 0;
		try
		{
			avtale = Integer.parseInt(info[1]);
		}
		catch(NumberFormatException e)
		{
			System.out.println("avtalenummer er ikke riktig.");
			return;
		}
		if(avtale == 0)
		{
			//Lege(String _navn)
			legeListe.settInnForan(new Lege(navn));
		}
		else
		{
			legeListe.settInnForan(new Fastlege(navn, avtale));
		}
	}
	
	private static void lagResept(String _data)
	{
		String[] info = _data.split(", ");
		String typeResept = info[1];
		int persNummer = 0;
		String navnLege = info[3];
		int legeMiddelNummer = 0;
		int reit = 0;
		boolean legeOK = false;
		boolean pasientOK = false;
		boolean legemiddelOK = false;
		Lege lege = null;
		Pasient pasient = null;
		Legemiddel legemiddel = null;
		Resept resept = null;
		try
		{
			persNummer = Integer.parseInt(info[2]);
			legeMiddelNummer = Integer.parseInt(info[4]);
			reit = Integer.parseInt(info[5]);
		}
		catch (NumberFormatException e)
		{
			System.out.println("persNummer, legemiddellNummer eller reit er feil. Maa oppgi et nummer/tall");
			return;
		}
		
		for(Lege l:legeListe)
		{
			if(l.samme(navnLege))
			{
				lege = l;
				legeOK = true;
			}
		}
		for(Pasient p : pasientTabell)
		{
			if(p.hentNummer() == persNummer)
			{
				pasient = p;
				pasientOK = true;
			}
		}
		for(Legemiddel lmdl : legemiddelTabell)
		{
			if(lmdl.hentNummer() == legeMiddelNummer)
			{
				legemiddel = lmdl;
				legemiddelOK = true;
			}
		}
		if(legeOK && pasientOK && legemiddelOK)
		{
			if(typeResept.equals("blaa"))
			{
				//BlaaResept(Legemiddel _legemiddel, Lege _lege, Pasient _pasient, int _reit)
				resept = new BlaaResept(legemiddel,lege,pasient,reit);
			}
			else
			{
				//HvitResept(Legemiddel _legemiddel, Lege _lege, Pasient _pasient, int _reit)
				resept= new HvitResept(legemiddel,lege,pasient,reit);
			}
			reseptListe.settInn(resept);
			lege.settInnResept(resept);
			pasient.settInnResept(resept);
		}
		else if(!legeOK)
		{
			System.out.println("ikke riktig lege");
			return;
		}
		else if(! pasientOK)
		{
			System.out.println("Personen ikke registrert.");
			return;
		}
		else
		{
			System.out.println("Legemiddel ikke registrert.");
		}
	}
	
	private static boolean lesInnFil(String _filnavn)
	{
		try
		{
			Scanner innFil = new Scanner(new File(_filnavn));
			while(innFil.hasNextLine())
			{
				String linje = innFil.nextLine();
				if(linje.startsWith("# Personer"))
				{
					while(innFil.hasNextLine())
					{
						linje = innFil.nextLine();
						if(linje.length() == 0) break;
						lagPerson(linje);
					}
				}
				else if(linje.startsWith("# Legemidler"))
				{
					while(innFil.hasNextLine())
					{
						linje = innFil.nextLine();
						if(linje.length() == 0) break;
						lagLegemiddel(linje);
					}
				}
				else if(linje.startsWith("# Leger"))
				{
					while(innFil.hasNextLine())
					{
					linje = innFil.nextLine();
					if(linje.length() == 0) break;
					lagLege(linje);
					}
				}
				else if(linje.startsWith("# Resepter"))
				{
					while(innFil.hasNextLine())
					{
					linje = innFil.nextLine();
					if(linje.length() == 0) break;
					lagResept(linje);
					}
				}
				
			}
			return true;
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Fant ikke filen. ");
			
		}
		return false;
	}
	
	private static void skrivTilFil(String _filnavn)
	{
		try
		{
			PrintWriter utput = new PrintWriter(_filnavn);
			utput.print(tilFil());
			utput.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("fant ikke filen");
		}
		
	}
	public static String tilFil()
	{
		String pasient = "# Personer (nr, navn, fnr, adresse, postnr)\n";
		for(Pasient p : pasientTabell)
			pasient += p.toString() + "\n";
		String legemidler = "# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])\n";
		for(Legemiddel l : legemiddelTabell)
			legemidler += l.toString() + "\n";
		String leger = "# Leger (navn, avtalenr / 0 hvis ingen avtale)\n";
		for(Lege lege : legeListe)
			leger += lege.hentInfo()+"\n";
		String resept = "# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)\n";
		for(Resept r : reseptListe)
			resept += r.toString() + "\n";
		String slutt = "# Slutt";
		return pasient + "\n" + legemidler + "\n" + leger + "\n" + resept+ "\n"+slutt;
	}
	
	public static void main(String[] args)
	{
		String filnavn = "data.txt"; 
		lesInnFil(filnavn);
		kommandoloekke();
		skrivTilFil(filnavn);
	}
}