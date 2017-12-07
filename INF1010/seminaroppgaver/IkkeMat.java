public class IkkeMat implements Avgiftsbar{
	private String varenavn;
	private double bruttopris;
	
	public IkkeMat(String varenavn, double bruttopris){
		this.varenavn = varenavn;
		this.bruttopris = bruttopris;
	}
	public double pris()	{return this.bruttopris;}
	public double avgift()	{return this.bruttopris*0.25;}
	public String toString(){return this.varenavn;}
}