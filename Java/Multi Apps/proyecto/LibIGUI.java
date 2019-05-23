import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;

public class LibIGUI extends JFrame implements ActionListener
{
	private JTextField tfTitulo, tfAutor, tfEditorial;
    private JButton    bCapturar, bConsultar, bConsultarEditorial, bSalir;
    private JTextArea  taDatos,taImages;
    private JPanel panel1, panel2,panelGestionLibros, panelImages, panelPrincipal;
    
	public LibIGUI()
	{
		super("Biblioteca Tec");
        
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
        bSalir      = new JButton("Exit");
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
        panelPrincipal.add(panelImages,BorderLayout.WCenter);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar los JPanels al JFrame
        //add(panel2);
        add(panelPrincipal);
        //Tarea, bajar imagenes de los libros que usaremos para el ejemplo, todos JPG
        // 5. Visualizar el JFrame
        setSize(400,400);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		
	}
	
	public static void main(String args[]){
		
	}
}