import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.util.Vector;

public class LibroGUImagenes extends JFrame implements ActionListener, ListSelectionListener
{
	private ArrayList<String> list = new ArrayList<>();
    private JTextField tfTitulo, tfAutor, tfEditorial;
    private JButton    bCapturar, bConsultar, bConsultarEditorial, bSalir;
    private JTextArea  taDatos,taImages;
    private JPanel panel1, panel2,panelGestionLibros, panelImages, panelPrincipal;
    private LibroGUImagenesAD obj = new LibroGUImagenesAD();
    private ImageIcon imagb[], imagb2[];
    private Vector vectorEditoriales,vectorLibros,vectorDatos,vectorImagenes;
    private JList  listaEditoriales,listaLibros,listaImagenes,listano;
    
    private ImageIcon imagenesLibros[];
    
    public LibroGUImagenes(){
    

        // 1. Crear objetos de los atributos
        panelGestionLibros = new JPanel();
        panelImages = new JPanel();
        panelPrincipal = new JPanel();
        tfTitulo    = new JTextField();
        tfAutor     = new JTextField();
        tfEditorial = new JTextField();
        bCapturar   = new JButton("Capturar datos");
        bConsultar  = new JButton("Consultar Libros");
        bConsultarEditorial = new JButton("Consultar Editorial");
        bSalir      = new JButton("Consultar Libro");
        taDatos     = new JTextArea(10,30);
        taImages = new JTextArea("Books Images",10,10);
        panel1      = new JPanel();
        panel2      = new JPanel();
        
        // 1.2 Adicionar addActionListener a los JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarEditorial.addActionListener(this);
        bSalir.addActionListener(this);
        
        // 2. Definir el Layout de los JPanels
        panel1.setLayout(new GridLayout(5,2));
        panel2.setLayout(new FlowLayout());
        panelGestionLibros.setLayout(new GridLayout(1,1));
        panelImages.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new BorderLayout(3,3));
        
        // 3. Colocar los objetos en los JPanels
        panel1.add(new JLabel("TITULO: "));
        panel1.add(tfTitulo);
        panel1.add(new JLabel("AUTOR: "));
        panel1.add(tfAutor);
        panel1.add(new JLabel("EDITORIAL: "));
        panel1.add(tfEditorial);
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarEditorial);
        panel1.add(bSalir);
        
        panelGestionLibros.add(panel2);
        panelImages.add(new JScrollPane(taImages));
        panelPrincipal.add(panelGestionLibros,BorderLayout.WEST);
        panelPrincipal.add(panelImages,BorderLayout.CENTER);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar los JPanels al JFrame
        //add(panel2);
        add(panelPrincipal);
        //Tarea, bajar imagenes de los libros que usaremos para el ejemplo, todos JPG
        // 5. Visualizar el JFrame
        setSize(400,400);
        
    }
    
   
    
    
    public void actionPerformed(ActionEvent e)
    {
        String datos, resultado,titulo;
        String aut,tit,edit, total;
       			
        if(e.getSource() == bCapturar)
        {
        	aut = tfAutor.getText();
            	tit = tfTitulo.getText();
            	edit = tfEditorial.getText();
            if(aut.isEmpty()||tit.isEmpty()||edit.isEmpty()){
            	taDatos.setText("Faltan datos");
            }
            else{            	
            	total = tit + "_" + aut + "_" + edit ;
            	resultado = obj.capturar(total);
            	taDatos.setText(resultado);
            }
        }
        
        if(e.getSource() == bConsultar)
        {
        		imagenesLibros = obj.obtenerTodo();
				listaImagenes = new JList(imagenesLibros);
				listaImagenes.addListSelectionListener(this);
				panelImages.setVisible(false);
				panelImages.removeAll();
				panelImages.add(new JScrollPane(listaImagenes));
				panelImages.setVisible(true);
				
        	resultado = obj.consultarLibros();
        	taDatos.setText(resultado);
        }
        
        if(e.getSource() == bConsultarEditorial)
        {
        	
        	aut = tfAutor.getText();
            tit = tfTitulo.getText();
            edit = tfEditorial.getText();
            if(edit.isEmpty()){
            	taDatos.setText("Faltan criterios de busqueda");	
            }
            else{
            String editorialElegida = tfEditorial.getText();
				imagenesLibros = obj.obtenerImagenesLibros(editorialElegida);
				listaImagenes = new JList(imagenesLibros);
				listaImagenes.addListSelectionListener(this);
				panelImages.setVisible(false);
				panelImages.removeAll();
				panelImages.add(new JScrollPane(listaImagenes));
				panelImages.setVisible(true);
            	list = obj.buscare(edit);
            	
            for(String a : list){
 			taDatos.append(a+"\n");
				}	
            }
            
        }
        
        if(e.getSource() == bSalir)
        {
        	String dato = tfTitulo.getText();
        	if(dato.isEmpty()){
        		taDatos.setText("Faltan criterios de busqueda.");
        	}
        	else{
        	titulo= tfTitulo.getText();
			imagb2=obj.obtenerDatosPRO(titulo);
			
			listaLibros= new JList(imagb2);
			listaLibros.addListSelectionListener(this);
				
			panelImages.setVisible(false);
			panelImages.removeAll();
			panelImages.add(listaLibros);
			panelImages.setVisible(true);	
			
				
        	}
            
        }
    }
    
    public JPanel getpnl_dos(){
    	return panelPrincipal;
    }
    
    public void valueChanged(ListSelectionEvent lse){
    	if(lse.getValueIsAdjusting()==true){
    		
    	}
    }
    
    public static void main(String args[])
    {
        new LibroGUImagenes();
    }
}
