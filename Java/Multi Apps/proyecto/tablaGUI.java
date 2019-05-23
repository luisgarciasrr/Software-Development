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

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;

public class tablaGUI extends JFrame implements ActionListener
{
	
	private JTextField jtf_numero;
	private JTextArea jta_resultado;
	private JButton btn_calcular,btn_salir;
	private JPanel pnl_uno,pnl_dos;
	private ProyectoDP obj = new ProyectoDP();
	
	public tablaGUI()
	{
		super("Tabla de multiplicar.");
		
		//Inicializacion de objetos
		jtf_numero = new JTextField();
		jta_resultado = new JTextArea(7,25);
		btn_calcular = new JButton("Calcular");
		btn_salir = new JButton("Salir");
		pnl_uno = new JPanel();
		pnl_dos = new JPanel();
		
		//Crear listeners
		btn_calcular.addActionListener(this);
		btn_salir.addActionListener(this);
		
		//Set layouts a paneles
		pnl_uno.setLayout(new GridLayout(7,25));
		pnl_dos.setLayout(new FlowLayout());
		
		//Agregar objetos a paneles;panel 1 a 2 y 2 a general
		pnl_uno.add(new JLabel("Numero:"));
		pnl_uno.add(jtf_numero);
		pnl_uno.add(btn_calcular);
		pnl_uno.add(btn_salir);
		
		pnl_dos.add(pnl_uno);
		pnl_dos.add(new JScrollPane(jta_resultado));
		
		add(pnl_dos);
		setSize(400,400);
		setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == btn_calcular)
		{
			int a;
			String datos,resultado,res;
			a = Integer.parseInt(datos = jtf_numero.getText() );
				resultado = obj.tab(a);
			res= "Tabla del numero: " + a + "\r\n";
			jta_resultado.setText(res+resultado);
			
		}
		
		if(event.getSource() == btn_salir)
		{
			pnl_dos.setVisible(false);
		}
	}
	
	public JPanel getpnl_dos()
    {
        return this.pnl_dos;
    }
	
	public static void main(String args[])
	{
		new tablaGUI();
		
	}
}