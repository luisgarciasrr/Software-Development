import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.io.*;
import java.util.*;

public class EditorAD
{
	private ImageIcon iconOk = new ImageIcon("/images/ok.png");
	private String nombre;
	private PrintWriter archivoOut;
	private BufferedReader archivoIn,archivoDatos;
	
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
	
	public String save(String dataToSave){
		String resultado="";
		//Abrir el archivo para datos
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