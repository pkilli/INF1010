public class Hylle<E> implements GenHylle<E>{ 
	private E[] alle;
	public Hylle(int _hyllestr){
		alle = (E []) new Object[_hyllestr];
		
	}
	public int storrelse(){return alle.length;}
	public boolean settInn(E _denne, int _plass){
		if(!ledigPlass(_plass))
			return false;
		else if(inneholder(_denne))
			return false;
		alle[_plass] = _denne;	
		return true;
	}
	public boolean ledigPlass(int _plass){
		if(_plass >= storrelse())
			return false;
		else if(alle[_plass] == null)
			return true;
		return false;
	}
	public E taUt(E _denne, int _plass){
		if(alle[_plass] == _denne){
			alle[_plass] = null;
			return _denne;
		}
		return null;
	}
	/* 
		sjekker at det ikke kommer inn to like boeker
		
	*/
	public boolean inneholder(E _denne){
		boolean ret = false;
		for(int i = 0; i<alle.length; i++){
			if(alle[i] != null){
				if(alle[i].toString().equals(_denne.toString()))
					ret = true;
			}
		}	
		return ret;
	}
}
