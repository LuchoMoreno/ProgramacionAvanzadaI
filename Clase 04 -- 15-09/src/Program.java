import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		// EJERCICIO: ESCRIBIR ALGO EN CONSOLA, Y PEGARLO EN EL ARCHIVO.
		
		/*
		System.out.println("Ingrese el texto: ");
		Scanner sc = new Scanner(System.in);
		String textoIngresado = sc.next();
		System.out.println(textoIngresado);
		*/
		
		// EL NEXT SOLO, CORTA CON ESPACIO. ENCUENTRA STRING HASTA ESPACIO.
		// EL NEXTLINE ENCUENTRA TODA LA LÍNEA.
		
	
		// EJERCICIO 01.
		//File pruebaEjercicio1 = new File("pruebaUno.txt");
		//Program.writeDesdeConsola(pruebaEjercicio1);

		
		
		// EJERCICIO 02 --> CLONAR UN ARCHIVO.
		//Program.writeBinario(new File("ProgramacionAV.pdf"), new File("copia.pdf"));
		
		
		// EJERCICIO 03 --> CLONAR UN DIRECTORIO ENTERO.
		
		//Program.clonarDirectorio(new File("C:\\\\Users\\\\Lucho\\\\Documents\\\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\\\Clase 04 -- 15-09\\\\XXDirectorioOriginal"), new File("C:\\\\\\\\Users\\\\\\\\Lucho\\\\\\\\Documents\\\\\\\\workspace-spring-tool-suite-4-4.7.1.RELEASE\\\\\\\\Clase 04 -- 15-09\\\\\\\\XXDirectorioCLON"));
		
/*
		File directorioOriginal = new File("C:\\Users\\Lucho\\Desktop\\ejemplo");
		File directorioCopia = new File("C:\\Users\\Lucho\\Desktop\\ejemplocopia");
		
	
		Program.clonarDirectorio(directorioOriginal, directorioCopia);
*/
	
		//Program.clonarDirectorio(new File("C:\\Users\\Lucho\\Desktop\\ejemplo"), new File("C:\\Users\\Lucho\\Desktop\\ejemplo2"));
		
		Program.copiarDirectorio("C:\\Users\\Lucho\\Desktop\\ejemplo", "C:\\Users\\Lucho\\Desktop\\ejemplo2");
	
		
}
	
	
	
	
	public static void listarArchivos(File archivoParametro)
	{

				File[] archivo = archivoParametro.listFiles();
				
				
				for (int i = 0; i < archivo.length; i++){
				    
					String especifico = archivo[i].getName();
					
					System.out.println(especifico);
				}
			
	}
	
	
	
	
	// EJERCICIO 01 -- ESCRIBIR DESDE CONSOLA.
	public static void writeDesdeConsola (File archivo)
	{
		try
		{
			System.out.println("Ingrese el texto: ");
			
			Scanner sc = new Scanner(System.in);
			
			String texto = sc.next();
			
			
			FileWriter fw = new FileWriter(archivo, true); // Sobreescribe con true.
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(texto);
			bw.flush(); // Llena el buffer, y se escribe el archivo. 
			bw.close(); // Cierra el archivo.
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	// EJERCICIO 02 -- CLONAR BINARIO.
	

	public static void writeBinario(File origenParametro, File copiaParametro)
	{
		File origen = origenParametro;
		File copia = copiaParametro;
		
		try {
			
			FileInputStream fis = new FileInputStream(origen); // ESTE ARCHIVO TIENE 1025.
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = new FileOutputStream(copia); // SE COPIA HASTA 1024.
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			byte[] buffer = new byte[1024];
			
			int cantidad = 0;
			
			while ((cantidad = bis.read(buffer)) >-1){
				bos.write(buffer, 0, cantidad);  // LEE DEL BUFFER. COPIA DESDE 0 A CANTIDAD (1024) -> Necesita otra iteración, copia desde 1024 hasta la cantidad restante (que es 1).
			}
			
			bos.flush();
			bis.close();
			bos.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	
	
	// EJERCICIO 03 -- CLONAR DIRECTORIO.

	public static void clonarDirectorio(File origenParametro, File copiaParametro)
	{
		
		System.out.println(origenParametro.isDirectory());
		System.out.println(copiaParametro.isDirectory());
	
		if (origenParametro.isDirectory())
		
		{

			try {
				
				File[] archivo = origenParametro.listFiles();
				
				for (int i = 0; i < archivo.length; i++)
				{
				    
					String especifico = archivo[i].getName();
					
					System.out.println(especifico);
					
					
					FileInputStream fis = new FileInputStream(archivo[i]); // ESTE ARCHIVO TIENE 1025.
					BufferedInputStream bis = new BufferedInputStream(fis);
		
					FileOutputStream fos = new FileOutputStream(copiaParametro); // SE COPIA HASTA 1024.
					BufferedOutputStream bos = new BufferedOutputStream(fos);
		
					
					byte[] buffer = new byte[1024];
					
					int cantidad = 0;
					
					while ((cantidad = bis.read(buffer)) >-1)
					{
						bos.write(buffer, 0, cantidad);  // LEE DEL BUFFER. COPIA DESDE 0 A CANTIDAD (1024) -> Necesita otra iteración, copia desde 1024 hasta la cantidad restante (que es 1).
					}
					
					bos.flush();
					bis.close();
					bos.close();
					
				}
				
				
		
			} catch (FileNotFoundException e) {
		
				e.printStackTrace();
				
			} catch (IOException e) {
		
				e.printStackTrace();
			}
		}
		
		else
		{
			System.out.println("No es un directorio");
		}
		
	}
	
	
	
	// PRUEBAS:
	
	private static void copiarDirectorio(String origen, String destino) {
	    comprobarCrearDirectorio(destino);
	    
	    File directorio = new File(origen);
	    File f;
	    
	    if (directorio.isDirectory()) 
	    {
	        comprobarCrearDirectorio(destino);
	        
	        String [] files = directorio.list();
	        
	        if (files.length > 0) 
	        {
	            for (String archivo : files) 
	            {
	                f = new File (origen + File.separator + archivo);
	               
		                if(f.isDirectory()) 
		                {
		                    comprobarCrearDirectorio(destino+File.separator+archivo+File.separator);
		                    copiarDirectorio(origen+File.separator+archivo+File.separator, destino+File.separator+archivo+File.separator);
		                } 
		                
		                else 
		                { //Es un archivo
		                    copiarArchivo(origen+File.separator+archivo, destino+File.separator+archivo);
		                }
	            }
	        }
	    }
	}
	
	
	
	private static void comprobarCrearDirectorio(String ruta) {
	    File directorio = new File(ruta);
	    if (!directorio.exists()) 
	    {
	        directorio.mkdirs();
	    }
	}
	
	
	
	private static void copiarArchivo(String sOrigen, String sDestino) {
	    
		try {
	        File origen = new File(sOrigen);
	        File destino = new File(sDestino);

			FileInputStream fis = new FileInputStream(origen);
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = new FileOutputStream(destino); 
			BufferedOutputStream bos = new BufferedOutputStream(fos);
	        

			byte[] buffer = new byte[1024];
			
			int cantidad = 0;
			
			while ((cantidad = bis.read(buffer)) >-1)
			{
				bos.write(buffer, 0, cantidad);  
			}
			
			bos.flush();
			bis.close();
			bos.close();
	        
	       
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
// TODO : Este metodo está mal escrito. Hay que optimizarlo.
public static void write (File prueba)
	{
		try
		{
			FileWriter fw = new FileWriter(prueba);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			bw.write("Hola mundo");
			bw.flush(); // Llena el buffer, y se escribe el archivo. 
			bw.close(); // Cierra el archivo.
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


public static void writeBienHecho (File prueba)
	{
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(prueba)))
		{
			bw.write("Hola mundo");
			bw.flush(); // Llena el buffer, y se escribe el archivo. 
			bw.close(); // Cierra el archivo.
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	
//TODO : Este metodo está mal escrito. Hay que optimizarlo.
public static void read (File prueba)
	{
		try 
		{
			FileReader fr = new FileReader(prueba);
			BufferedReader br = new BufferedReader(fr);
			
			String s = br.readLine();

			while (s != null)
			{
				s = br.readLine();
				System.out.println(s);
			}
			
			br.close();		
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}


//TODO : Este metodo está mal escrito. Hay que optimizarlo.
public static void readBienHecho (File prueba)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(prueba))) 
		{
			
			String s = br.readLine();

			while (s != null)
			{
				s = br.readLine();
				System.out.println(s);
			}
			
			br.close();		
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	
}

	
