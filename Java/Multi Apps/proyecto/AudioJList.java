import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import javazoom.jl.player.Player;

public class AudioJList implements Runnable
{
		private File audioFile;
		private FileInputStream fileInputStream;
		private BufferedInputStream bufferInputStream;
//		private Clip audioClip;
		private Player audioPlayer;
		
		private String audioSong;
		
		public AudioJList(String song){
			this.audioSong=song;
		}
		
		public void run()
		{
			reproducir(audioSong);
		}
		
	public String reproducir(String song) //throws Exception
	{
		String pathSongs="music/";
		String respuesta="Now playing:  ";

		try{
		
		audioFile = new File(pathSongs+song);
		fileInputStream=new FileInputStream(pathSongs+song);
		System.out.println(audioFile);
		fileInputStream=new FileInputStream(audioFile);
		bufferInputStream=new BufferedInputStream(fileInputStream);
		audioPlayer=new Player(bufferInputStream);
		audioPlayer.play();
		}
		catch(Exception e)
		{
			respuesta=respuesta+"Song not found";
			System.out.println("Error: "+e);
		}
		return respuesta;
	}
	public void stop()
		{
		audioPlayer.close();
	}
}