import java.util.*;
import java.io.*;
public class InnlesningAvBil{
	private ArrayList<Bil> alleBiler;
	private String arkiv;
	public InnlesningAvBil() throws Exception{
		System.out.println("*** Hvilken fil skal leses? ***");
		alleBiler = new ArrayList<Bil>();
		Scanner s = new Scanner(System.in);
		arkiv = s.nextLine();
	}
	/* 
	leser av et bilarkiv.
	foerste bokstav paa hver linje definerer hvilket objekt det er
	*/
	public void lesArkiv() throws Exception{
		String bilnummer="", utslipp="", passasjerer="", kw="", lastenytte="", tmp="";
		Scanner s = new Scanner(new File(arkiv));
		while(s.hasNextLine()){
			tmp = s.next();
			if(tmp.charAt(0) == 'B'){
				bilnummer = s.next();
				alleBiler.add(new Bil(bilnummer));
			}
			else if(tmp.charAt(0) == 'E'){
				bilnummer = s.next();
				kw = s.next();			
				alleBiler.add(new Elbil(bilnummer, Integer.parseInt(kw)));
			}
			else if(tmp.charAt(0)== 'F' || tmp.charAt(0)== 'P' || tmp.charAt(0)== 'L'){
				bilnummer = s.next();
				utslipp = s.next();
				if(tmp.charAt(0)== 'P'){
					passasjerer = s.next();
					alleBiler.add(new Personbil(bilnummer, Double.parseDouble(utslipp), Integer.parseInt(passasjerer)));
				}
				else if(tmp.charAt(0)== 'L'){
					lastenytte = s.next();
					alleBiler.add(new Lastebil(bilnummer, Double.parseDouble(utslipp), Double.parseDouble(lastenytte)));
				} 
				else
					alleBiler.add(new Fossilbil(bilnummer, Double.parseDouble(utslipp)));
			}
		}
	}
	/*
	skriver ut info om Fossilbiler som ligger i arrayList
	*/
	public void skrivArkiv(){
		System.out.println("***Kort info om fossilbilene***");
		for(Bil bil: alleBiler){
			if(bil instanceof Fossilbil || bil instanceof Elbil)
				System.out.println(bil.kortInfo());
		}
	}

}