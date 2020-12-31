
public class Factory {

	

	public static ICalculoSueldo obtenerFormaCalcular (Empleado e)
	{
		if (e.getTipoCobro().equals(TipoCobro.mensual))
		{
			return new SueldoMensual();
		}
		
	
		else if (e.getTipoCobro().equals(TipoCobro.porHora))
		{
			return new SueldoPorHora();
		}
		
		return null;
		
	}
	
}
