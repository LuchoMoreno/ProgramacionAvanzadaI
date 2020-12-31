package codigo;

public class Ejercicio03 {

	
	
	
	public Ejercicio03()
	{
		
	}
	
	
	/**
	 * 
	 * @param parametro String a ser modificado.
	 * @return string modificado.
	 * @throws Exception 
	 */
	public int retornarCantidad (String parametro) throws Exception
	{
		int cantidad;
		
		if (parametro != null)
		{
			cantidad = parametro.length();
		}
		else
		{
			throw new Exception("El parametro es nulo.");
		}
		
		return cantidad;
		
	}
	
	
	public String retornarMitad(String parametro )
	{
		
		return parametro.substring(0, parametro.length()/2);
	}
	
	
	public String retornarUltimoCaracter(String parametro)
	{
		return parametro.substring(parametro.length()-1);
	}
	
	
	public String retornarInvertido(String parametro)
	{
		String cadenaInvertida = "";
		for (int x=parametro.length()-1;x>=0;x--)
		{
			cadenaInvertida = cadenaInvertida + parametro.charAt(x);
		}
		return cadenaInvertida;
	}
	
	
	


}
