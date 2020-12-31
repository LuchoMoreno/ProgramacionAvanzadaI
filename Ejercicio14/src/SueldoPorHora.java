
public class SueldoPorHora implements ICalculoSueldo {

	
	@Override
	public double calcular(Empleado e) {
		return e.getSueldo() * e.getCantidadHorasTrabajadas();
	}

}
