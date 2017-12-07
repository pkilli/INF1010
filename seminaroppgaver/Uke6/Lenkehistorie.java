import java.util.Iterator; 
 
 class Lenkehistorie implements Iterable<Kapittel> { 
 
 	private Node forste; 
 	 
 	public void nyttKapittel(Kapittel kap) { 
 		Node ny = new Node(kap); 
 		Node midl = forste; 
 		 
 		if(midl == null) { 
 			forste = ny; 
 		} else { 
 			while(midl.neste != null) { 
 				midl = midl.neste; 
 			} 
 			midl.neste = ny; 
 		} 
 	} 
 	 
 	public void skrivHistorie() { 
 		Node midl = forste; 
 		if(forste == null) { 
 			System.out.println("=== Historien er tom ==="); 
 		} else { 
 			while(midl != null) { 
 				System.out.println(midl.kapittel); 
 				midl = midl.neste; 
 			} 
 		} 
 	} 
 	 
 	public void slettStorste() { 
 		if(forste != null) { 
 			Kapittel storst = forste.kapittel; 
 			int storstIdx = storst.getNummer(); 
 			 
 			for(Kapittel k : this) { 
 				if(storst.compareTo(k) > 0) { 
 					storst = k; 
 					storstIdx = k.getNummer(); 
 				} 
 			} 
 			System.out.println(storstIdx); 
 			fjern(storstIdx); 
 		} 
 	} 
 	 
 	public boolean fjern(int index) { 
 		Node midl = forste; 
 		 
 		if(midl == null) { 
 			return false; 
 		} 
 		 
 		if(midl.minIndex == index) { 
 			forste = midl.neste; 
 			return true; 
 		} 
 		 
 		while(midl.neste != null) { 
 			if(midl.neste.minIndex == index) { 
 				midl.neste = midl.neste.neste; 
 				return true; 
 			} 
 			 
 			midl = midl.neste; 
 		} 
 		 
 		return false; 
 		 
 	} 
 	 
 	public Iterator iterator() { 
 		return new HistorieIterator(); 
 	} 
 	 
 	public class HistorieIterator implements Iterator<Kapittel> { 
 	 
 		Node midl = forste; 
 		 
 		public boolean hasNext() { 
 			if(midl == null) { 
 				return false; 
 			} 
 			return true; 
 		} 
 		 
 		public Kapittel next() { 
 			Kapittel ret = midl.kapittel; 
 			midl = midl.neste; 
 			return ret; 
 		} 
 		 
 		public void remove() { 
 			throw new UnsupportedOperationException(); 
 		} 
 	} 
	 
 	private class Node { 
 		int minIndex; 
 		Kapittel kapittel; 
 		Node neste; 
 		 
 		public Node(Kapittel kapittel) { 
 			minIndex = kapittel.getNummer(); 
 			this.kapittel = kapittel; 
 			System.out.println(this.minIndex); 
 		} 
	} 
} 
