public class Flaske<D> implements DrikkeBeholder<D>{
	private D innhold;
	private int kapasitet;
	
	public Flaske(int _kapasitet){
		kapasitet = _kapasitet;
	} 
	
	public int hentKapasitet(){return kapasitet;}
	public void fyllMed(D _innhold){
		if(innhold != null){
			toem();
			innhold = _innhold;
		}
		else
			innhold = _innhold;
	}
	public D toem(){
		D ret = innhold;
		innhold = null;
		return ret;
	}
	public D hentInnhold(){return innhold;}
}
