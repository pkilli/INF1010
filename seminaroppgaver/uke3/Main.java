class Main{
	public static void main(String[] args){
		AlkoholholdigDrikke vin;
		vin = new Roedvin("Amarone della Valpolicella ", 0.15 , 2005, true);
		String a = vin.kortInfo();
		Flaske<AlkoholholdigDrikke> vinflaske = new Flaske<AlkoholholdigDrikke>(750);
		Student peter = new Student("Peter");
		vinflaske.fyllMed(vin);
		System.out.println(peter.hentNavn() + a);
		System.out.println(vinflaske.hentInnhold());
		
		peter.drikkAv(vinflaske);
		
		test(peter.kanKjoere(), false, " om studenten kan kjoere etter roedvin");	
		System.out.println("-----------------------------------");
		
		vin = new Hvitvin("En hvitvin ", 0.12 , 2003, true);
		a = vin.kortInfo();
		System.out.println(peter.hentNavn() + " " + a);
		vinflaske.fyllMed(vin);
		peter.drikkAv(vinflaske);
		test(peter.kanKjoere(), false, " om studenten kan kjoere etter roedvin");
		
		Vin vin1 = new Roedvin("Amarone della Valpolicella ", 0.15 , 2005, true);
		Flaske<Vin> nyVinflaske = new Flaske<Vin>(750);
		
		
	}
	
	
	public static void test(boolean _testKall, boolean _expected, String _message){
		if(_testKall == _expected){
			System.out.printf("Tester %s: %b  OK\n", _message, _expected);
		}else{
			System.out.printf("Tester %s: huff da.....!  Forventet %b, fikk %b\n", _message, _expected, _testKall);
		}
	}
}
