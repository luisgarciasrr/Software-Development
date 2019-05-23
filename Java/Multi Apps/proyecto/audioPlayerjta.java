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

public class audioPlayerjta extends JFrame implements ActionListener
{
	//Variables y objetos
	private JButton btn_play,btn_list,btn_search,btn_stop;
	private Boolean selected = false;
	private JTextArea jta_songs;
	private JPanel pnl_contenedor,pnl_contenedor2,pnl_contenedor3;
	private JTextField jtf_search;
	private String status="";
	private JLabel jlb_status;
	private String str_nametoplay;
	private audioPlayerjtaAD obj = new audioPlayerjtaAD();
	private ArrayList<String> red = new ArrayList<>();
	private JPanel pnl_lbl;
	private String res="",song,srch="";
	public audioPlayerjta()
	{
		super("Reproducir en text area");
		
		jlb_status = new JLabel(status);
		jta_songs = new JTextArea(7,25);
		btn_play = new JButton("Play");
		btn_list = new JButton("List");
		btn_search = new JButton("Search");
		btn_stop = new JButton("Stop");
		pnl_contenedor = new JPanel();
		pnl_contenedor2 = new JPanel();
		pnl_contenedor3 = new JPanel();
		jtf_search = new JTextField();
		pnl_lbl = new JPanel();
		
		btn_list.addActionListener(this);
		btn_play.addActionListener(this);
		btn_search.addActionListener(this);
		btn_stop.addActionListener(this);
		
		pnl_contenedor.setLayout(new GridLayout(2,1));
		pnl_lbl.setLayout(new GridLayout(1,1));
		pnl_contenedor2.setLayout(new GridLayout(1,1));
		pnl_contenedor3.setLayout(new FlowLayout());
		jlb_status.setHorizontalAlignment(JLabel.CENTER);
		pnl_contenedor.add(jtf_search);
		pnl_contenedor.add(btn_search);
		pnl_lbl.add(jlb_status);
		pnl_contenedor2.add(btn_play);
		pnl_contenedor2.add(btn_stop);
		pnl_contenedor2.add(btn_list);
		pnl_contenedor3.add(pnl_contenedor);
		pnl_contenedor3.add(pnl_lbl);
		pnl_contenedor3.add(pnl_contenedor2);
		
		pnl_contenedor3.add(new JScrollPane(jta_songs));
		jta_songs.setEnabled(false);
		jta_songs.setDisabledTextColor(Color.black);
		
		btn_play.setEnabled(false);
		btn_stop.setEnabled(false);
		btn_search.setEnabled(false);
		
		add(pnl_contenedor3);
		setSize(450,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if( event.getSource() == btn_play){
			if(jtf_search.getText().equals("")){
				jlb_status.setText("Busca una cancion valida.");
			}
			else{
				if(song.isEmpty()){
					jlb_status.setText("Busca una cancion valida.");
				}
				else{
					obj.play("music/" + song);
					btn_stop.setEnabled(true);
					btn_play.setEnabled(false);
				}
				
			}
		}
		
		if( event.getSource() == btn_search){
			srch = jtf_search.getText();
			song = obj.search(srch);
			if(song == ""){
				jlb_status.setText("No encontrada");
			}
			
			else{
				jlb_status.setText("Encontrada: " + song);
				btn_play.setEnabled(true);
				
			}
		}
		
		if(event.getSource() == btn_list){
			red = obj.getsongs();
			for (String s : red) {
        		jta_songs.append(s.toString() + "\n"); 
    			}
    		btn_search.setEnabled(true);
		}
		
		if(event.getSource() == btn_stop){
			obj.stop();
			btn_stop.setEnabled(false);
		}
	}
	
	public JPanel getpnl_dos()
	{
		
		return pnl_contenedor3;
	}
	
	
	public static void main(String args[])
	{
		new audioPlayerjta();
	}
}