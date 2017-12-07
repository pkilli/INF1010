import java.util.Iterator; 
public class Tabell<T> implements AbstraktTabell<T>{
	private T[] tabell;
	public Tabell(int _i){
		tabell = (T[]) new Object[_i];
	}
	
	
	public boolean settInn(T _denne, int _index){
		if (finnObjekt(_index) != null || _index >= tabell.length)
			return false;
		tabell[_index] = _denne;
		return true;
		}
		
	public T finnObjekt(int _index){
		return tabell[_index];
		}
		
	public Iterator iterator(){
		return new tabellIterator();
		}
	
	public class tabellIterator implements Iterator<T>{
		int i = 0;
		
		public boolean hasNext(){
			if(tabell[i] == null)
				return false;
			return true;
		}
		public T next(){
			T ret = tabell[i];
			i += 1;
			return ret;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}