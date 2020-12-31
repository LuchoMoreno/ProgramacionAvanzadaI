package program.test;

import org.junit.Test;

import codigo.Ejercicio03; // CON ESTO IMPORTO EL PACKAGE PARA CREAR LA INSTANCIA DE LA CLASE.
import codigo.ManejoPalabra;
import junit.framework.Assert;

public class Ejercicio03Test {

	

	@SuppressWarnings("deprecation")
	@Test
	public void retornarCantidadOK() throws Exception
	{
		
		Ejercicio03 ejercicio = new Ejercicio03(); 
		
		try {
			
			int retorno = ejercicio.retornarCantidad("Lucho");
			Assert.assertEquals(5, retorno, 0);
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void retornarCantidadNull()
	{
		
		Ejercicio03 ejercicio = new Ejercicio03(); 
				
				try {
					
					int retorno = ejercicio.retornarCantidad(null);
					Assert.assertNull(retorno);
				}
				
				catch (Exception e)
				{
					System.out.println(e);
				}
	}
	
	
	

	
	@Test
	public void verificarPalabraNula() throws Exception
	{
		ManejoPalabra palabra = new ManejoPalabra(); 
		try {
			palabra.segundaPalabra(null);
			Assert.fail();
		}
		catch (NullPointerException e){
			Assert.assertTrue(true);;
		}
	}
	
	

	@Test
	public void verificarCantidad() throws Exception
	{
		ManejoPalabra palabra = new ManejoPalabra(); 
		try {
			int retorno = palabra.segundaPalabra("Hola aa").length();
			Assert.assertEquals(2, retorno, 0);

		}
		catch (NullPointerException e){
			Assert.fail();
		}
	}
	
	
	
}


