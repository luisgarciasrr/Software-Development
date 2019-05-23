import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AudioPlayerJList extends JFrame implements ActionListener, ListSelectionListener
{
	private JTextField tfSong;
	private JButton bPlay, bStop, bCatalog; 
	private JLabel lbSong;
	private JPanel panel1, panel2, panelSongs;
	private JTextArea taSongs;
	private JList listaSongs;
	private AudioADJList audioad=new AudioADJList();
	private Thread thrAudio;
	
	public AudioPlayerJList()
	{
		super("Reproductor de Audio WAV");
//		Crea los objetos de los atributos
		tfSong=new JTextField();
		bPlay= new JButton("Play");
		bStop= new JButton("Stop");
		bCatalog= new JButton("Catalogo");
		panel1= new JPanel();
		panel2= new JPanel();
		panelSongs= new JPanel();
		lbSong = new JLabel("Now playing...");
		taSongs= new JTextArea(10,20);
		
//		Poner addActionListener() a los botones

		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		bCatalog.addActionListener(this);
				
//		Definir los layouts para los panels
		panel1.setLayout(new GridLayout(3,2));
		panel2.setLayout(new FlowLayout());
		
		
		
//		3.Colocar los atributos en los panels correspondientes
		panel1.add(new JLabel("Cancion a reproducir: "));
		panel1.add(tfSong);
		panel1.add(bPlay);
		panel1.add(bStop);
		panel1.add(bCatalog);
		
		
		panel2.add(panel1);
		panel2.add(lbSong);
		panelSongs.add(new JScrollPane(taSongs));
		panel2.add(panelSongs);
		
//		4.Colocar panel2 en el JFrame y hacerlo visible 
		add(panel2);
		setSize(300,320);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		Hacer visible el JFrame
//		setSize(300,200);
//		setVisible(true);
	}
	
	public JPanel getpnl_dos(){
		return panel2;
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		String respuesta="", songs="";
		if(event.getSource()==bPlay)
		{
		//Obtener tfSong el nombre de la cancion
			String song= tfSong.getText();
			if (thrAudio!=null)
			thrAudio.stop();

			thrAudio=new Thread(new AudioJList(song));
			thrAudio.start(); //inicia el thread audioThread y ejecuta el método run() del objeto AudioJList
			
			lbSong.setText("Now playing..."+song);
		//Reproducir la cancion con audio2
//			respuesta=audio.reproducir(song);
			
//			lbSong.setText(respuesta);
		}
		if(event.getSource()==bStop)
			{
//				audio.stop();
				if (thrAudio!=null)
				thrAudio.stop();
			}
			
		/*	if (event.getSource()==bCatalog)
				{
//				songs=catalogo.mostrarDirectorio();
//				taSongs.setText(songs);
				String directorio[]=audioload.obtenerSongs();
				for(int i=1; i<directorio.length; i++)
				{
					songs=songs+ directorio[i]+"\n";
					System.out.println(directorio[i]);
				}
				taSongs.setText(songs);
			}*/
			
			if (event.getSource()==bCatalog)
				{
//				Obtener lista de songs
				String directorio[]=audioad.obtenerSongs();
				listaSongs=new JList(directorio);
				listaSongs.addListSelectionListener(this);
				
				panelSongs.setVisible(false);
				panelSongs.removeAll();
				panelSongs.add(listaSongs);
				panelSongs.setVisible(true);
				}
	
	}			
	//	  str = tfNumero.getText();
//            n1  = Float.parseFloat(str);
//            operacion = "expo";
//            tfNumero.setText("");
//            strNumero = "";

	public void valueChanged(ListSelectionEvent lse)
	{
		String song, respuesta;
		if(lse.getValueIsAdjusting()==true)
		{
		
		if (lse.getSource()== listaSongs)
		{
			song=(String)listaSongs.getSelectedValue();
			tfSong.setText(song);
//			audio.reproducir(song);
//			respuesta=audio.reproducir(song)
			//lbSong.setText(respuesta);
			System.out.println(song);
			
			if (thrAudio!=null)
			thrAudio.stop();

			thrAudio=new Thread(new AudioJList(song));
			thrAudio.start(); //inicia el thread audioThread y ejecuta el método run() del objeto AudioJList
			
			lbSong.setText("Now playing..."+song);
		}
		}
	}

	public static void main(String args[])
	{
		new AudioPlayerJList();
	}
}