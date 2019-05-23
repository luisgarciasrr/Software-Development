import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EcuacionGUI4 extends JFrame implements ActionListener
{
    private JTextField tfCoeficienteA, tfCoeficienteB, tfCoeficienteC;
    private JButton    bCalcular, bSalir;
    private JTextArea  taDatos;
    
    private JPanel panel1, panel2;
    
    private ProyectoDP obj = new ProyectoDP();
    
    public EcuacionGUI4()
    {
        super("ECUACION CUADRATICA");
        
        // 1. Creacion o inicializacion de los objetos de los atributos
        tfCoeficienteA = new JTextField();
        tfCoeficienteB = new JTextField();
        tfCoeficienteC = new JTextField();
        
        bCalcular = new JButton("Calcular");
        bSalir    = new JButton("Exit");
        
        // Adicionar addActionListener(this) a los JButtons
        bCalcular.addActionListener(this);
        bSalir.addActionListener(this);
        
        taDatos   = new JTextArea(7,17);
        
        panel1    = new JPanel();
        panel2   = new JPanel();
        
        // 2. Definir el Layout los JPanels
        panel1.setLayout(new GridLayout(5,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos de los atributos a los JPanels
        panel1.add(new JLabel("Coeficiente A = "));
        panel1.add(tfCoeficienteA);
        panel1.add(new JLabel("Coeficiente B = "));
        panel1.add(tfCoeficienteB);
        panel1.add(new JLabel("Coeficiente C = "));
        panel1.add(tfCoeficienteC);
        
        panel1.add(bCalcular);
        panel1.add(bSalir);
        
        // 4. Adicionar panel1 y taDatos al panel2
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        // 5. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(400,400);
        
    }
    
    public void actionPerformed(ActionEvent event)
    {
        int a, b, c;
        String strCoeficiente, resultado;
        
        if(event.getSource() == bCalcular)
        {
            // 1. Obtener valor de los coeficientes
            strCoeficiente = tfCoeficienteA.getText();
            a = Integer.parseInt(strCoeficiente);
            
            strCoeficiente = tfCoeficienteB.getText();
            b = Integer.parseInt(strCoeficiente);
            
            strCoeficiente = tfCoeficienteC.getText();
            c = Integer.parseInt(strCoeficiente);
            
            // 2. Calcular raices
            resultado = obj.calcularRaices(a,b,c);
            
            // 3. Desplegar resultado de las raices
            taDatos.setText(resultado);
        }
        
        if(event.getSource() == bSalir)
        {
            panel2.setVisible(false);
        }
    }
    
    public JPanel getpnl_dos()
    {
        return this.panel2;
    }
    
    public static void main(String args[])
    {
        EcuacionGUI4 ecuacion = new EcuacionGUI4();
    }
}
