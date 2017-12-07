import java.util.*;
public class SortertEnkelListe<T extends Comparable<T>> implements AbstraktSortertEnkelListe<T>{
	private Node foran = null;
	private Node bak = null;
	public SortertEnkelListe(){
		foran = new Node(null);
	}
	
	public void settInnForan(T _denne){
		Node tmp = new Node(_denne);
		if(foran.neste == null){
			bak = tmp;
		}
		tmp.neste = foran.neste;
		foran.neste = tmp;
		sorter();
	}
	private void settInn(T _denne){
		Node tmp = new Node(_denne);
		if(foran.neste == null){
			bak = tmp;
		}
		tmp.neste = foran.neste;
		foran.neste = tmp;
	}
	
	public T finnObjekt(String _navn){
		/*for(T t : this){
			if(t.samme(_navn)) return t;
		}*/
		return null;
	}
	
	private boolean tom(){
		return foran.neste == null;
	}
	
	private void sorter(){
		if(!tom()){
			T pivot = this.taUtForan();
			SortertEnkelListe<T> mep = mindreEnnPivot(pivot);
			mep.sorter(); this.sorter();
			this.settInn(pivot);
			limSammenForan(mep);
		}
	}
	
	private SortertEnkelListe<T> mindreEnnPivot(T _pivot){
		SortertEnkelListe<T> mep = new SortertEnkelListe<T>();
		Iterator<T> it = iterator();
		while(it.hasNext()){
			T t = it.next();
			if (t.compareTo(_pivot) <= 0){
				mep.settInn(t);
				it.remove();
			}
		}
		return mep;
	}
	
	private void limSammenForan(SortertEnkelListe<T> _ll){
		if(! _ll.tom()){
			_ll.bak.neste	= foran.neste;
			foran.neste		= _ll.foran.neste;
		}
	}
	
	private T taUtForan(){
		Node ut = foran.neste;
		foran.neste = foran.neste.neste;
		return ut.data;
	}
	
	public Iterator iterator(){
		return new sorteringsIterator();
	}
	
	private class sorteringsIterator implements Iterator<T>{
		
		Node pos = foran;
		int tilstandA = 0;
		int tilstandB = 1;
		
		int tilstand = tilstandA;
		
		public boolean hasNext(){
			return (tilstand == tilstandA && pos.neste != null)
					|| (tilstand == tilstandB && pos.neste.neste != null);
		}
		public T next(){
			if(tilstand == tilstandA);
			else pos = pos.neste;
			tilstand = tilstandB;
			return pos.neste.data;
		}
		public void remove(){
			if(tilstand == tilstandB){
				pos.neste = pos.neste.neste;
				tilstand = tilstandA;
			}else System.out.println("maa vaere i tilstandB!");
		}
	}
	private class Node{
		T data;
		Node neste;
		public Node(T _denne){
			data = _denne;
		}
	}
}