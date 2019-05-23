import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deFaC extends JFrame implements ActionListener
{
	private JButton btn_calcular,btn_salir;
	private JTextField jtf_grados;
	private JTextArea jta_resultado;
	private JPanel pnl_uno, pnl_dos;
	
	private ProyectoDP obj = new ProyectoDP();
	
	public deFaC()
	{
		super("De °F a °C");
		
		btn_calcular = new JButton("Calcular");
		btn_salir = new JButton("Salir");
		jtf_grados = new JTextField();
		jta_resultado = new JTextArea(7,25);
		pnl_uno = new JPanel();
		pnl_dos = new JPanel();
		
		btn_calcular.addActionListener(this);
		btn_salir.addActionListener(this);
		
		pnl_uno.setLayout(new GridLayout(7,25));
		pnl_dos.setLayout(new FlowLayout());
		
		pnl_uno.add(new JLabel("°Farenheit:"));
		pnl_uno.add(jtf_grados);
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
		if(event.getSource() == btn_calcular){
			float y;
			String datos,resultado;
			y = Float.parseFloat(datos = jtf_grados.getText());
			resultado=obj.dfc(y);
			
			jta_resultado.append(resultado);
			
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
		new deFaC();
	}
}