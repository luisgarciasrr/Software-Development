import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.lang.Math;
public class Calculadora extends JFrame implements ActionListener
{
    private JTextField tfNumero = new JTextField(8);
    
    private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear, bPunto;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bFactorial, bExpo, bRaiz, bCuadrado;
    private JPanel panel1, panel2,panel3;
    
    private float n1, n2;
    private String operacion = "";
    private String strNumero = "";
    private int base, x;
    private boolean punto=false;
    private int dot=0 ;
    private ProyectoDP obj = new ProyectoDP();
    
    public Calculadora()
    {
        super("Calculadora");
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(5,4));
        
        
        panel1.add(tfNumero);
        
        bClear = new JButton("clear");
        bClear.addActionListener(this);
        panel1.add(bClear);
        
        
        b7 = new JButton("7");
        b7.addActionListener(this);
        panel2.add(b7);
        
        b8 = new JButton("8");
        b8.addActionListener(this);
        panel2.add(b8);
        
        b9 = new JButton("9");
        b9.addActionListener(this);
        panel2.add(b9);
        
        bSuma = new JButton("+");
        bSuma.addActionListener(this);
        panel2.add(bSuma);
        
        b4 = new JButton("4");
        b4.addActionListener(this);
        panel2.add(b4);
        
        b5 = new JButton("5");
        b5.addActionListener(this);
        panel2.add(b5);
        
        b6 = new JButton("6");
        b6.addActionListener(this);
        panel2.add(b6);
        
        bResta = new JButton("-");
        bResta.addActionListener(this);
        panel2.add(bResta);
        
        b1 = new JButton("1");
        b1.addActionListener(this);
        panel2.add(b1);
        
        b2 = new JButton("2");
        b2.addActionListener(this);
        panel2.add(b2);
        
        b3 = new JButton("3");
        b3.addActionListener(this);
        panel2.add(b3);
        
        bMultiplica = new JButton("x");
        bMultiplica.addActionListener(this);
        panel2.add(bMultiplica);
        
        b0 = new JButton("0");
        b0.addActionListener(this);
        panel2.add(b0);
        
        bPunto = new JButton(".");
        bPunto.addActionListener(this);
        panel2.add(bPunto);
        
        bIgual = new JButton("=");
        bIgual.addActionListener(this);
        panel2.add(bIgual);
        
        bDivide = new JButton("/");
        bDivide.addActionListener(this);
        panel2.add(bDivide);
        
        bFactorial = new JButton("x!");
        bFactorial.addActionListener(this);
        panel2.add(bFactorial);
        
        bRaiz = new JButton("sqrt(x)");
        bRaiz.addActionListener(this);
        panel2.add(bRaiz);
        
        bCuadrado = new JButton("x^2");
        bCuadrado.addActionListener(this);
        panel2.add(bCuadrado);
        
        bExpo = new JButton("y^x");
        bExpo.addActionListener(this);
        panel2.add(bExpo);
        
        
        setLayout(new FlowLayout());
        add(panel1);
        add(panel2);
        setSize(350,220);
        
    }
    
    public JPanel getpnl_dos()
    {
    	panel3.add(panel1);
    	panel3.add(panel2);
    	return this.panel3;
    }
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        String str;
        float resultado = 0;
        int n = 0;
        int expo=0;
        
        
        // 1. Checar el click a un numero
        if(e.getSource() == bPunto)
        {
        	if(dot==0)
        	{
        	strNumero = strNumero+".";
            tfNumero.setText(strNumero);
            dot++;	
        	}
            else{
            	
            }
            
        }
        
        if(e.getSource() == b1)
        {
            strNumero = strNumero+1;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b2)
        {
            strNumero = strNumero+2;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b3)
        {
            strNumero = strNumero+3;
            tfNumero.setText(strNumero);
        }
        
      if(e.getSource() == b4)
        {
            strNumero = strNumero+4;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b5)
        {
            strNumero = strNumero+5;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b6)
        {
            strNumero = strNumero+6;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b7)
        {
            strNumero = strNumero+7;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b8)
        {
            strNumero = strNumero+8;
            tfNumero.setText(strNumero);
        }
        
        if(e.getSource() == b9)
        {
            strNumero = strNumero+9;
            tfNumero.setText(strNumero);
        }
        if(e.getSource() == b0)
        {
            strNumero = strNumero+0;
            tfNumero.setText(strNumero);
        }
        // 2. Checar bontones de operaciones
        if(e.getSource() == bSuma)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            operacion = "suma";
            tfNumero.setText("");
            strNumero = "";
            dot=0;
        }
        
        if(e.getSource() == bResta)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            operacion = "resta";
            tfNumero.setText("");
            strNumero = "";
            dot=0;
        }
        
        if(e.getSource() == bMultiplica)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            operacion = "multi";
            tfNumero.setText("");
            strNumero = "";
            dot=0;
        }
        
        if(e.getSource() == bDivide)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            operacion = "div";
            tfNumero.setText("");
            strNumero = "";
            dot=0;
        }
        
        if(e.getSource() == bRaiz)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            double t = Math.sqrt(n1);
            tfNumero.setText(Double.toString(t));
            dot=0;
        }
        
        if(e.getSource() == bCuadrado)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            double t = n1*n1;
            tfNumero.setText(Double.toString(t));
            dot=0;
        }
        
        if(e.getSource() == bFactorial)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            String resultad;
			float limite=1,total=1;
			float cop;
			cop=n1;
			do
			{
			total = total * cop;
			cop--;
			}while(cop != limite);
		
		resultad = Float.toString(total);
            tfNumero.setText(resultad);
            dot=0;
        }
        
        if(e.getSource() == bExpo)
        {
            str = tfNumero.getText();
            n1  = Float.parseFloat(str);
            operacion = "expo";
            tfNumero.setText("");
            strNumero = "";
            dot=0;
        }
        
        // 3. Checar el boton de resultados
        if(e.getSource() == bIgual)
        {
            // Checar la operacion a realizar
            if(operacion.equals("expo"))
            {
                str = tfNumero.getText();
                n2  = Float.parseFloat(str);
                
                int i=1;
                float total=0;
                
                do{
                	total= total + (n1*n1);
                i++;
                }while(i!=n2);
                	
                
                resultado = total;
                
                tfNumero.setText(""+resultado);
            }
            
            if(operacion.equals("suma"))
            {
                str = tfNumero.getText();
                n2  = Float.parseFloat(str);
                
                resultado = n1 + n2;
                
                tfNumero.setText(""+resultado);
            }
            
            if(operacion.equals("resta"))
            {
                str = tfNumero.getText();
                n2  = Float.parseFloat(str);
                
                resultado = n1 - n2;
                
                tfNumero.setText(""+resultado);
            }
            
            if(operacion.equals("div"))
            {
                str = tfNumero.getText();
                n2  = Float.parseFloat(str);
                
                resultado = n1 / n2;
                
                tfNumero.setText(""+resultado);
            }
            
            if(operacion.equals("multi"))
            {
                str = tfNumero.getText();
                n2  = Float.parseFloat(str);
                
                resultado = n1 * n2;
                
                tfNumero.setText(""+resultado);
            }
            dot=0;
        }
        
        if(e.getSource() == bClear)
        {
            tfNumero.setText("");
            operacion = "";
            strNumero = "";
            n1 = 0;
            n2 = 0;
        }
    }
    
    public static void main(String args[])
    {
         new Calculadora();
        
    }
}
