import java.util.ArrayList;
public class Rute{
	protected int verdi;
	protected Boks boks;
	protected Kolonne kolonne;
	protected Rad rad;
    protected Rute neste = null;

	public Rute(int _verdi){
		this.verdi = _verdi;
	}
	public String toString(){return "verdi: "+verdi+boks+","+kolonne+","+rad;}
    
    public int hentVerdi(){
        return this.verdi;
    }
    
    public void settVerdi(int i){
        this.verdi = i;
    }

    
    public void settNeste(Rute r){
        this.neste = r;
        }

	public void setKolonne(Kolonne k){
        //k.settInn(this);
		this.kolonne = k;
	}
    
	public void setRad(Rad r){
        //r.settInn(this);
		this.rad = r;
	}
    
	public void setBoks(Boks b){
        //b.settInn(this);
		this.boks = b;
	}
    
    public Rad hentRad(){return this.rad;}
    
    public Rute hentNeste(){
        return this.neste;
    }
    public void fyllUtDenneOgResten(){
 
        this.rad.hentBrett().toemBrett(this);
    }
}