public class Mat implements Avgiftsbar{
	private String varenavn;
	private double bruttopris;
	
	public Mat(String varenavn, double pris){
		this.varenavn = varenavn;
		this.bruttopris = pris;
	}
	public double pris()	{return this.bruttopris;}
	public double avgift()	{return this.bruttopris*0.11;}
	public String toString(){return this.varenavn;}
}