//librerias
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

public class exponencialGUI extends JFrame implements ActionListener
{
	private JButton btn_calcular,btn_salir;
	private JPanel pnl_uno, pnl_dos;
	private JTextField jtf_base,jtf_exponente;
	private JTextArea jta_resultado;
	
	private ProyectoDP obj = new ProyectoDP();
	
	public exponencialGUI()
	{
		super("Calcular Base a Exponente");
		
		
		//Creacion de los objetos
		btn_calcular = 	new JButton("Calcular");
		btn_salir = 	new JButton("Salir");
		jta_resultado = new JTextArea(7,25);
		pnl_uno = 		new JPanel();
		pnl_dos = 		new JPanel();
		jtf_base = 		new JTextField();
		jtf_exponente = new JTextField();
		
		//Crear listeners
		btn_salir.addActionListener(this);
		btn_calcular.addActionListener(this);
		
		//usar paneles
		pnl_uno.setLayout(new GridLayout(7,25));
		pnl_dos.setLayout(new FlowLayout());
		
		//Agregar objetos a paneles
		pnl_uno.add(new JLabel("Base:"));
		pnl_uno.add(jtf_base);
		pnl_uno.add(new JLabel("Exponente:"));
		pnl_uno.add(jtf_exponente);
		pnl_uno.add(btn_calcular);
		pnl_uno.add(btn_salir);
		
		pnl_dos.add(pnl_uno);
		pnl_dos.add(new JScrollPane(jta_resultado));
		add(pnl_dos);
				
		setSize(400,400);
		setResizable(false);
		
		
	}
	
	public JPanel getpnl_dos()
    {
        return this.pnl_dos;
    }
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == btn_calcular)
		{
			int a,b,c;
			String data,res;
			a = Integer.parseInt(data = jtf_base.getText());
			b = Integer.parseInt(data = jtf_exponente.getText());
			
			if(b == 0)
			{
				res = "El resultado es 1.\n";
			}
			else
			{
				res = obj.exp(a,b);	
			}
			
			jta_resultado.append(res);
			
		}
		
		if(event.getSource() == btn_salir)
		{
			pnl_dos.setVisible(false);
		}
	}
	
	public static void main(String args[])
	{
		exponencialGUI obj = new exponencialGUI();
	}
}