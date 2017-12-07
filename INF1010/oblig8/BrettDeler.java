import java.util.ArrayList;

public class BrettDeler{
    protected Brett brett;
    protected ArrayList<Rute> ruter;
    
    BrettDeler(Brett brett){
        this.brett = brett;
        this.ruter = new ArrayList<Rute>();
    }
    
    public void settInn(Rute r){
        ruter.add(r);
    }
    
    public ArrayList<Rute> hentRuter(){
        return ruter;
    }
    
    public void skrivAlle(){
        for(Rute r : ruter)
            System.out.println(r);
    }
    
    public Brett hentBrett(){return this.brett;}
    
    public boolean harTallet(int i){
        boolean ret = false;
        for(Rute r : hentRuter()){
            if(r.hentVerdi()==i)
                ret = true;
        }
        return ret;
    }
    
    public int hentStoerrelse(){
        return ruter.size();
    }
}