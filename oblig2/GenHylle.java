interface GenHylle<E>{
	public int storrelse();
	public boolean settInn(E _denne, int _plass);
	public boolean ledigPlass(int _plass);
	public E taUt(E _denne, int _plass);
}