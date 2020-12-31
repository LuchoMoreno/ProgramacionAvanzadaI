
public class Persona {

	private int numero;
	private String nombre;
	private String apellido;
	private String provincia;
	private String localidad;
	


	
	public Persona(int numero, String nombre, String apellido, String provincia, String localidad) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.provincia = provincia;
		this.localidad = localidad;
	}


	// SOBRESCRIBIR METODOS.
	
	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
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
		return this.numero + " - " + this.nombre + " - " + this.apellido + " - " + this.provincia + " - " + this.localidad;
	}
	
	
	
	@Override
	public boolean equals(Object objeto)
	{
		if(objeto.getClass().equals(this.getClass()))
		{
		
			Persona p = (Persona)objeto; // Esto es un casteo.
			
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
