package Practica;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Ejemplo.Persona;
import Practica.PersonaReflexion;

public class Program {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Object p = null;
		
		PersonaReflexion persona = new PersonaReflexion();
		persona.setDNI(11222333);
		
		Class c = Class.forName("Practica.PersonaReflexion");
		
		// Class c = PersonaReflexion.class;
		
		
		Constructor[] constructores = c.getConstructors();
		
		for (Constructor cons : constructores )
		{
			if (cons.getParameterCount() == 0)
			{
				try {
					p = cons.newInstance(null);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
				break;
			}
			
		}
		
		
		
		// ATRIBUTOS 
		Field[] atributos = c.getDeclaredFields();
		

		// SETTERS.
		for (Field f : atributos) {
			System.out.println(f.getName());
			
			String nombreAtributo = f.getName();
			String nombreSetter = "set"+nombreAtributo;
			
			
			Method[] metodos = c.getDeclaredMethods();
			
			for (Method m : metodos)
			{
				if (m.getName().equalsIgnoreCase(nombreSetter))
				{
					Object[] params = new Object[1];
					
					if (f.getType().equals(String.class))
					{
						params[0] = "String";	
					}
					else if (f.getType().equals(Integer.class))
					{
						params[0] = 111111;
					}
					else
					{
						params[0] = null;
					}
					
					m.invoke(persona, params);
					
				}
			}
		}
		
		
		// GETTERS.
		for (Field f : atributos) {

			String nombreAtributo = f.getName();
			String nombreGetter = "get"+nombreAtributo;
			
			Method[] metodos = c.getDeclaredMethods();
			
			for (Method m : metodos)
			{
				if (m.getName().equalsIgnoreCase(nombreGetter))
				{
					System.out.println("El atributo: " + f.getName() + " : " +m.invoke(persona, null));
					
				}


			}
		
		}
		

		
		
		

		
	}

}
