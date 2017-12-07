public class LenkeListe< E extends Comparable<E> >{
	private	class Node{
		E data;
		Node neste=	null;
		public Node(E ny){
			data = ny;
		}
	}
	
	private Node foran = null;
	
	public void leggTil(E _e){
		Node tmp = new Node(_e);
		tmp.neste = foran;
		foran = tmp;
	}
	public void skrivUt(){
		Node tmp = foran;
		while(tmp.neste=!null){
			System.out.println(tmp);
			tmp=tmp.neste;
	}
	}
}