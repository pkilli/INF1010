import java.util.Iterator; 
public interface AbstraktTabell<T> extends Iterable<T>{
	public boolean settInn(T _denne, int _index);
	public T finnObjekt(int _index);
	public Iterator<T> iterator();
}