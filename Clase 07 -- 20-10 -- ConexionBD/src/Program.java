import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Connection conn = ConexionSingleton.getConnection();
				
			
			ConexionSingleton.agregarPersona(conn, new Persona(8, "Cosme", "Fulanito", "Buenos Aires", "Ezeiza"));
			
			
			ConexionSingleton.eliminarPersona(conn, 1);
			
			
			ConexionSingleton.obtenerTodas(conn);
			
			ConexionSingleton.cerrarConexion();
			
			
		
	

	}

}
