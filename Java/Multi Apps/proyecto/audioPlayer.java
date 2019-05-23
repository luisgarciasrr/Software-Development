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

public class audioPlayer extends JFrame implements ActionListener
{
	private JButton btn_play, btn_stop, btn_pause, btn_continua, btn_next, btn_back;
	private JPanel pnl_one, pnl_two, pnl_three, pnl_bus, pnl_total,pnl_bus1;
	private JTextField jtf_title;
	private JTextArea jta_musiclist;
	private String songname;
	private Boolean bussy=false;
	private JButton btn_bus;
	private String pathSongs,listaf[],status="Reproduciendo: ";
	private audioAD obj = new audioAD();
	private JLabel lbl_status;
	private JList jt_one;
	private ArrayList<String> res = new ArrayList();
	private JScrollPane sp;
	private int totalsizejt,currentjt;
	private String alf[];
	private String currentpath,tot;
	
	public audioPlayer()
	{
		super("Audio");
		res = obj.getsongs();
		sp = new JScrollPane(jt_one);
		lbl_status = new JLabel(status);
		btn_bus = new JButton("Reproducir");
		btn_play = new JButton("Iniciar");
		btn_stop = new JButton("Detener");
		btn_pause = new JButton("Pausar");
		btn_continua = new JButton("Continuar");
		btn_next = new JButton("Siguiente");
		btn_back = new JButton("Anterior");
		pnl_one = new JPanel();
		
		jt_one = new JList(res.toArray());
		pnl_two = new JPanel();
		pnl_three = new JPanel();
		
		jtf_title = new JTextField();
		jta_musiclist = new JTextArea(7,25);
		jtf_title = new JTextField();
		pnl_bus = new JPanel();
		
		btn_bus.addActionListener(this);
		btn_play.addActionListener(this);
		btn_pause.addActionListener(this);
		btn_stop.addActionListener(this);
		btn_next.addActionListener(this);
		btn_back.addActionListener(this);
		btn_continua.addActionListener(this);
		
		jt_one.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    songname = jt_one.getSelectedValue().toString();
                    currentjt = jt_one.getSelectedIndex();
                    totalsizejt = jt_one.getModel().getSize();
                    jtf_title.setText(songname);
                }
            }
        });
		
		
		jt_one.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            if (me.getClickCount() == 2) {
            		obj.stop();
            		btn_next.setEnabled(true);
					btn_back.setEnabled(true);
					btn_pause.setEnabled(true);
					btn_stop.setEnabled(true);
					currentpath = Paths.get(".").toAbsolutePath().normalize().toString();
		//			currentpath = currentpath.replace("\\", "/");
					songname = jtf_title.getText();
					status = status + songname;
					tot = "music/" + songname;
					obj.play(tot);
					bussy=true;
            }
         }
      });	
		
		jtf_title.setPreferredSize( new Dimension( 200, 24 ) );
		
		pnl_one.setLayout(new GridLayout(5,2));
		pnl_two.setLayout(new FlowLayout());
		
		pnl_one.add(btn_back);
		pnl_one.add(btn_play);
		pnl_one.add(btn_next);
		pnl_one.add(btn_continua);
		
		pnl_one.add(btn_stop);
		pnl_one.add(btn_pause);
		pnl_one.add(lbl_status);
		
		pnl_three.add(jt_one);
		
		
		pnl_bus.add(jtf_title);
		pnl_bus.add(btn_bus);
		
		
		pnl_two.add(pnl_bus);
		pnl_two.add(pnl_one);
		pnl_two.add(pnl_three);
		
		
		
		
		btn_continua.setEnabled(false);
		btn_next.setEnabled(false);
		btn_back.setEnabled(false);
		btn_pause.setEnabled(false);
		btn_stop.setEnabled(false);
		add(pnl_two);
		jt_one.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt_one.setSelectedIndex(0);
		jt_one.setPreferredSize(new Dimension(300, 250));
		
		setSize(450,450);
		
		
		
	
	}
	
	public JPanel getpnl_dos()
	{
		
		return pnl_two;
	}
	
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		
		if(event.getSource() == btn_stop)
		{
			btn_next.setEnabled(false);
			btn_back.setEnabled(false);
			btn_pause.setEnabled(false);
			obj.stop();
			btn_continua.setEnabled(false);
			btn_stop.setEnabled(false);
		}
		if(event.getSource() == btn_play)
		{
			btn_next.setEnabled(true);
			btn_back.setEnabled(true);
			btn_pause.setEnabled(true);
			btn_stop.setEnabled(true);
			currentpath = Paths.get(".").toAbsolutePath().normalize().toString();
//			currentpath = currentpath.replace("\\", "/");
			
			songname = jtf_title.getText();
			tot = "music/" + songname;
			
			obj.play(tot);
		}
		if(event.getSource() == btn_next)
		{
			
			currentjt = jt_one.getSelectedIndex();
			if(currentjt == totalsizejt-1){
				currentjt=0;
			}
			
			else
			{
				currentjt++;
			}
			jt_one.setSelectedIndex(currentjt);
			songname = jtf_title.getText();
			tot = "music/" + songname;
			obj.stop();
			obj.play(tot);
			btn_pause.setEnabled(true);
			btn_continua.setEnabled(false);
			
			
			
		}
		if(event.getSource() == btn_back)
		{
			currentjt = jt_one.getSelectedIndex();
			if(currentjt == 0){
				currentjt=totalsizejt-1;
			}
			
			else
			{
				currentjt--;
			}
			jt_one.setSelectedIndex(currentjt);
			songname = jtf_title.getText();
			tot = "music/" + songname;
			obj.stop();
			obj.play(tot);
			btn_pause.setEnabled(true);
			btn_continua.setEnabled(false);
			
		}
		if(event.getSource() == btn_pause)
		{
			obj.pause();
			btn_continua.setEnabled(true);
			btn_pause.setEnabled(false);
		}
		if(event.getSource() == btn_continua)
		{
			obj.continua();
			btn_pause.setEnabled(true);
			btn_continua.setEnabled(false);
		}
		
		if(event.getSource() == btn_bus)
		{
			songname = jtf_title.getText();
			if(songname.endsWith(".wav")){
				int a = jt_one.getModel().getSize();
				for(i=;i<a;<++)
				btn_next.setEnabled(true);
			btn_back.setEnabled(true);
			btn_pause.setEnabled(true);
			btn_stop.setEnabled(true);
			currentpath = Paths.get(".").toAbsolutePath().normalize().toString();
//			currentpath = currentpath.replace("\\", "/");
			
			
			status = status + songname;
			tot = "music/" + songname;
			
			obj.play(tot);
			}
			else{
				
			}
			
		}
	}
	
	

	public static void main(String args[]) 
	{
		new audioPlayer();
		
	}
}