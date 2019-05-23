import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class OaudioPlayer extends JFrame implements ActionListener
{
	private JButton btn_play,btn_exit;
	private JTextField jtf_one;
	private JPanel pnl_uno,pnl_dos;
	private JLabel status;
	private OaudioPlayerAD obj = new OaudioPlayerAD();
	
	public OaudioPlayer(){
		//Inicializacion de los objetos
		status = new JLabel();
		btn_play = new JButton("Play");
		btn_exit = new JButton("Exit");
		jtf_one = new JTextField();
		pnl_uno = new JPanel();
		pnl_dos = new JPanel();
		jtf_one.setPreferredSize( new Dimension( 200, 24 ));
		btn_play.setPreferredSize( new Dimension( 50, 24 ));
		jtf_one.setPreferredSize( new Dimension( 200, 24 ));
		//Add action Listener's
		btn_play.addActionListener(this);
		btn_exit.addActionListener(this);
		
		//Establecer layouts
		pnl_uno.setLayout(new GridLayout(2,2));
		pnl_dos.setLayout(new FlowLayout());
		
		//Agregar a Paneles
		pnl_uno.add(jtf_one);
		pnl_uno.add(btn_play);
		pnl_uno.add(btn_exit);
		pnl_uno.add(status);
		pnl_dos.add(pnl_uno);
		
		//Agregar todo al JFrame
		add(pnl_dos);
		setSize(450,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == btn_play){
			String name,res;
			name=jtf_one.getText();
			res = obj.play(name);
			status.setText(res);
		}
		
		if(event.getSource() == btn_exit){
			pnl_dos.setVisible(false);
		}
	}
	
	public JPanel getpnl_dos()
	{
		
		return pnl_dos;
	}
	
	public static void main(String args[]){
		new OaudioPlayer();
	}
		
}