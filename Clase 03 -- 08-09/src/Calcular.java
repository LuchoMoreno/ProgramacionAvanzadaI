
public class Calcular {



	public double dividirUnchecked (Number n1, Number n2)
	{
		if (n2.doubleValue() == 0)
		{
			throw new MiUnchecked("No puede ser 0");
		}
		
		
		return n1.doubleValue() / n2.doubleValue();
		
	}
	
	
	
	public double dividirChecked (Number n1, Number n2) throws MiChecked
	{
		if (n2.doubleValue() == 0)
		{
			throw new MiChecked("No puede ser 0");
		}
		
		
		return n1.doubleValue() / n2.doubleValue();
		
	}
	
}
