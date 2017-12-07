class Bol<T>{
	private T denne;
	private boolean tomt = true;
	public void settInn(T _navn){  //setter parameter med _ for oversikt og skille fra variabler.
			if(tomt){ //forhindrer fler dyr i bolet
				denne = _navn;
				tomt = false;
			}else
				System.out.println("Bolet er allerede fullt. ");
	}
	public T beboer(){
		tomt = true;
		return denne;
	}
	public boolean erTomt(){return tomt;}
	
}