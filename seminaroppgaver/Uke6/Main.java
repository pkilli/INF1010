class Main { 
 	public static void main(String[] args) { 
 		 
 		Lenkehistorie frozen = new Lenkehistorie(); 
 		frozen.nyttKapittel(new Kapittel(1, "Anna drar avgaarde")); 
 		frozen.nyttKapittel(new Kapittel(2, "Hesten roemmer")); 
 		frozen.nyttKapittel(new Kapittel(3, "Kommer til hytta og moeter Kristoffer")); 
 		frozen.nyttKapittel(new Kapittel(4, "Ulver jager dem")); 
		 
 		for(Kapittel k : frozen) { 
 			System.out.println(k); 
 		} 
 		 
 		frozen.slettStorste(); 
 		 
 		for(Kapittel k : frozen) { 
 			System.out.println(k); 
 		} 
	} 
} 
