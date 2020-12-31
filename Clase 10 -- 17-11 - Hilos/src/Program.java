
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MiHilo hilo = new MiHilo();
		MiHilo hilo2 = new MiHilo();
		
		Thread t1 = new Thread(hilo, "Hilo 1");
		Thread t2 = new Thread(hilo2, "Hilo 2");
		
		
		/*
		MiHilo hilo = new MiHilo();
		Thread t1 = new Thread(hilo, "Hilo 1");
		Thread t2 = new Thread(hilo, "Hilo 2");
		*/
		
		// t1.setPriority(1); // Establece prioridad entre 0 y 10.
		// t1.isDaemon(); // Le da una prioridad BAJISIMA para que no consuma.
		// t1.interrupt(); Interrumpe el HILO y hay que verificar del otro lado con Thread.currentThread().isInterrupted()
		// t1.join(); Hace una cola de hilos, primero se ejecuta uno, y despues el otro. Finalmente termina el main. Tiene una sobrecarga de tiempo, se joinea por tanto tiempo y despues siguen los otros hilos
		
		t1.start();

		t2.start();
		
		
		while (t1.isAlive() || t2.isAlive())
		{
			System.out.println("Termino:" + hilo.num + " -- " + hilo2.num);

		}
	
		
		System.out.println("Termino:" + hilo.num + " -- " + hilo2.num);
	


	}

}
