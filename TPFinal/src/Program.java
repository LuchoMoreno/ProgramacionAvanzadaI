import java.lang.reflect.Field;
import java.util.ArrayList;

import Clases.PersonaReflexion;
import Servicios.Servicios;
import Utilidades.UBean;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonaReflexion p = new PersonaReflexion();
		
				
		p.setDni(22222);
		p.setApellido("Prueba");
		p.setLocalidad("Banfield");
		p.setNombre("TPFinal");
		p.setProvincia("Buenos Aires");
		p.setId(1L);
		
		
		//Servicios.Guardar(p);
		
		//Servicios.Eliminar(p);
		
		//Servicios.Modificar(p);
		
		//PersonaReflexion per = (PersonaReflexion) Servicios.ObtenerPorID(p.getClass(), p);
		
	
		
		
	}

}
