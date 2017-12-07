import java.util.*;
public class TestOblig6{
	public static void main(String[] args){
		System.out.println(">>>>>tester EnkelReseptListe med Yngste/EldsteForst<<<<<");
		testEnkelReseptListe();
		System.out.println(">>>>>tester SortertEnkelListe<<<<<");
		testSortertEnkelListe();
	}
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
	public static void testEnkelReseptListe(){
		/*test("Test nr. 01 (null==null)", null, null );
		
		EnkelReseptListe li_1 = new EldsteForstReseptListe();
		EnkelReseptListe li_2 = new YngsteForstReseptListe();
		Iterator<Resept> eldsteIterator = li_1.iterator();
		Iterator<Resept> yngsteIterator = li_2.iterator();
		
		li_1.settInn(new Resept()); //0
		li_1.settInn(new Resept()); //1
		li_1.settInn(new Resept()); //2
		Resept a = new Resept();
		li_1.settInn(a); //3
		
		li_2.settInn(new Resept()); //4
		li_2.settInn(new Resept()); //5
		li_2.settInn(new Resept()); //6
		li_2.settInn(new Resept()); //7
		li_2.settInn(new Resept()); //8
		test("Test nr. 02 Sjekker om Eldste er forst(plass 0 har reseptnummer 0) ", 0, eldsteIterator.next().getReseptNummer() );
		
		test("Test nr. 03 Sjekker om yngste er forst(plass 0 har reseptnummer 8) ", 8, yngsteIterator.next().getReseptNummer());
		
		System.out.println(">>tester aa skrive hele Yngste listen med loekke<<");
		for(Resept r : li_2){
			System.out.println(r.getReseptNummer());
		}
		/*
		try{a = li_1.finnObjekt(3);}
		catch(ReseptUnntak e){
			System.out.println("feil nr 004 " + e.getMessage());
		}*/
		
		
	}
	public static void testSortertEnkelListe(){
		SortertEnkelListe<String> sortertLenkeliste = new SortertEnkelListe<String>();
		Iterator<String> sortertIterator = sortertLenkeliste.iterator();
		
		sortertLenkeliste.settInnForan(new String("hans"));
		sortertLenkeliste.settInnForan(new String("adam"));
		sortertLenkeliste.settInnForan(new String("kjell"));
		sortertLenkeliste.settInnForan(new String("aadam"));
		test("Test nr. 01 sjekker om aadam er foran adam ", "aadam", sortertIterator.next() );
		
		System.out.println(">>tester aa skrive hele listen med loekke<<");
		for(String a : sortertLenkeliste){
			System.out.println(a);
		}
		
	}
	public static void testTabell(){
		
		Tabell<String> t = new Tabell<String>(10);
		Iterator<String> li = t.iterator();
		
		t.settInn("hei", 0);
		t.settInn("paa", 1);
		t.settInn("deg", 2);
		
		while(li.hasNext()){
			System.out.println(li.next());
		}
		System.out.println("*********************");
		
		for(String a : t){
			System.out.println(a);
		}
	}
}