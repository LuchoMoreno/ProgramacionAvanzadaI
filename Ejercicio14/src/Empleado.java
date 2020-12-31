
public class Empleado{
	
	
	private String nombre;
	private String apellido;
	private Long cuil;
	private String estado;
	private int sueldo;
	private int cantidadHorasTrabajadas;
	private Enum<?> TipoCobro;
	
	
	

	public Empleado()
	{
		
	}
	
	
	public Empleado(String nombre, String apellido, Long cuil, String estado, int sueldo, int cantidadHorasTrabajadas, Enum<?> tipoCobro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.estado = estado;
		this.sueldo = sueldo;
		this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
		TipoCobro = tipoCobro;
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
	
	public Long getCuil() {
		return cuil;
	}
	
	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public int getCantidadHorasTrabajadas() {
		return cantidadHorasTrabajadas;
	}
	
	public void setCantidadHorasTrabajadas(int cantidadHorasTrabajadas) {
		this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
	}
	
	public Enum<?> getTipoCobro() {
		return TipoCobro;
	}
	
	public void setTipoCobro(Enum<?> tipoCobro) {
		TipoCobro = tipoCobro;
	}


	
	
	
	

}
