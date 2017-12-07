public class Parkeringsplass<T>{
	
	private T kjoretoy;
	
	public Parkeringsplass(){
	}
	public void parkereKjoretoy(T _kjoretoy){
		kjoretoy = _kjoretoy;
	}
	public T kjoreUtKjoretoy(){
		return kjoretoy;
	}
}