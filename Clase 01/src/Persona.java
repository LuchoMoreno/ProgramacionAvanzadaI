
public class Persona {

	private String nombre;
	private String apellido;
	
	
	
	public Persona() // Constructor sin parametros que no instancia los atributos.
	{
		
	}
	
	
	public Persona(String nombre, String apellido)
	{
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	// ALT + SHIFT + S  / Boton derecho -> Source -> Get/set.
	
	// Utilizo get y set, porque las atributos son privados.
	
	public void setNombre (String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	public void setApellido (String apellido) 
	{
		this.apellido = apellido;
	}
	
	
	public String getNombre ()
	{
		return this.nombre;
	}
	
	
	// SOBRESCRIBIR METODOS.
	
	@Override // Esto es para verificar que existe el metodo para sobreescribir.
	
	public String toString()
	{
		return this.nombre + " - " + this.apellido;
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
