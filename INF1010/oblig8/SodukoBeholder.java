import java.util.ArrayList;
class SodukoBeholder{
    private static int MAKS_ANTALL_LOESNINGER_I_BEHOLDER = 2500;
    
    ArrayList<BrettLoesning> sodukobeholder;
    private int antallLoesninger = 0;
    
    public SodukoBeholder(){
        sodukobeholder = new ArrayList<BrettLoesning>(MAKS_ANTALL_LOESNINGER_I_BEHOLDER);
    }
    
    public void settInn(BrettLoesning brett){
        antallLoesninger++;
        if(antallLoesninger<MAKS_ANTALL_LOESNINGER_I_BEHOLDER){
            sodukobeholder.add(brett);
        }
    }
    
    public BrettLoesning taUt(int i){
        if(i<MAKS_ANTALL_LOESNINGER_I_BEHOLDER)
            return sodukobeholder.get(i);
        return null;
    }
    
    public int hentAntallLoesninger(){return antallLoesninger;}
    
    
}