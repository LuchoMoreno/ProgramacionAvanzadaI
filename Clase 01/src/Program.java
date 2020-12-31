
public class Program {

	public static void main(String[] args) {
		
		Persona p = new Persona("Lucho", "Moreno");
		
		Persona p2 = new Persona();
		
		p2.setNombre("Lucho");
		p2.setApellido("Moreno");
		
		
		System.out.println(p);
		
		System.out.println(p.equals(p2));
		
		
		
		
	}

}
