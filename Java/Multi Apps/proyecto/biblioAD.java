import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;

public class biblioAD
{
	private BufferedReader archivoIn,archivoDatos;
	private PrintWriter archivoOut;
	private ArrayList<String> mylist = new ArrayList<>();
	
	
	
	private Boolean resultado,encontrado;
	
	public String capturar(String dato)
	{
		String resultado="";
		//Abrir el archivo para datos
		try{
			//Si quitamos true, solo sobreescribimos la linea
			archivoOut = new PrintWriter(new FileWriter("Libros.txt",true))	;
		
		
		//Almacenar o escribir los datos en el archivo
		archivoOut.println(dato);
		//Cerrar archivo
		archivoOut.close();
		
		resultado="Captura correcta de los datos";
	}
		catch(IOException ioe){
			resultado="Error " + ioe;
			System.out.println("Error " + ioe);
			
		}
		
		return resultado;
	}
	
	public String consultarLibros()
	{
		String persona="",strDatos,nombre,libro,autor,editorial;
		String datos="";
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Libros.txt"));
		
		//2.Leer todos los datos del archivo
		//vectorDatos = new Vector();
		while(archivoDatos.ready())
		{
			strDatos = archivoDatos.readLine();
			
			 datos = datos + strDatos + "\n";
					
		}
		
		//3.Cerrar el archivo
		archivoDatos.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return datos;
	}
	
	public ArrayList<String> buscare(String datos)
	{
		String str,albums="",libro,autor,editorial,rest="";
		StringTokenizer st;
		
 
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorial.equals(datos))
				{
					rest=str;
					mylist.add(rest);
	
				}
				
				
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return mylist;
	}
	
}