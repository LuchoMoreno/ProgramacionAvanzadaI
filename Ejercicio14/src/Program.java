import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Long cuil = (long) 2010202;
		
		Empleado e1 = new Empleado ("Lucho", "Moreno", cuil, "Activo", 200, 12, TipoCobro.mensual);
		
		List<Empleado> empleados = new ArrayList<>();
		empleados.add(e1);
		
		
		for (Empleado o : empleados)			
		{
			ICalculoSueldo c = Factory.obtenerFormaCalcular(o);
			System.out.println(c.calcular(o));
		}
		
		
	}

}
