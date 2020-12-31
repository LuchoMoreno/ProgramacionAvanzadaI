import java.util.List;

public interface IConexion {

	void abrirConexion();
	
	void agregarPersona(Persona p);
	
	void eliminarPersona(Persona p);
	
	void modificarPersona(Persona p);
	
	List<Persona> obtenerTodas();
	
	Persona obtenerPersona (Long id);
	
	void cerrarConexion();
	
	
	
}
