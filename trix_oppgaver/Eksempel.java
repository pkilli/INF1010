import java.util.* ;
class EksempelR  {

    public static <T> void test(String beskrivelse, T forventet, T faktisk) {
	if (forventet != null && forventet.equals(faktisk)) {
	    System.out.printf("OK - %s%n", beskrivelse);
	} else if (forventet == faktisk) {
	    System.out.printf("OK - %s%n", beskrivelse);
	} else {
	    System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
			      beskrivelse,
			      forventet,
			      faktisk);
	}
    }

    public static void main (String[] a) {
	Lenkeliste<Katt> lenkeli = new Lenkeliste<Katt>(); 
	Iterator<Katt> li = lenkeli.iterator(); 
	test("Tester hasNext()", false, li.hasNext() );

	lenkeli.settInnForan(new Katt("Pus"));
	lenkeli.settInnForan(new Katt("Tom"));
	lenkeli.settInnForan(new Katt("Arne Belinda"));
	lenkeli.settInnForan(new Katt("Tigern"));
	lenkeli.settInnForan(new Katt("Sonja"));
	lenkeli.skrivAlle();

	li = lenkeli.iterator();
	test("Tester hasNext()", true, li.hasNext() );

	Katt k = null;

	if (li.hasNext()) k = li.next();
	test("Tester iteratorens next()", "Sonja", k.navn);
	
	if (li.hasNext()) k = li.next();
	test("Tester iteratorens next()", "Tigern", k.navn);

	if (li.hasNext()) k = li.next();
	test("Tester iteratorens next()", "Arne Belinda", k.navn);

	if (li.hasNext()) k = li.next();
	System.out.println("Fikk dette objektet av iteratoren (som skal fjernes): " + k);

	li.remove();

	lenkeli.skrivAlle();

	System.out.println("ITERATORTEST:");
	while (li.hasNext()) {
	    li.next(); li.remove();
	    lenkeli.skrivAlle();
	    System.out.println("-----------");
	}

	test("Tester hasNext()", true, li.hasNext() );

	lenkeli = new Lenkeliste<Katt>();
        for (int i=0; i < 3; i++) {
	    lenkeli.settInnForan(new Katt("Pus"));
	    lenkeli.settInnForan(new Katt("Tom"));
	    lenkeli.settInnForan(new Katt("Arne Belinda"));
	    lenkeli.settInnForan(new Katt("Tigern"));
	    lenkeli.settInnForan(new Katt("Sonja"));
	}

	lenkeli.skrivRek();
	
	for (Katt kk : lenkeli) {
	    System.out.println(kk.toString());
	}


	

	li = lenkeli.iterator(); // et NYTT iteratorobjekt

	System.out.println("SISTE TEST:");
	li.remove(); // Skal gi feilmelding
	/*
	for (Lenkeliste<Katt>.ListeIterator lsti = lenkeli.iterator();
	     lsti.hasNext();
	     lsti.next() )
	   {
	        lsti.remove();
		lenkeli.skrivAlle();
		System.out.println("-----------");
	   }
	*/

	while (li.hasNext()) {
	    li.next();
	    li.remove();
	}
	
	test("Tester hasNext() nÃ¥r lista er tÃ¸mt.", false, li.hasNext() );
	
    }
}

class Katt implements Comparable<Katt> {
    String navn;    
    Katt (String n) { navn = n; }

    @Override public String toString() {
	return "Katteobjekt med navn = Â«" + navn + "Â»";
    }

    public int compareTo(Katt k) { return 1; }
}

/*
interface Iterator<T> {
    public boolean hasNext();
    public T next();
    public void fjern() ; 
} 
*/   

class Lenkeliste<T> implements Iterable<T> {

    private Node lh = null ; // listehode

    private class Node {
	T data ;
	Node neste = null ;
	
	Node (T s) {
	    data = s;
	}

	void skriv() {
	    if (neste != null) neste.skriv();
	    System.out.println("Rekursiv utskrift av objektet: " + data.toString() );
	}
    }

    Lenkeliste() {
	lh = new Node(null);
	// lh.neste peker nÃ¥ pÃ¥ detforan fÃ¸r pekte pÃ¥
    }

    public Iterator<T> iterator() { 
	return new ListeIterator ();
    }

	
    public class ListeIterator implements Iterator<T> {
	
	final static int TILSTAND_A = 0;
	final static int TILSTAND_B = 1;
	
	int tilstand = TILSTAND_A; // Ã©n av de to ovenfor

	Node pos = lh;

	public boolean hasNext() { return (tilstand == TILSTAND_A && pos.neste != null)
		                       || (tilstand == TILSTAND_B && pos.neste.neste != null); }

	public T next() {
		if (tilstand == TILSTAND_A) ;  // ikke flytt pos
		else pos = pos.neste;	    
		tilstand = TILSTAND_B;
		return pos.neste.data;
	}

	public void remove() {
	    
	    /* fjerner den siste som ble henta, dvs. pos.neste;
	    // men bare dersom et objekt er henta siden
	    // forrige gang fjern ble kalt */
	    
	    if ( tilstand == TILSTAND_B) {
		pos.neste = pos.neste.neste; // hopper over pos.neste
		tilstand = TILSTAND_A;
	    } else System.out.println("Feil kall pÃ¥ remove()");
	}	


    }  

    public void settInnForan(T o) {
	Node temp = new Node(o) ;
	temp.neste = lh.neste ;
	lh.neste = temp ;
	System.out.println("Satt inn: " + o.toString());
    }

    public T taUtForan() {
        Node ut = lh.neste;
	lh.neste = lh.neste.neste;
	System.out.println("Tar ut: " + ut.data.toString());
	return ut.data;
    }


    public void skrivAlle() {
	Node iter = lh.neste;
	while ( iter != null ) {
	    System.out.println(iter.data.toString());
	    iter = iter.neste;
	}
    }

    public void skrivRek() {
	if (lh.neste != null) lh.neste.skriv();
    }
}