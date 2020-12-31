package codigo;
public class Program {

	public static void main(String[] args) throws Exception {
		
	
	String lucho = "Lucho";
		
	Ejercicio03 Ejercicio = new Ejercicio03();
	
	
	System.out.println(Ejercicio.retornarCantidad(lucho));
	System.out.println(Ejercicio.retornarMitad(lucho));
	System.out.println(Ejercicio.retornarUltimoCaracter(lucho));
	System.out.println(Ejercicio.retornarInvertido(lucho));

		
	
	ManejoPalabra palabra = new ManejoPalabra(); 
	System.out.println(palabra.segundaPalabra("Hola aa"));
	System.out.println(palabra.segundaPalabra("Hola aa").length());
	
	
	}

}
