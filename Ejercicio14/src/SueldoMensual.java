
public class SueldoMensual implements ICalculoSueldo{

	
	@Override
	public double calcular(Empleado e) {
		return e.getSueldo();
	}

	
	
}
