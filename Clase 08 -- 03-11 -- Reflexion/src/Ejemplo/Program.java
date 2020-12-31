package Ejemplo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

	public static void main(String[] args) {
		
		
		Persona p = new Persona();
		p.setDNI(11222333);
		
		Class c = p.getClass();
		
		// Accesibles de la clase.
		Field[] atributos = c.getFields();
		
		// Declarados en la clase. Da igual si son privados o publicos
		Field[] atributosPrivados = c.getDeclaredFields();
		
		for (Field f : atributos) {
			System.out.println(f.getName());
			System.out.println(f.getType());
			System.out.println(f.isAccessible());
		}
		
		Method[] metodos = c.getMethods();
		
		for (Method m : metodos)
		{
			System.out.println(m.getName());
			System.out.println(m.getReturnType());
			System.out.println(m.getParameterCount());
		}
		
		
		for (Method m : metodos)
		{
			if (m.getName().equals("getDNI"))
			{
				try {
					// ESTO RECIBE P COMO PRIMER PARAMETRO, QUE ES LA PERSONA. PORQUE GETDNI NO ES ESTATICO. ES DE INSTANCIA
					Object o = m.invoke(p, null);
					System.out.println(o);
					
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// El metodo GETDNI no esté declarado dentro de la instancia p
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if ("setDNI".equals(m.getName()))
			{
				Object[] params = new Object[1];
				params[0] = 20202002;
				
				try {
					System.out.println(m.invoke(p, params));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		

	}

}
