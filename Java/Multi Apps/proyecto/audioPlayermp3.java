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

public class audioPlayermp3 extends JFrame implements ActionListener
{
	private JButton btn_play, btn_stop, btn_list;
	private JPanel pnl_one, pnl_two;
	private JTextField jtf_one;
	private JList jl_one;
	
	public audioPlayermp3(){
		btn_list = new JButton("Catalogo");
		btn_play = new JButton("Play");
		btn_stop = new JButton("Stop");
		jtf_one = new JTextField();
		pnl_one = new JPanel();
		pnl_two = new JPanel();
		jl_one = new JList();
		pnl_one.setLayout(new GridLayout(5,2));
		pnl_two.setLayout(new FlowLayout());
		pnl_one.add(jtf_one);
		pnl_one.add(btn_list);
		pnl_one.add(btn_play);
		pnl_one.add(btn_stop);
		pnl_one.add(jl_one);
		pnl_two.add(pnl_one);
		add(pnl_two);
		jl_one.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl_one.setSelectedIndex(0);
		jl_one.setPreferredSize(new Dimension(300, 250));
		setSize(450,450);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
	}
	
	public JPanel getpnl_dos()
	{
		
		return pnl_two;
	}
	
	public static void main(String args[]){
		new audioPlayermp3();
	}
}