import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;
import java.util.*;

public class LibroGUImagenesAD
{
	private BufferedReader archivoIn,archivoDatos;
	private PrintWriter archivoOut;
	private Vector vectorEditoriales,vectorDatos,vectorImagenes;
	private ImageIcon imagenesLibros[];
	private ArrayList<String> mylist = new ArrayList<>();
	private Boolean resultado,encontrado;	
	private String str,albums="",libro,autor,editorial;
	private StringTokenizer st;
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
	
		public ImageIcon[] obtenerDatosPRO(String editorialElegida)
	{
		String strImagen="";
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorialElegida.equals(libro))
				{
					
					vectorImagenes.add(libro);	
				}
				
				
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			
			if(vectorImagenes.isEmpty()){
				imagenesLibros = new ImageIcon[1];
				strImagen="warn/nothing.jpg";
				imagenesLibros[0] = new ImageIcon(getClass().getResource(strImagen));
			}
			else{
				imagenesLibros = new ImageIcon[vectorImagenes.size()];
			for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			}	
			//4.Generar la lista de imagenes a partir del vector de albums
			
			
			
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return imagenesLibros;	
		
		
			
	}
	
public ImageIcon[] obtenerImagenesLibros(String editorialpro)
	{
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorialpro.equals(editorial))
				{
					vectorImagenes.add(libro);	
				}
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			if(vectorImagenes.isEmpty()){
				
			}
			
			else{
				
			}
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			String strImagen="";
			for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return imagenesLibros;
	}

public ImageIcon[] obtenerTodo()
	{
		String str,albums="",libro,autor,editorial;
		String strImagen="";
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
					vectorImagenes.add(libro);	
				
			}
			
			//3.Cerrar el archivo
			archivoIn.close();

				imagenesLibros = new ImageIcon[vectorImagenes.size()];
				for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			
			//4.Generar la lista de imagenes a partir del vector de albums
			
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
			
		return imagenesLibros;
	}

}