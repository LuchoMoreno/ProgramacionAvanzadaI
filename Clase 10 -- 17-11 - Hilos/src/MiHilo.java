// Tiene que heredar de la clase Thread.

// No se pueden reutilizar. Nacen - Se ejecuta - Se destruyen. 
// Se crea con NEW.
// Se inicia con start.
// Se destruye cuando sale del run.



// SE DEBE IMPLEMENTAR RUNNABLE

// this.wait detiene la ejecucion de un hilo sincronizado, por tiempo indefinido. Hasta que alguien le diga que continue. 


public class MiHilo implements Runnable {
	
	Integer num = 0;
	
	@Override 
	public void run()
	{
		

		
		for (int i = 0; i<10000; i++)
		{
			// Con sincronizar. El primero que agarra el objeto, no lo pueden volver a utilizar. 
			// Sincroniza el this -> oBJeto hilo del main. 
			/*synchronized (this)
			{
				this.num++;
			}*/
			
			synchronized (this)
			{
				
				sumar();
				

			}
			
			
		}

	}
	
	
	public synchronized void sumar()
	{
		this.num++;
	}
	
	public synchronized void restar()
	{
		this.num--;
	}
	
	
	public synchronized void despertar()
	{
		this.notify();
	}
	
	
	public synchronized void dormir()
	{
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}



/*
 * 
 * @Override 
	public void run()
	{
		
		System.out.println("Hilo ejecutandose");
		System.out.println(Thread.currentThread().getName());
		
		for (int i = 0; i<1000; i++)
		{
			// Cuando dos hilos encuentran el yield, dejan la priorida de la proxima ejecucion a otro hilo de la misma prioriodad. El que ejecute
			// el metodo yield deja pasar al otro. Intenta que la ejecucion sea pareja. 
			Thread.yield();
			
			if (Thread.currentThread().isInterrupted())
			{
				return;
			}
			
			else
			{
				System.out.println(Thread.currentThread().getName() + " - " + i);

			}
		}

	}
	*/
