import java.io.BufferedInputStream; 
import java.net.URL; 
import audio.javazoom.jl.player.Player; 

public class audioPlayermp3DA
{
	private URL url; 
    private float volume; 
    private Player player;  
 
    // constructor that takes the name of an MP3 resource and the volume 
    public audioPlayermp3DA4ererddres(URL url, float volume) { 
        this.url = url; 
        this.volume = volume; 
    } 
 
    public void close() {  
     if (player != null)  
      player.close();  
    } 
 
    // play the MP3 file to the sound card 
    public void play() { 
        try { 
            BufferedInputStream bis = new BufferedInputStream(url.openStream()); 
            player = new Player(bis, volume); 
        } 
        catch (Exception e) { 
            System.out.println("Problem playing file " + url); 
            e.printStackTrace(); 
        } 
 
        // run in new thread to play in background 
        new Thread() { 
            public void run() { 
                try {  
                 player.play();  
                } 
                catch (Exception e) {  
                 System.out.println(e);  
                } 
            } 
        }.start(); 
    } 
}