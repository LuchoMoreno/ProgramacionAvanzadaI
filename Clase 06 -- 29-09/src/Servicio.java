
public class Servicio {

	// Para que tenga un unico ejemplar, NO hay
	// que hacer un NEW de este objeto. 
	
	
	
	// --------------------- 1 ----------------------
	// Hay que crear un atributo estático de servicio.

	private static Servicio s;
	
	
	
	// --------------------- 2 ----------------------
	// Hay que hacer privado el constructor.
	// Para que NADIE pueda crear una instancia por fuera.
	
	private Servicio()
	{
		
	}
	

	// --------------------- 3 ----------------------
	// Hacemos un método que, si la instancia es nula, la crea. Y sino, la devuelve..

	public static Servicio getInstance()
	{
		if (s == null)
		{
			s = new Servicio();
		}
		
		return s;

	}
	

}
