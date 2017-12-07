public class EldsteForstReseptListe extends EnkelReseptListe{
	
	public void settInn(Resept _resept){
		Node ny = new Node(_resept); 
 		Node midl = foran.neste; 
 		 
 		if(midl == null) { 
 			foran.neste = ny; 
 		} else { 
 			while(midl.neste != null) { 
 				midl = midl.neste; 
 			} 
 			midl.neste = ny; 
 		} 
	}
}