package Clases;
import Anotaciones.Columna;
import Anotaciones.Id;
import Anotaciones.Tabla;

@Tabla(nombre = "Persona")
public class PersonaReflexion {

	@Id
	@Columna(nombre = "Id")
	private Long id;
	
	@Columna(nombre = "Dni")
	private Integer dni;
	
	@Columna(nombre = "Nombre")
	private String nombre;
	
	@Columna(nombre = "Apellido")
	private String apellido;
	
	@Columna(nombre = "Provincia")
	private String provincia;
	
	@Columna(nombre = "Localidad")
	private String localidad;
	


	public PersonaReflexion()
	{
		
	}
	
	
	public PersonaReflexion(Integer numero, String nombre, String apellido, String provincia, String localidad) {
		super();
		this.dni = numero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.provincia = provincia;
		this.localidad = localidad;
	}


	// SOBRESCRIBIR METODOS.
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	
	public int getDni() {
		return dni;
	}
	

	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	@Override // Esto es para verificar que existe el metodo para sobreescribir.
	
	public String toString()
	{
		return this.dni + " - " + this.nombre + " - " + this.apellido + " - " + this.provincia + " - " + this.localidad;
	}
	
	
	
	@Override
	public boolean equals(Object objeto)
	{
		if(objeto.getClass().equals(this.getClass()))
		{
		
			PersonaReflexion p = (PersonaReflexion)objeto; // Esto es un casteo.
			
			if(p.nombre.equals(this.nombre) && p.apellido.equals(this.apellido))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}

	}
	
	
	@Override
	public int hashCode() // Sirve para calcular previo guardar los objetos en la memoria ram. Es fundamental que vaya con el método equals.
	{
		int primo = 31;
		int resultado = 0;
		resultado += primo*this.nombre.hashCode();
		resultado += primo*this.apellido.hashCode();
		
		return resultado;
	}
	
	
	
}
