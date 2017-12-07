public class TestLenkeliste{
	public static void main(String[] args){
		LenkeListe<String> lenkeliste = new LenkeListe<String>();
		lenkeliste.leggTil("vi");
		lenkeliste.leggTil("er");
		lenkeliste.leggTil("paa flyet.");
		lenkeliste.skrivUt();
	}
}