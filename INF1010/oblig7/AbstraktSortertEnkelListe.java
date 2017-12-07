import java.util.*;
public interface AbstraktSortertEnkelListe<T> extends Iterable<T>{
	public void settInnForan(T _denne);
	public T finnObjekt(String _key);
	public Iterator<T> iterator();
}