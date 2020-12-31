import java.util.List;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BDService implements IConexion {
	
	static final String DRIVER_CONECTION = "com.mysql.jdbc.Driver";
	static final String PATH_CONECTION = "jdbc:mysql://localhost:3306/pruebas";

	
	
	@Override
	public void abrirConexion() {
		
		try {
			
		Class.forName(DRIVER_CONECTION);
		String pathConexion = PATH_CONECTION;
		Connection conection = DriverManager.getConnection(pathConexion, "root", "");
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
	
	
	
	@Override
	public void cerrarConexion() {

	}

	
	@Override
	public void agregarPersona(Persona p) {

		
	}

	@Override
	public void eliminarPersona(Persona p) {

		
	}

	@Override
	public void modificarPersona(Persona p) {

		
	}

	@Override
	public List<Persona> obtenerTodas() {

		
		return null;
	}

	@Override
	public Persona obtenerPersona(Long id) {

		return null;
	}

	
	
	
	
	

}
