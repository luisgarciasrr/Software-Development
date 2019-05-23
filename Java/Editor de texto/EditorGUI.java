import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.*;
import java.io.*;

public class EditorGUI extends JFrame implements ActionListener
{
	private JMenuBar  menuBar;
    private JMenu     menu, menuFile,mFile;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    private JMenuItem menuItemOpen, menuItemCopy, menuItemDelete, menuItemClose;
    private JMenuItem mFileOpen, mFileCopy, mFileDelete;
    private JTextArea taEditor= new JTextArea(20,40);
    private JPanel	  panel;
    private String    nombreArchivo="", archivoElegido;
    private Vector vectorFiles = new Vector();
    private JList  listaFiles  = new JList();
    private EditorAD obj = new EditorAD();
	private ArrayList<String> red = new ArrayList<>();
	private JTextArea taSongs;
	private JList aa;
	private JPanel panelSongs;
	private String nombre="";
	public EditorGUI(){
		super("Editor de texto");
		panelSongs= new JPanel();
		
		taSongs= new JTextArea(10,20);
		menuBar = new JMenuBar();
        menu    = new JMenu("Editor Basico");
        menuFile= new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        mFile = new JMenu("File");
        menuItemNew     = new JMenuItem("New");
        menuItemAbrir   = new JMenuItem("Open");
        menuItemOpen    = new JMenuItem("Open File");
        menuItemCopy    = new JMenuItem("Copy File");
        menuItemDelete  = new JMenuItem("Delete File");
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemClose   = new JMenuItem("Close");
        menuItemSalir   = new JMenuItem("Exit");
        mFileOpen = new JMenuItem("Open");
        mFileCopy = new JMenuItem("Copy");
        mFileDelete = new JMenuItem("Delete");
        
        
        menuItemOpen.setEnabled(false);
        menuItemCopy.setEnabled(false);
        menuItemDelete.setEnabled(false);
        
        menuItemNew.addActionListener(this);
        mFileOpen.addActionListener(this);
        mFileCopy.addActionListener(this);
        mFileDelete.addActionListener(this);
        menuItemAbrir.addActionListener(this);
        menuItemOpen.addActionListener(this);
        menuItemCopy.addActionListener(this);
        menuItemDelete.addActionListener(this);
        menuItemGuardar.addActionListener(this);
        menuItemGuardarAs.addActionListener(this);
        menuItemClose.addActionListener(this);
        menuItemSalir.addActionListener(this);
        mFile.add(mFileOpen);
        mFile.add(mFileCopy);
        mFile.add(mFileDelete);
        menu.add(menuItemNew);
        menu.add(menuItemAbrir);
		menu.add(mFile);
        menu.add(menuItemGuardar);
        menu.add(menuItemGuardarAs);
        menu.add(menuItemClose);
        menu.add(menuItemSalir);
        
        menuBar.add(menu);
        
        menuItemNew.setEnabled(true);
		menuItemGuardar.setEnabled(false);
		menuItemGuardarAs.setEnabled(false);
        menuItemClose.setEnabled(false);
        
        taEditor.setLineWrap(true);
		
        taEditor.setFont(new Font("Georgia", Font.PLAIN, 19));
        panel.add(new JScrollPane(taEditor));
        panel.setVisible(false);
        panelSongs.setLayout(new GridLayout(1,1));
        
        setJMenuBar(menuBar);
        
        add(panel);
        setSize(800,550);
        setVisible(true);
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void habilita(){
		menuItemOpen.setEnabled(true);
        menuItemCopy.setEnabled(true);
        menuItemDelete.setEnabled(true);
	}
	
	public void deshabilita(){
		menuItemOpen.setEnabled(false);
        menuItemCopy.setEnabled(false);
        menuItemDelete.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == mFileOpen){
			nombre="";
			nombre = JOptionPane.showInputDialog("Nombre del archivo?");
			taEditor.selectAll();
    		taEditor.replaceSelection("");
				try
                {
                    FileReader reader = new FileReader( nombre );
                    BufferedReader br = new BufferedReader(reader);
                    taEditor.read( br, null );
                    br.close();
                    taEditor.requestFocus();
                    menuItemGuardar.setEnabled(true);
                    menuItemGuardarAs.setEnabled(true);
                    menuItemClose.setEnabled(true); 
                    	menuItemNew.setEnabled(false);
                    
                }
                catch(Exception e2) { System.out.println(e2); }
			
			}
			
			if(event.getSource() == mFileCopy){
			 nombre="";
			nombre = JOptionPane.showInputDialog("Nombre del archivo?");
			
			
						InputStream inStream = null;
				OutputStream outStream = null;
					
			    	try{
			    		
			    	    File afile =new File("./" + nombre);
			    	    nombre = nombre.substring(0,nombre.length()-3);
			    	    File bfile =new File("./" + nombre + "Copia" + ".txt");
			    		
			    	    inStream = new FileInputStream(afile);
			    	    outStream = new FileOutputStream(bfile);
			        	
			    	    byte[] buffer = new byte[1024];
			    		
			    	    int length;
			    	    
			    	    while ((length = inStream.read(buffer)) > 0){
			    	  
			    	    	outStream.write(buffer, 0, length);
			    	 
			    	    }
			    	 
			    	    inStream.close();
			    	    outStream.close();
			    	    taEditor.selectAll();
    		taEditor.replaceSelection("Archivo copiado con exito!");
			    	    
			    	    
			    	    
			    	    
			    	    
			    	}catch(IOException e){
			    	    e.printStackTrace();
			    	}
			
			
			}
			
			if(event.getSource() == mFileDelete){
			 nombre="";
			nombre = JOptionPane.showInputDialog("Nombre del archivo?");
			File file = new File("./" + nombre); 
          
		        if(file.delete()) 
		        { 
		        	JOptionPane.showMessageDialog(null,"Borrado exitosamente.");
		            
		        } 
		        else
		        { 
		            JOptionPane.showMessageDialog(null,"Fallo al borrar el archivo");
		        } 
			}

		if(event.getSource() == menuItemNew){
			// 0 = false, 1 = true & 2 = cancel
			int crear=0;
			
			do{
				crear = obj.create();
			}while(crear == 0);
			
		if(crear == 1){
			//Ingreso un nombre valido
			panel.setVisible(true);
			menuItemNew.setEnabled(false);
			menuItemGuardar.setEnabled(true);
			menuItemGuardarAs.setEnabled(true);
			menuItemClose.setEnabled(true);
			taEditor.selectAll();
    		taEditor.replaceSelection("");
		}	
			
		}
		
		if(event.getSource() == menuItemGuardar){
			String dataToSave="",comprobar="",resultado="";
			dataToSave = taEditor.getText();
			comprobar = dataToSave.replaceAll("\\s+","");
			if(comprobar.length() != 0){
				//Guardar texto en archivo, ya que no esta vacio
				resultado = obj.save(dataToSave,nombre);
			}
			
			else{
				//No guardar texto en archivo
				resultado="El archivo no puede estar vacio.";
			}
			
			JOptionPane.showMessageDialog(null,resultado);
			
			
			
		}
		
		if(event.getSource() == menuItemGuardarAs){
			String dataToSave="",comprobar="",resultado="";
			dataToSave = taEditor.getText();
			comprobar = dataToSave.replaceAll("\\s+","");
			if(comprobar.length() != 0){
				//Guardar texto en archivo, ya que no esta vacio
				resultado = obj.saveAs(dataToSave);
			}
			
			else{
				//No guardar texto en archivo
				resultado="El archivo no puede estar vacio.";
			}
			
			JOptionPane.showMessageDialog(null,resultado);
		}	
		
		if(event.getSource() == menuItemSalir){
			System.exit(0);
		}
		if(event.getSource() == menuItemClose){
			taEditor.selectAll();
    		taEditor.replaceSelection("");
    		panel.setVisible(false);
    		menuItemGuardar.setEnabled(false);
                    menuItemGuardarAs.setEnabled(false);
                    menuItemClose.setEnabled(false);
                    menuItemNew.setEnabled(true);
		}
		
		if(event.getSource() == menuItemAbrir){
			red.clear();
			taEditor.selectAll();
    		taEditor.replaceSelection("");
			red = obj.getfiles();
			
			for (String s : red) {
        		taEditor.append(s.toString() + "\n"); 
    			}
    		panel.setVisible(true);
		}
			
	}
		
	public void valueChanged(ListSelectionEvent lse)
    {   
        if(lse.getValueIsAdjusting() == true)
        {
            
        }
    }
	
	public static void main(String args[]){
		new EditorGUI();
	}
}
