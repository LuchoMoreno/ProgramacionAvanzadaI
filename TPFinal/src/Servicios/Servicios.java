package Servicios;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import Anotaciones.Columna;
import Anotaciones.Id;
import Anotaciones.Tabla;
import Utilidades.UBean;
import Utilidades.UConexion;

public class Servicios {
	
	
	
	// el cual debe guardar en la base de datos el objeto. Debe
	// armarse la query por medio de reflexión utilizando las anotaciones creadas en
	// el punto 2 y utilizando los métodos creados en UBean.

	public static void Guardar(Object o)
	{
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Field> lista = new ArrayList<>();
		lista = UBean.obtenerAtributos(o);
		
		
		// Armo primer parte del String.
		
		sb.append("INSERT INTO ");
		sb.append(o.getClass().getAnnotation(Tabla.class).nombre());
		sb.append(" (");
		
		
		// Recorro todos los atributos. 
		for (Field campo : lista)
		{
			if (campo.getAnnotation(Id.class) == null)
			{
				sb.append(campo.getAnnotation(Columna.class).nombre() + ",");
			}	
		}
		
		sb.delete(sb.length()-1, sb.length());
		sb.append(") VALUES (");
		
		
		for (Field campo: lista)
		{
			if (campo.getAnnotation(Id.class) == null)
			{
				if (campo.getAnnotatedType().getType().equals(String.class))
				{
					sb.append("'");
					sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
					sb.append("'");
					sb.append(",");
				}
				else
				{
					sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
					sb.append(",");
				}
					
			}
		}
		
		sb.delete(sb.length()-1, sb.length());
		sb.append(")");

		
		
		// INTENTO REALIZAR LA CONEXION CON LA PETICION.
		try {

			 Connection conn = UConexion.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sb.toString());
			 ps.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	
		System.out.println(sb);
		
	}
	
	
	
	// el cual debe modificar todas las columnas, excepto la
	// columna Id, la cual se va a utilizar para la restricción(where). Debe armarse la
	// query por medio de reflexión utilizando las anotaciones creadas en el punto 2
	// y utilizando los métodos creados en UBean.
	
	public static void Modificar(Object o)
	{
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Field> lista = new ArrayList<>();
		lista = UBean.obtenerAtributos(o);
		
		
		// Armo primer parte del String.
		
		sb.append("UPDATE ");
		sb.append(o.getClass().getAnnotation(Tabla.class).nombre());
		sb.append(" SET ");
		
		
		// Recorro todos los atributos. 
		for (Field campo : lista)
		{
			if (campo.getAnnotation(Id.class) == null)
			{
				sb.append(campo.getAnnotation(Columna.class).nombre() + "=");
				
				
				if (campo.getAnnotatedType().getType().equals(String.class))
				{
					sb.append("'");
					sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
					sb.append("'");
					sb.append(",");
				}
				else
				{
					sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
					sb.append(",");
				}
			
			}	
		}
		
		sb.delete(sb.length()-1, sb.length());

		
		sb.append(" WHERE ");
		
		
		for (Field campo : lista)
		{
			if (campo.getAnnotation(Id.class) != null)
			{
				sb.append(campo.getAnnotation(Columna.class).nombre());
				sb.append("=");
				sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
			}
			
		}
		
		
		
		// INTENTO REALIZAR LA CONEXION CON LA PETICION.
		try {

			Connection conn = UConexion.getConnection();
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			ps.execute();
					
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		
		
		
		
		System.out.println(sb);
		
	}
	
	
	
	//  el cual debe eliminar el registro de la base de datos. Debe
	// armarse la query por medio de reflexión utilizando las anotaciones creadas en
	// el punto 2 y utilizando los métodos creados en UBean.
	
	public static void Eliminar(Object o)
	{
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Field> lista = new ArrayList<>();
		lista = UBean.obtenerAtributos(o);
		
		
		sb.append("DELETE FROM ");
		sb.append(o.getClass().getAnnotation(Tabla.class).nombre());
		sb.append(" WHERE ");
		
		
		// Recorro todos los atributos. 
				for (Field campo : lista)
				{
					if (campo.getAnnotation(Id.class) == null)
					{
						sb.append(campo.getAnnotation(Columna.class).nombre() + "=");
						
						
						if (campo.getAnnotatedType().getType().equals(String.class))
						{
							sb.append("'");
							sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
							sb.append("'");
							sb.append("&&");
						}
						else
						{
							sb.append(UBean.ejecutarGet(o, campo.getAnnotation(Columna.class).nombre()));
							sb.append("&&");
						}
					
					}	
				}
				
				sb.delete(sb.length()-2, sb.length());

			
				

				// INTENTO REALIZAR LA CONEXION CON LA PETICION.
			try {

				Connection conn = UConexion.getConnection();
				PreparedStatement ps = conn.prepareStatement(sb.toString());
				ps.execute();
							
				} catch (Exception e) {
							
						e.printStackTrace();
				}
				
				
				
				
				
				
				
				
		System.out.println(sb);
	
	
		
	}
	
	
	
	// el cual debe devolver un objeto del tipo
	// definido en el parámetro Class, con todos sus datos cargados. ). Debe armarse
	// la query por medio de reflexión utilizando las anotaciones creadas en el punto
	// 2 y utilizando los métodos creados en UBean.
	
	public static Object ObtenerPorID(Class c, Object o)
	{
		
		Constructor constructor = null;
		Object instancia = null;

	
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Field> lista = new ArrayList<>();
		
		lista = UBean.obtenerAtributos(c);
		
		Annotation anotacion = c.getAnnotation(Tabla.class);
		
		
		sb.append("SELECT * FROM ");
		sb.append(((Anotaciones.Tabla)anotacion).nombre());
		sb.append(" WHERE ");
		
		
		for (Field campo : lista)
		{
			if (campo.getAnnotation(Id.class) != null)
			{
				
				sb.append(campo.getAnnotation(Columna.class).nombre() + "=");
				
				
				if (campo.getAnnotatedType().getType().equals(String.class))
				{
					sb.append("'");
					sb.append(o); // id
					sb.append("'");
				}
				
				else
				{
					sb.append(o);
				}
			
			}
			
		}
		
		System.out.println(sb);
		return null;
		
	}
	
	
	

}
