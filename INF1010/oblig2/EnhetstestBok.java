class EnhetstestBok{
	public static void main(String[] args){
		Bok lotr	= new Bok("LOTR", "Tolkien");
		Bok HP		= new Bok("Harry Potter","J.K.Rowling");
	}

		static void laan(Bok _tittel, String _navn){
			_tittel.laanUt(_navn);
		}
}