import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class AutosGUI extends JFrame implements ActionListener{
	
	private ArrayList<String> list = new ArrayList<>();
    private JTextField tfModelo, tfMarca, tfano, tfPrecio, tfPlazas;
    private JButton    bCatalogo, bCatalogomarca,bGuardar, bModelo;
    private JTextArea  taDatos;
    private JPanel panel1, panel2,panelGestionLibros, panelPrincipal;
    private AutosGUIAD obj = new AutosGUIAD();
	
	public AutosGUI(){
		// 1. Crear objetos de los atributos
        panelGestionLibros = new JPanel();
        
        panelPrincipal = new JPanel();
        tfModelo    = new JTextField();
        tfMarca     = new JTextField();
        tfPrecio     = new JTextField();
        tfPlazas    = new JTextField();
        tfano = new JTextField();
        bGuardar   = new JButton("Guardar");
        bCatalogo  = new JButton("Catalogo");
        bCatalogomarca = new JButton("Catalogo por marca");
        bModelo      = new JButton("Consultar Modelo");
        taDatos     = new JTextArea(10,30);
        
        panel1      = new JPanel();
        panel2      = new JPanel();
        
        // 1.2 Adicionar addActionListener a los JButtons
        bGuardar.addActionListener(this);
        bCatalogo.addActionListener(this);
        bCatalogomarca.addActionListener(this);
        bModelo.addActionListener(this);
        
        // 2. Definir el Layout de los JPanels
        panel1.setLayout(new GridLayout(7,2));
        panel2.setLayout(new FlowLayout());
        panelGestionLibros.setLayout(new GridLayout(1,1));
        
        panelPrincipal.setLayout(new BorderLayout(3,3));
        
        // 3. Colocar los objetos en los JPanels
        panel1.add(new JLabel("Modelo: "));
        panel1.add(tfModelo);
        panel1.add(new JLabel("Marca: "));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Año: "));
        panel1.add(tfano);
        panel1.add(new JLabel("Precio: "));
        panel1.add(tfPrecio);
        panel1.add(new JLabel("Plazas "));
        panel1.add(tfPlazas);
        panel1.add(bGuardar);
        panel1.add(bCatalogo);
        panel1.add(bCatalogomarca);
        panel1.add(bModelo);
        
        panelGestionLibros.add(panel2);
        
        panelPrincipal.add(panelGestionLibros,BorderLayout.WEST);
        
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 4. Adicionar los JPanels al JFrame
        //add(panel2);
        add(panelPrincipal);
        //Tarea, bajar imagenes de los libros que usaremos para el ejemplo, todos JPG
        // 5. Visualizar el JFrame
        setSize(400,400);
        
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == bGuardar){
			String Modelo="",Marca="",ano="",Precio="",Plazas="",total,resultado;
			Modelo = tfModelo.getText();
			Marca = tfMarca.getText();
			ano = tfano.getText();
			Precio = tfPrecio.getText();
			Plazas = tfPlazas.getText();
			if(Modelo.isEmpty()||Marca.isEmpty()||ano.isEmpty()||Precio.isEmpty()||Plazas.isEmpty()){
				resultado = "Faltan datos.";
				
			}
			else{
				total = Modelo + "_" + Marca + "_" + ano + "_" + Precio + "_" + Plazas;
				resultado = obj.guardar(total);
			}
			taDatos.setText(resultado);
		}
		
		if(event.getSource() == bCatalogo){
			String resultado;
			resultado = obj.catalogo();
        	taDatos.setText(resultado);
		}
		
		if(event.getSource() == bCatalogomarca){
			String Marca="";
			Marca = tfMarca.getText();
			if(Marca.isEmpty())
			{
				taDatos.setText("Faltan Datos 'Marca'");
			}
			else{
				list = obj.marca(Marca);
				for(String a : list){
 				taDatos.append(a+"\n");
				}
			}
		}
		
		if(event.getSource() == bModelo){
			String Modelo="";
			Modelo = tfModelo.getText();
			if(Modelo.isEmpty())
			{
				taDatos.setText("Faltan Datos 'Modelo'");
			}
			else{
				list = obj.modelo(Modelo);
				for(String a : list){
 				taDatos.append(a+"\n");
				}
			}
		}
	}
	
	public JPanel getpnl_dos(){
		return panelPrincipal;
	}
	
	public static void main(String args[]){
		new AutosGUI();
	}
}