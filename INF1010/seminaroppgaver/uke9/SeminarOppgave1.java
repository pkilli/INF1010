public class SeminarOppgave1 implements Runnable{
	
	static int count = 0;
	public SeminarOppgave1(){}
	public static synchronized void update()
	{
		count++;
	}
	@Override
	public void run()
	{
		update();
		
	}

}