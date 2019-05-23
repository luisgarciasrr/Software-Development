import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class EditorGUI extends JFrame implements ActionListener
{
	private JMenuBar  menuBar;
    private JMenu     menu, menuFile;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    private JMenuItem menuItemOpen, menuItemCopy, menuItemDelete, menuItemClose;
    private JTextArea taEditor= new JTextArea(20,40);
    private JPanel	  panel;
    private String    nombreArchivo="", archivoElegido;
    private Vector vectorFiles = new Vector();
    private JList  listaFiles  = new JList();
    private EditorAD obj = new EditorAD();
	public EditorGUI(){
		super("Editor de texto");
		
		menuBar = new JMenuBar();
        menu    = new JMenu("Editor Basico");
        menuFile= new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        
        menuItemNew     = new JMenuItem("New");
        menuItemAbrir   = new JMenuItem("Open");
        menuItemOpen    = new JMenuItem("Open File");
        menuItemCopy    = new JMenuItem("Copy File");
        menuItemDelete  = new JMenuItem("Delete File");
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemClose   = new JMenuItem("Close");
        menuItemSalir   = new JMenuItem("Exit");
        
        
        menuItemOpen.setEnabled(false);
        menuItemCopy.setEnabled(false);
        menuItemDelete.setEnabled(false);
        
        menuItemNew.addActionListener(this);
        menuItemAbrir.addActionListener(this);
        menuItemOpen.addActionListener(this);
        menuItemCopy.addActionListener(this);
        menuItemDelete.addActionListener(this);
        menuItemGuardar.addActionListener(this);
        menuItemGuardarAs.addActionListener(this);
        menuItemClose.addActionListener(this);
        menuItemSalir.addActionListener(this);
        
        menu.add(menuItemNew);
        menu.add(menuItemAbrir);

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
        
        setJMenuBar(menuBar);
        
        add(panel);
        setSize(800,550);
        setVisible(true);
        setResizable(false);
		
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
		}	
			
		}
		
		if(event.getSource() == menuItemGuardar){
			String dataToSave="",comprobar="",resultado="";
			dataToSave = taEditor.getText();
			comprobar = dataToSave.replaceAll("\\s+","");
			if(comprobar.length() != 0){
				//Guardar texto en archivo, ya que no esta vacio
				resultado = obj.save(dataToSave);
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