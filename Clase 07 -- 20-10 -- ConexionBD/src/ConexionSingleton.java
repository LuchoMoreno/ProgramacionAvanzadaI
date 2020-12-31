import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class ConexionSingleton {
	
	private static final String DRIVER_CONECTION = "com.mysql.jdbc.Driver";
	private static final String PATH_CONECTION = "jdbc:mysql://localhost:3306/pruebas";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static Connection CONN = null;
	
	
	
	// Constructor PRIVADO:
	private ConexionSingleton(){
		

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
	public static Connection getConnection(){
	    if (CONN == null){
	    	new ConexionSingleton();
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
	
	
	
	public static void agregarPersona(Connection c, Persona p)
	{
		try 
		{
			PreparedStatement st = c.prepareStatement("insert into proveedores (NUMERO, NOMBRE, APELLIDO, PROVINCIA, LOCALIDAD) values (?,?,?,?,?)");
			st.setInt(1, p.getNumero());
			st.setString(2, p.getNombre());
			st.setString(3, p.getApellido());
			st.setString(4, p.getProvincia());
			st.setString(5, p.getLocalidad());
			st.execute();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
	
	
	public static void eliminarPersona(Connection c, int id)
	{
		try 
		{
			PreparedStatement st = c.prepareStatement("delete from proveedores where numero = (?)");
			st.setInt(1, id);

		} 

		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static List<Persona> obtenerTodas(Connection c){
		
		try
		{
			PreparedStatement st = c.prepareStatement("select * from proveedores");
			ResultSet rs = st.executeQuery();
			List <Persona> personas = new ArrayList<>();


			while(rs.next())
			{
				
				// LO TRATO COMO INTEGER.
				Integer numeroString = rs.getInt("numero"); 

				String nombreString = rs.getString("nombre");
				
				String apellidoString = rs.getString("apellido");
				
				String provinciaString = rs.getString("provincia");
				
				String localidadString = rs.getString("localidad");
				
				Persona p = new Persona(numeroString, nombreString, apellidoString, provinciaString, localidadString);
				
				personas.add(p);
				
			}
			

			for (int i = 0; i<personas.size(); i++)
			{
				System.out.println(personas.get(i));
			}
			
			return personas;
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	

		

}
