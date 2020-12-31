import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Anotaciones.Columna;
import Anotaciones.Test;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException {

		
		
		// Program.Punto1();
		
		Program.Punto2();
		 
		
	
		
		
	}
	
	
	
	public static void Punto1 () throws ClassNotFoundException
	{
		
		Persona autito = new Persona(111, "Lucho", "Moreno", "BS", "BAN");

		Class c = Class.forName("Persona");
		Field[] atributos = c.getDeclaredFields();

		for (Field f : atributos) {

		String nombreAtributo = f.getName();
		String nombreGetter = "get"+nombreAtributo;
					
		Method[] metodos = c.getDeclaredMethods();
					
		for (Method m : metodos) {
			
			if (m.getName().equalsIgnoreCase(nombreGetter)) {
		    
				try {
				System.out.println("El atributo: " + f.getName() + " : " +m.invoke(autito, null));
				} 
				
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				}			
			}


		}
				
		}
		
	}
	
	
	public static void Punto2 ()
	{
		
		ManejoStringTest j = new ManejoStringTest();
		
		ArrayList<Field> lista = new ArrayList<>();
		
		Class generica = j.getClass();
		
		Method[] todosLosMetodos = generica.getDeclaredMethods();
		
		
		for (Method metodos : todosLosMetodos) {
			
			if (metodos.getAnnotation(Test.class) != null)
			{

				System.out.println(metodos.getAnnotation(Test.class).nombre());
				
				for (int i = 0; i<metodos.getAnnotation(Test.class).intentos(); i++)
				{
					try {
						metodos.invoke(j, null);
					} 
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
					{
						e.printStackTrace();
					}
				}
			}
					
			
		}
		
	}

}
