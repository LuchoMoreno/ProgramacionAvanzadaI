
public class CajaGenerics <T> // Si le pongo EXTENDS Number , solo se van a poder poner valores que extiendan de eso, como double.

{

	T parametroGenerico;
	
	 
	public void agregar (T objeto)
	{
		this.parametroGenerico = objeto;
	}
	
	
	public T obtener()
	{
		return this.parametroGenerico;
	}
	
}
