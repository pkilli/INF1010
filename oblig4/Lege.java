public class Lege implements Lik, Comparable<Lege>{
	protected String navn;
	
	public Lege(String _navn){
		navn = _navn;
	}
	
	public boolean samme(String _verdi){
		boolean ret = false;
		if(navn != null){
			if(navn.equals(_verdi))
					ret = true;
			}	
		return ret;
	}
	public String toString(){return navn;}
}
