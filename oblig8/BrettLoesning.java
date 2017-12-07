import java.util.ArrayList;
public class BrettLoesning{
    private ArrayList<Rute> brettLoesning;
    private static int TELLER = 0;
    private int loesningsnummer;
    
    public BrettLoesning(ArrayList<Rute> b){
        loesningsnummer = TELLER++;
        this.brettLoesning = new ArrayList<Rute>();
        
        for(Rute r:b)
            brettLoesning.add(r);
    }
    
    public ArrayList<Rute> hentLoesning(){return brettLoesning;}
    
    public String toString(){
        String utskrift = "";
        int radStoerelse = brettLoesning.get(1).hentRad().hentStoerrelse();
        
        for(int i=0; i<brettLoesning.size();i++){
            Rute r = brettLoesning.get(i);
            
            utskrift += r.hentVerdi();
            
            if((i+1)%radStoerelse==0)
                utskrift+="//";
        }
        
        return loesningsnummer+": "+utskrift;
    }
}