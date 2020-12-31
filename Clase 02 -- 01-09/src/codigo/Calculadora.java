package codigo;

public class Calculadora implements ICalcular {

	public static void main(String[] args) throws Exception {
	
		
		Calculadora calcul = new Calculadora();
		
		System.out.println(calcul.sumar(1, 2));
		System.out.println(calcul.restar(1, 2));
		System.out.println(calcul.multiplicar(1, 2));
		System.out.println(calcul.dividir(1, 2));
		
	}
	
	
	public Double sumar(Number numeroUno, Number numeroDos)
	{
		return Double.valueOf( numeroUno.doubleValue() + numeroDos.doubleValue());
	}
	
	public Double restar(Number numeroUno, Number numeroDos)
	{
		return Double.valueOf( numeroUno.doubleValue() - numeroDos.doubleValue());
	}
	
	public Double multiplicar(Number numeroUno, Number numeroDos)
	{
		return Double.valueOf( numeroUno.doubleValue() * numeroDos.doubleValue());
	}
	
	public Double dividir(Number numeroUno, Number numeroDos) throws Exception
	{
		if (numeroDos.doubleValue() == 0)
		{
			throw new Exception("ERROR");
		}
		else
		{
			return Double.valueOf( numeroUno.doubleValue() / numeroDos.doubleValue());
		}
		

	}

}
