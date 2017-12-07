class Kapittel implements Comparable<Kapittel> { 
 	private int nummer; 
 	private String tekst; 
 	 
 	public Kapittel(int nr, String tekst) { 
 		this.nummer = nr; 
 		this.tekst = tekst; 
 	} 
	 
 	public int getNummer() { 
 		return nummer; 
 	} 
 	 
 	public String getTekst() { 
 		return tekst; 
 	} 
 	 
 	public String toString() { 
 		return nummer + ": " + tekst; 
 	} 
 	 
 	public int compareTo(Kapittel kap) { 
 		return kap.nummer - this.nummer; 
 	} 
} 
