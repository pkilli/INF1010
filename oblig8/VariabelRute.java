import java.util.ArrayList;
public class VariabelRute extends Rute{
    
    VariabelRute(int verdi){
        super(verdi);
    }
    
    public void fyllUtDenneOgResten(){
        super.fyllUtDenneOgResten();
        int[] tall = this.finnAlleMuligeTall();
        
        for(int i = 1; i <= this.rad.hentStoerrelse(); i++){
            if(tall[i-1]!=0){
                this.settVerdi(tall[i-1]);
                if(this.neste != null){
                    this.neste.fyllUtDenneOgResten();
                }
            }
        }
        if(this.neste == null)
            this.rad.hentBrett().leggTilLoesning();
          
    }
    
    public int[] finnAlleMuligeTall(){
        
        int[] alleMuligeTall = new int[this.rad.hentStoerrelse()];
        
        for(int i = 1; i<=this.rad.hentStoerrelse();i++){
            if( !this.rad.harTallet(i) )
                if( !this.kolonne.harTallet(i) )
                    if( !this.boks.harTallet(i) )  
                        alleMuligeTall[i-1]=i;
        }
        return alleMuligeTall;
	}
}