import java.util.*;
import java.io.*;

public class Brett
{
    //brettets form
	private int antRuter;
	private int boksHoyde = 0;
	private int boksBredde = 0;
	private int stoerrelse =0;
    //brett
	private Rute[][] brett;
    //brettdeler
    private Kolonne[] k;
    private Rad[] r;
    private Boks[] b;
    //beholder
    private SodukoBeholder sodukobeholder;
	
	public Brett(List<Rute> _brett, int _bokshoyde, int _boksBredde)
	{
		stoerrelse = (_boksBredde*_bokshoyde);
		antRuter = stoerrelse*stoerrelse;
		boksHoyde = _bokshoyde;
		boksBredde = _boksBredde;
		brett = new Rute[stoerrelse][stoerrelse];
		lagBrett(_brett);
        sodukobeholder = new SodukoBeholder();
	}
	
	private void lagBrett(List<Rute> _brett)
	{
		int index=0;
		for(int i=0;i<stoerrelse;i++)
		{
			for(int j=0;j<stoerrelse;j++)
			{
				brett[i][j]=_brett.get(index);
				index++;
			}
		}
	}

	
    public void opprettDatastruktur(){	
		k = new Kolonne[stoerrelse];
		r = new Rad[stoerrelse];
        b = new Boks[stoerrelse];
		for(int l = 0; l<stoerrelse;l++)
		{
			k[l] = new Kolonne(this);
			r[l] = new Rad(this);
            b[l] = new Boks(this);
		}
		int bredde = 0;
        int h = 0;
        int boksNr = 0;
        int ruteNr = 0;
        Rute tmp = null;
		for (int i = 0; i < stoerrelse; i++) { 
            for (int j = 0; j < stoerrelse; j++){
                if(j%boksBredde==0){
                    if(h++%boksHoyde==0)
                        bredde = 0;
                    bredde++;
                }
                boksNr = (((i+bredde)-(i%boksHoyde))-1);
                Rute rute = brett[i][j];
                
                rute.setBoks(b[boksNr]);
                b[boksNr].settInn(rute);
                
                if(j == k[j].hentNummer()){
                        rute.setKolonne(k[j]);
                        k[j].settInn(rute);
                }
                    
                if(i == r[i].hentNummer()){
                        rute.setRad(r[i]);
                        r[i].settInn(rute);
                }
                
                if(tmp != null){
                    tmp.settNeste(rute);
                }
                tmp = rute;
			}
		}            
	}
    
    public void finnLoesning(){
        brett[0][0].fyllUtDenneOgResten();
    }

	public void skrivBrett(){
        for(int j= 0; j<sodukobeholder.hentAntallLoesninger();j++)
            System.out.println(sodukobeholder.taUt(j).toString());
	}
    
    public void skrivTilFil(String _filnavn){
        try
		{
			PrintWriter utput = new PrintWriter(_filnavn);
            for(int j= 0; j<sodukobeholder.hentAntallLoesninger();j++)
                utput.print((sodukobeholder.taUt(j).toString()));
			utput.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("fant ikke filen");
		}
    }
    
	public void toemBrett(Rute r){
        if( r != null){
            if(r instanceof VariabelRute)
                r.settVerdi(0);
            this.toemBrett(r.hentNeste());
            
        }
    }
    
    public void leggTilLoesning(){
        if(brettOK()){
            BrettLoesning loesning = new BrettLoesning(enBrettLoesning());
            sodukobeholder.settInn(loesning);           
        }
    }
    
    public boolean brettOK(){
        boolean ret = true;
        for(int i=0;i<stoerrelse;i++){
            for(int j=0;j<stoerrelse;j++)
                if(brett[i][j].hentVerdi()==0)
                    ret = false;
        }
        return ret;
    }
    
    public  ArrayList<Rute> enBrettLoesning(){
        ArrayList<Rute> enLoesning = new ArrayList<Rute>();
        for(int i=0;i<stoerrelse;i++){
            for(int j=0;j<stoerrelse;j++)
                enLoesning.add(brett[i][j]);
        }
            
        return enLoesning;
    }

}