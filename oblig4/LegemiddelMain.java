public class LegemiddelMain{
	public static void main(String[] args){
		legemiddelTest();
		System.out.println("******************");
		legeOgPasientTest();
		System.out.println("******************");
	}
	public static void legemiddelTest(){
		Legemiddel[] medisin = new Legemiddel[3];
		medisin[0] = new Apreparat("Metadon", 130.0, 100.3, 3);
		System.out.println(medisin[0].hentNummer());
		medisin[1] = new Bpreparat("codein", 130.2, 100.3, 2);
		System.out.println(medisin[1].hentNummer());
		medisin[2] = new Cpreparat("paracet", 40.5, 100.3);
		System.out.println(medisin[2].hentNummer());
		Apreparat morfin = new Apreparat("Morfin", 200.0, 100.3, 3);
		System.out.println(morfin.hentNummer());
	}
	public static void legeOgPasientTest(){
		Legemiddel medisin = new Apreparat("Metadon", 130.0, 100.3, 3);
		Lege lege1 = new Lege("Hans");
		test(lege1.samme("Hans"), true, " om Hans er samme navn");
		Pasient peter = new Pasient("Peter Killingstad", "26079049343", "Torggata 36A", "0183");
		Resept blaaResept = new BlaaResept(medisin, lege1, peter, 1);
		test(blaaResept.gyldigResept(), true, "tester om resepten er gyldig");
		System.out.println(blaaResept.toString());
		blaaResept.brukResept();
		test(blaaResept.gyldigResept(), false, "tester en tom resept om den er gyldig");
		System.out.println(peter.toString());
	}
	
	public static void test(boolean _testKall, boolean _expected, String _message){
		if(_testKall == _expected){
			System.out.printf("Tester %s: %b  OK\n", _message, _expected);
		}else{
			System.out.printf("Tester %s: huff da.....!  Forventet %b, fikk %b\n", _message, _expected, _testKall);
		}
	}
}