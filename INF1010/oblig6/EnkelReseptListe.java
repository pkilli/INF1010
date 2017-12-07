import java.util.*;
public abstract class EnkelReseptListe implements Iterable<Resept>{
	Node foran = null;
	Node bak = null;
	public EnkelReseptListe(){
		foran = new Node(null);
	}
	public void settInn(Resept _resept){
		Node tmp = new Node(_resept);
		if(foran.neste == null){
			bak = tmp;
		}
		tmp.neste = foran.neste;
		foran.neste = tmp;
		
	}
	public class ReseptUnntak extends Exception {
		public ReseptUnntak(String s) {}
	}
	public Resept finnObjekt(int _nummer) throws ReseptUnntak {
		Resept ret;
        ret = new Resept();
		if(foran.neste != null){
			for(Resept r : this){
				if(r.getReseptNummer() == _nummer)
					ret = r;
			}
		}
		if(ret != null) return ret;
		else 
			throw new ReseptUnntak("Det finnes ingen resepter med nummer: " + _nummer);
		
	}
	
	public Iterator<Resept> iterator(){
		return new reseptIterator();
	}
	protected class reseptIterator implements Iterator<Resept>{
		Node pos = foran;
		public boolean hasNext(){
			return pos.neste != null;
		}
		public Resept next(){
			Resept ret = pos.neste.data;
			pos = pos.neste;
			return ret;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	protected class Node{
		Resept data;
		Node neste = null;
		public Node(Resept _resept){
			data = _resept;
		}
	}
}