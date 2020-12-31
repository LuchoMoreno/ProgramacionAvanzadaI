import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
	
		
		List lista = new ArrayList<>();
		
		// Los elementos se guardan de manera secuencial.
		lista.add("Hola"); // 0.
		lista.add("Chau"); // 1.
		
		
		System.out.println(lista.get(lista.size()-1)); // Obtengo ultimo elemento.
		
		
		// Recorrer manera uno.
		for (int i = 0; i<lista.size(); i++)
		{
			System.out.println(lista.get(i));
		}
		
		
		// Recorrer manera dos.
		for (Object aux : lista)
		{
			System.out.println(aux);
			
		}
		
		// Por posicion, indice u objeto.
		//lista.remove(1);
		//lista.clear(); // Remove todo.
		
	
		// Buscar y borrar.
		
		/**
		Object borra;
		for (Object aux : lista)
		{
			if (aux.equals("Hola"))
				{
				borra = aux;
				break;
				}
		}
		lista.remove(borra);
		*/
		
		List<String> lista2 = new ArrayList<String>();
		lista2.contains("Hola"); // Para ver si contiene algo.
		lista.isEmpty(); // Para ver si está vacía.
		
		
		
		
		//////////////////////////////////////////////////////////
		
		
		
		List<Persona> listaPersonas = new ArrayList<Persona>();

		Persona p1 = new Persona ("Lucho", "Moreno");
		Persona p2 = new Persona ("Nani", "Samaniego");
		Persona p3 = new Persona ("Juli", "Sdrubolini");
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		
		// El metodo COINTAINS y REMOVE, busca con equals. Entonces,
		//si no está bien hecho el equals, NO va a funcionar.
		
		
		
		/////////////////////////////////////////////////////
		
		
		List<String> lista04 = new ArrayList<>();

		lista04.add("1111");
		lista04.add("2222");
		
		Collections.sort(lista04);
	
		for (String s : lista04)
		{
			System.out.println(s);
		}
		
		
		/////////////////////////////////////////////////
		
		int[] arrayInt = new int[10]; // Primitivo
		
		List<Integer> listaInt = new ArrayList<>(); // Wrapper.
	
		
		
		// EL ARRAY LIST SIRVE PARA COLECCIONES QUE, TENGAMOS QUE REMOVER CASI NUNCA, Y CASI NUNCA TENGAMOS QUE ORDENAR.
		// PORQUE AL ORDENAR O ELIMINAR, HAY QUE REACOMODAR TODOS LOS DEMÁS ELEMENTOS.
		
		
		
		
		
		///////////////////////////////////////////////////
		
		
		// En LINKED, cuando se hace un ADD hay que añadir un elemento, y 
		// va a tener la referencia de la dirección de memoria, del elemento de arriba, y del elemento de abajo.
		// Si el elemento es el primero, la primer refernecia va a ser nulo (hacia arriba), y la segunda va a ser nula (hacia abajo).
		
		
		// Tarda más en addear. Cuando se hace un remove, el de la posición 1, se va, y le avisa al 0 que se enganche con el 2.
		// El espacio en ram va a quedar vacío, pero se va a manejar con direcciones de memoria.
		
		

		List<Persona> listaPersonasLinked = new LinkedList<Persona>();

		Persona p1Linked = new Persona ("Lucho", "Moreno");
		Persona p2Linked = new Persona ("Nani", "Samaniego");
		Persona p3Linked = new Persona ("Juli", "Sdrubolini");
		
		listaPersonas.add(p1Linked);
		listaPersonas.add(p2Linked);
		listaPersonas.add(p3Linked);
		
		
		
		///////////////////////////////////////////
		
		
		
		//NUEVO TEMA

		
		
		// Primera diferencia de SET, es que no se guardan de manera secuencial.
		// Van a salir de la manera que se almacenaron.
		// No permite valores duplicados. 
		
		Set<Persona> listaPersonasSet = new HashSet<Persona>();

		
		Persona p1Set = new Persona ("Lucho", "Moreno");
		Persona p2Set = new Persona ("Lucho", "Moreno");
		Persona p3Set = new Persona ("Juli", "Sdrubolini");
		
		
		listaPersonasSet.add(p1Set);
		listaPersonasSet.add(p2Set);
		listaPersonasSet.add(p3Set);
	
		System.out.println(listaPersonasSet.size() + "lalala");
		
		
		
		
		//////////////////////// MAP
		
		Map mapa = new HashMap<>();
		
		mapa.put("clave", "valor");
		mapa.put("otraClave", "otroValor");
		mapa.put(1, p1Set);
		System.out.println(mapa.get("clave"));
		System.out.println(mapa.get(1));
		
		
		
		Map<Integer, Persona> mapa2 = new HashMap<>();
		
		
		Set claves = mapa.keySet();
		System.out.println(claves);

		
		
		
		// TIPOS GENÉRICOS.
		
		
		CajaGenerics<String> cajita = new CajaGenerics<String>();
		
		cajita.agregar("String");
		
		String s = cajita.obtener();
		
		System.out.println(s);
		
	}	

}
