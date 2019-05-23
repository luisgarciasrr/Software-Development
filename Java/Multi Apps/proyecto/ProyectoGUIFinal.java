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

public class ProyectoGUIFinal extends JFrame implements ActionListener
{
	
	private JMenuBar mb_principal;
	private JMenu m_combina,m_manejoar,m_calculos, m_conversores, m_AudioPlayer, jmi_audiowav,jmi_audiomp3, m_manejodearchivos,m_autos;
	private JMenuItem jmi_exponencial,jmi_factorial,jmi_ecuacion,jmi_cfc,jmi_ccf, jmi_salir, jmi_tabla , jmi_cal,jmi_libreria;
	private JMenuItem sjmi_audiowav,sjmi_audiomp3,sjmi_audiowavjta,sjmi_audiowavr,jmi_autos, jmi_comb;
	private JMenuItem sjmi_libi,sjmi_Autos;
	private JPanel pnl_uno;
	private exponencialGUI exponencial = new exponencialGUI();
	private factorialGUI factorial = new factorialGUI();
	private EcuacionGUI4 ecuacion = new EcuacionGUI4();
	private deFaC fac = new deFaC();
	private deCaF caf = new deCaF();
	private LibroGUImagenes libI=new LibroGUImagenes();
	private tablaGUI tab = new tablaGUI();
	private Calculadora calc = new Calculadora();
	private audioPlayer aup = new audioPlayer();
	private OaudioPlayer oap = new OaudioPlayer();
	private audioPlayerjta wavjta = new audioPlayerjta();
	private AudioPlayerJList mp3 = new AudioPlayerJList();
	private LibroGUI ib=new LibroGUI();
	private AutosGUI autnormal = new AutosGUI();
	private AutosGUImagen autimag = new AutosGUImagen();
	private iTunesGUI comb = new iTunesGUI();
	private Panel pan1,pan2;
	private JPanel pn1,pn2,pn3;
	public ProyectoGUIFinal()
	{
		super("Proyecto");
		mb_principal = new JMenuBar();
		m_combina = new JMenu("Wav & Mp3");
		m_autos = new JMenu("Autos");
		m_calculos = new JMenu("Calculos");
		m_manejodearchivos = new JMenu("Manejo de archivos");
		m_manejoar = new JMenu("Libreria");
		m_conversores = new JMenu("Conversion de U.");
		m_AudioPlayer = new JMenu("Reproductores de audio");
		jmi_exponencial = new JMenuItem("Elevar X a Y");
		jmi_comb = new JMenuItem("Wav & mp3");
		jmi_factorial = new JMenuItem("Factorial de un numero");
		jmi_ecuacion = new JMenuItem("Ecuaciones de segundo grado");
		jmi_tabla = new JMenuItem("Tabla de multiplicar");
		jmi_cal = new JMenuItem("Calculadora");
		jmi_cfc = new JMenuItem("De Farenheit a Celcius");
		jmi_ccf = new JMenuItem("De Celcius a Farenheit");
		jmi_audiowav = new JMenu("Reproductor wav");
		jmi_libreria= new JMenuItem("Libreria normal");
		jmi_autos = new JMenuItem("Autos con imagenes");
		sjmi_Autos = new JMenuItem("Autos normal");
		sjmi_libi = new JMenuItem("Libreria con imagenes");
		jmi_audiomp3 = new JMenu("Reproductor mp3");
		sjmi_audiowavr = new JMenuItem("Reproductor Wav");
		sjmi_audiowav = new JMenuItem("Catalogo de canciones en JList");
		sjmi_audiomp3 = new JMenuItem("Reproductor solo mp3");
		sjmi_audiowavjta = new JMenuItem("Cargar lista en JTextArea");
		jmi_salir = new JMenuItem("Salir");
		pnl_uno = new JPanel();
		pan1 = new Panel();
		pan2 = new Panel();
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn2 = new JPanel();
		
		//Action Listener's
		jmi_comb.addActionListener(this);
		jmi_autos.addActionListener(this);
		sjmi_Autos.addActionListener(this);
		sjmi_audiowavr.addActionListener(this);
		jmi_exponencial.addActionListener(this);
		jmi_factorial.addActionListener(this);
		jmi_ecuacion.addActionListener(this);
		jmi_cfc.addActionListener(this);
		jmi_ccf.addActionListener(this);
		jmi_salir.addActionListener(this);
		jmi_tabla.addActionListener(this);
		jmi_cal.addActionListener(this);
		sjmi_audiowav.addActionListener(this);
		sjmi_audiomp3.addActionListener(this);
		sjmi_audiowavjta.addActionListener(this);
		jmi_libreria.addActionListener(this);
		sjmi_libi.addActionListener(this);
		sjmi_Autos.addActionListener(this);
		//Agregar sub items
		jmi_audiowav.add(sjmi_audiowavr);
		jmi_audiowav.add(sjmi_audiowavjta);
		jmi_audiowav.add(sjmi_audiowav);
		jmi_audiomp3.add(sjmi_audiomp3);
		m_manejoar.add(sjmi_libi);
		m_manejoar.add(jmi_libreria);
		m_autos.add(sjmi_Autos);
		m_autos.add(jmi_autos);
		m_combina.add(jmi_comb);
		
		
		//Agregar Items a los menus
		m_calculos.add(jmi_exponencial);
		m_calculos.add(jmi_factorial);
		m_calculos.add(jmi_ecuacion);
		m_calculos.add(jmi_tabla);
		m_calculos.add(jmi_cal);
		m_calculos.add(jmi_salir);
		m_conversores.add(jmi_cfc);
		m_conversores.add(jmi_ccf);
		m_AudioPlayer.add(jmi_audiowav);
		m_AudioPlayer.add(jmi_audiomp3);
		m_AudioPlayer.add(m_combina);
		m_manejodearchivos.add(m_manejoar);
		m_manejodearchivos.add(m_autos);
		
		//Menu Bar a menu
		mb_principal.add(m_calculos);
		mb_principal.add(m_conversores);
		mb_principal.add(m_AudioPlayer);
		mb_principal.add(m_manejodearchivos);
		
		//Make visible
		setJMenuBar(mb_principal);
		setSize(550,550);
		//Center Form in Screen
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setExtendedState( getExtendedState()|JFrame.MAXIMIZED_BOTH );
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==jmi_comb){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = comb.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		if(event.getSource() == sjmi_Autos){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = autnormal.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_autos){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = autimag.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == sjmi_audiowavjta){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = wavjta.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == sjmi_audiowavr){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = oap.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == sjmi_audiomp3){
				//Reproductor de mp3 solamente
				pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = mp3.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_libreria){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = ib.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == sjmi_libi){
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = libI.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_exponencial)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = exponencial.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_factorial)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = factorial.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_ecuacion)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = ecuacion.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_cfc)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = fac.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_ccf)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = caf.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_tabla)
		{
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = tab.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
		}
		
		if(event.getSource() == jmi_cal)
		{
			
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = calc.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
            
		}
		
		if(event.getSource() == sjmi_audiowav)
		{
			
			pn1.setVisible(false);
			pnl_uno.setVisible(false);
            pnl_uno = aup.getpnl_dos();
            pnl_uno.setVisible(true);
            add(pnl_uno);
            setVisible(true);
            
		}
		
		if(event.getSource() == jmi_salir)
		{
			System.exit(0);
		}	
			
	}
	
	
	public static void main(String args[])
	{
		new ProyectoGUIFinal();
		
	}
}

