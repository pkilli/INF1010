import java.io.ArrayList;
class TekstHotell<E> implements TekstLagrer<E>{
	private ArrayList<E> hotellet = new ArrayList<E>();
	public E taUt(){
		hotellet.remove(0);
	}
	public void settInn(E denne){
		hotellet.add(denne);
	}
	public void nullstill(){
		hotellet.clear();
	}
}