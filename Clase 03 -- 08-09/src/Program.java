
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// Si es UNCHECKED no me hace falta hacer un try and catch. 
		// Pero lo puedo hacer.
		
		Calcular uncheck = new Calcular();
		uncheck.dividirUnchecked(2, 1);

		
		// Ejemplo con TRY-CATCH.
		Calcular uncheck2 = new Calcular();
		
		
		try
		{
			uncheck2.dividirUnchecked(2, 0);
		}
		catch (MiUnchecked e)
		{
			System.out.println(e);
		}
		
		
		
		
		// Si es checked, tengo que hacer si o si try and catch.
		
		Calcular c2 = new Calcular();
		
		try
		{
			c2.dividirChecked(2, 0);
		}
		catch (MiChecked e)
		{
			System.out.println(e);
		}
		
		
		
		
	}

}
 