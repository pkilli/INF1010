class Oblig2{
	public static void main(String[] args){
		Hylle<Bok> bokHylle = new Hylle<Bok>(100);
		testHylle(bokHylle);
	
	}
	public static void testHylle(Hylle<Bok> _bokHylle){
		Bok lotr	= new Bok("LOTR", "Tolkien");
		Bok lotr2	= new Bok("LOTR", "Tolkien");
		Bok bigjava	= new Bok("Big Java", "Horstmann");
		Bok HP	= new Bok("Harry Potter", "J.K. Rowling");
		
		
		
		System.out.println("---------------------------------");
		System.out.println("***Test av bokhylle*** ");
		System.out.println("Satt inn bok. Det skal ikke vaere plass der: ");
		_bokHylle.settInn(lotr, 0);
		boolean ledig = _bokHylle.ledigPlass(0);
		testErLedig(ledig);
		
		System.out.println("prover aa sett en inn lik bok. \n(Trenger ikke fler av samme bok)\nDet skal vaere plass:");
		_bokHylle.settInn(lotr2, 1);
		ledig = _bokHylle.ledigPlass(1);
		testErLedig(ledig);

		System.out.println("Tatt ut bok. ");
		System.out.println("boken som er tatt ut er: " + _bokHylle.taUt(lotr, 0));
		ledig = _bokHylle.ledigPlass(0);
		System.out.println("Det skal vaere plass der: ");
		testErLedig(ledig);
		
		System.out.println("Setter inn bok utenfor hyllen ");
		System.out.println("Det skal ikke vaere noen plass: ");
		ledig = _bokHylle.settInn(bigjava, 100);
		testErLedig(ledig);

		

	}
		
		
	static void testErLedig(boolean _ledig){
		if(_ledig){
			System.out.println("*** -> Det er plass <- ***");
		}else
			System.out.println("*** -> Det er ikke plass <- ***");
	}
}
