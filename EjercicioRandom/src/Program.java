import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int a[] = {1,2,1,1,1,3,4,2,2,2};
		
		System.out.println(Program.obtenerRepeticiones(a));
		
		

	}
	
	
	
	public static List<Integer> obtenerRepeticiones(int []numeros) {
       
		Map<Integer, Integer> auxNumeros = new HashMap();
        for(int num : numeros) 
        {
            if(!auxNumeros.containsKey(num)) 
            {
                auxNumeros.put(num, 1);
            }
            else 
            {
                auxNumeros.replace(num, auxNumeros.get(num) + 1);
            }
        }
        
        int max = Collections.max(auxNumeros.values());
       
        ArrayList<Integer> numMayores = new ArrayList<Integer>();
        auxNumeros.forEach((num, cant) -> 
        {
            if(cant == max) 
            {
                numMayores.add(num);
            }
        });
        return numMayores;
    }

}


