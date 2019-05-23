import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.*;
import java.util.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;
import java.lang.Exception;
import java.io.IOException;
import java.applet.*;
import java.net.*;
import javax.sound.sampled.*;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;  
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
public class EditorAD
{
	private ImageIcon iconOk = new ImageIcon("/images/ok.png");
	private String nombre;
	private PrintWriter archivoOut;
	private BufferedReader archivoIn,archivoDatos;
	private ArrayList<String> uio = new ArrayList<>();
	
	public ArrayList<String> getfiles()
	{
		
		File dir = new File("./");
			File[] list = dir.listFiles();
			for(File file : list)
			{
						uio.add(file.getName());					
			}
			
			
			return uio;
	}
	
	public int create(){
		String fin="",resultado="";
		nombre="";
		// 0 = false, 1 = true & 2 = cancel
		nombre = JOptionPane.showInputDialog(null,"Nombre del nuevo archivo:","Nombre del nuevo archivo:",JOptionPane.INFORMATION_MESSAGE);
		
		
		if(nombre != null){
			fin = nombre.replaceAll("\\s+","");
			if(fin.length() != 0){
				//Si el nombre no son puros espacios
				return 1;
			}
			
			else{
				//Si el nombre son puros espacios
				return 0;
			}
				
		}
		
		else{
			return 2;
		}
		
	}
	
	public String save(String dataToSave,String nom){
		String resultado="";
		//Abrir el archivo para datos
		try{
			//Si quitamos true, solo sobreescribimos la linea
			archivoOut = new PrintWriter(new FileWriter(nom,true))	;
		
		
		//Almacenar o escribir los datos en el archivo
		archivoOut.println(dataToSave);
		//Cerrar archivo
		archivoOut.close();
		
		resultado="Guardado con exito como " + nom + " .";
	}
		catch(IOException ioe){
			resultado="Error " + ioe;			
		}
		return resultado;
	}
	
	public String saveAs(String dataToSave){
		String resultado="";
		boolean exist=true;
		nombre="";
		nombre = JOptionPane.showInputDialog(null,"Nombre del nuevo archivo:","Nombre del nuevo archivo:",JOptionPane.INFORMATION_MESSAGE);
		//Abrir el archivo para datos
		try{
			archivoDatos = new BufferedReader(new FileReader(nombre));
			while(archivoDatos.ready()){
				exist = true;
			}
			archivoDatos.close();
		}
		
		catch(FileNotFoundException dat){
			//Si no lo encuentra se puede crear uno  nuevo y guardar
			exist = false;
		}
		
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		
		if(exist == false){
			try{
			//Si quitamos true, solo sobreescribimos la linea
			archivoOut = new PrintWriter(new FileWriter(nombre,true))	;
		
		
		//Almacenar o escribir los datos en el archivo
		archivoOut.println(dataToSave);
		//Cerrar archivo
		archivoOut.close();
		
		resultado="Guardado con exito como " + nombre + " .";
			}
		catch(IOException ioe){
			resultado="Error " + ioe;			
		}
		}
		
		else{
			//Ya existe
			resultado = "Ese archivo ya existe...";
		}
		
		return resultado;
	}
}