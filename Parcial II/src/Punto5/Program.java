package Punto5;

public class Program {

	public static void main(String[] args) {
		
		Program t = new Program();
				
				
		try
		{
			synchronized (t)
			{
				System.out.print("Blockeado");
				t.wait();
				t.notify();
				System.out.println("Desbloqueado");
				
			}
		
		}
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
					
				

	}

}
