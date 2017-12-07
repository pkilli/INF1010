import java.util.ArrayList;
public class FastRute extends Rute{
    
    public FastRute(int verdi){
        super(verdi);
    }
    
    public void fyllUtDenneOgResten(){
        //super.fyllUtDenneOgResten();
        if(this.neste != null){
            this.neste.fyllUtDenneOgResten();
        }  
        if(this.neste == null)
            this.rad.hentBrett().leggTilLoesning();
    }
}