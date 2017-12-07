class Oblig1{
	public static void main(String[] args){
		Bol<Mus> musebol = new Bol<Mus>();
		Bol<Rotte> rottebol = new Bol<Rotte>();
		Katt tom = new Katt("Tom");
		tom.jakt(musebol, rottebol);
		Rotte ronny = new Rotte("Ronny");
		rottebol.settInn(ronny);
		tom.jakt(musebol, rottebol);
		Mus jerry = new Mus("Jerry");
		musebol.settInn(jerry);
		Mus geir = new Mus("Geir");
		musebol.settInn(geir);
		tom.jakt(musebol, rottebol);
	}
}