package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UConexion {
	
	
	

	private static final String DRIVER_CONECTION = ManejadorPropiedades.getProperty("prop.Driver").toString();
	private static final String PATH_CONECTION = ManejadorPropiedades.getProperty("prop.ubicaciondb").toString();
	private static final String USER = ManejadorPropiedades.getProperty("prop.usuariodb").toString();
	private static final String PASSWORD = ManejadorPropiedades.getProperty("prop.password").toString();
	private static Connection CONN = null;

	
	
	// Constructor PRIVADO:
	private UConexion(){
		

		try {
			
			Class.forName(DRIVER_CONECTION);
			CONN = DriverManager.getConnection(PATH_CONECTION, USER, PASSWORD);
			System.out.println("Conexion abierta correctamente");
			
			} 
			
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
	}
		
	
	
	// Método para obtener la conexión.
	public static Connection getConnection()
	
	{
	    if (CONN == null){
	    	new UConexion();
	    	}
	    return CONN;
	}
	
	

	// Método para cerrar la conexión.
	public static void cerrarConexion()
	{
		if (CONN != null)
		{
			try {
				System.out.println("Conexion cerrada correctamente");
				CONN.close();
				CONN = null;
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	
	


}
