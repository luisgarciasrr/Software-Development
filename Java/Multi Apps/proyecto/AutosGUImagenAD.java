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

public class AutosGUImagenAD
{
	private BufferedReader archivoIn,archivoDatos;
	private PrintWriter archivoOut;
	private ArrayList<String> mylist = new ArrayList<>();
	private Boolean resultado,encontrado;
	private Vector vectorEditoriales,vectorDatos,vectorImagenes;
	private ImageIcon imagenesLibros[];
	private String Modelo="",Marca="",ano="",Precio="",Plazas="";
		
	
	private StringTokenizer st;
	public String guardar(String dato)
	{
		String resultado="";
		//Abrir el archivo para datos
		try{
			//Si quitamos true, solo sobreescribimos la linea
			archivoOut = new PrintWriter(new FileWriter("Autos.txt",true))	;
		
		
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
	
	public String catalogo()
	{
		String Modelo="",Marca="",ano="",Precio="",Plazas="";
		String strDatos;
		String datos="";
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Autos.txt"));
		
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
			datos="No existen registros guardados en BD.";
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return datos;
	}
	
	public ImageIcon[] obtenerTodo()
	{
		
		String str,albums="",libro,autor,editorial;
		String strImagen="";
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Autos.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				Modelo = st.nextToken();
				Marca = st.nextToken();
				ano = st.nextToken();
				Precio = st.nextToken();
				Plazas = st.nextToken();
				
					vectorImagenes.add(Modelo);	
				
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
	
	public ArrayList<String> marca(String datos)
	{
		String Modelo="",Marca="",ano="",Precio="",Plazas="";
		String str,albums="",libro,autor,editorial,rest="";
		StringTokenizer st;
		mylist.clear();
 
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Autos.txt"));	
			
			//2 Leer los datos
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				Modelo = st.nextToken();
				Marca = st.nextToken();
				ano = st.nextToken();
				Precio = st.nextToken();
				Plazas = st.nextToken();
				
				if(Marca.equals(datos))
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
			mylist.add("No hay registros.");
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return mylist;
	}
	
	public ArrayList<String> modelo(String datos)
	{
		String Modelo="",Marca="",ano="",Precio="",Plazas="";
		String str,albums="",libro,autor,editorial,rest="";
		StringTokenizer st;
		mylist.clear();
 
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Autos.txt"));	
			
			//2 Leer los datos
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				Modelo = st.nextToken();
				Marca = st.nextToken();
				ano = st.nextToken();
				Precio = st.nextToken();
				Plazas = st.nextToken();
				
				if(Modelo.equals(datos))
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
			mylist.add("No hay registros.");
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return mylist;
	}
public ImageIcon[] obtenerImagenesau(String marca)
	{String strImagen="";
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Autos.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				Modelo = st.nextToken();
				Marca = st.nextToken();
				ano = st.nextToken();
				Precio = st.nextToken();
				Plazas = st.nextToken();
				
				if(Marca.equals(marca))
				{
					vectorImagenes.add(Modelo);	
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
				
			}
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			
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


public ImageIcon[] obtenerImagenesmod(String modelo)
	{String strImagen="";
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Autos.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				Modelo = st.nextToken();
				Marca = st.nextToken();
				ano = st.nextToken();
				Precio = st.nextToken();
				Plazas = st.nextToken();
				
				if(Modelo.equals(modelo))
				{
					vectorImagenes.add(Modelo);	
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
				
			}
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			
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

}