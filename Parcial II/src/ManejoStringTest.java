import Anotaciones.Test;

public class ManejoStringTest {
	
	
	@Test(nombre = "Test", intentos = 3)
	public static void Prueba()
	{
		System.out.println("PRUEBA PUNTO 2");
	}
	
	
	@Test(nombre = "Test 2", intentos = 5)
	public static void Prueba2()
	{
		System.out.println("PRUEBA PUNTO 2");
	}
	
	
	public static void PruebaSinAnotacion()
	{
		
	}

}
