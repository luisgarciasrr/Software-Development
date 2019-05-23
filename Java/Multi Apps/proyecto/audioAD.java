import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
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
import java.nio.file.*;
import java.util.stream.Stream;
import java.lang.Exception;
import java.io.IOException;
import java.applet.*;
import java.net.*;
import javax.sound.sampled.*;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;  
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 




public class audioAD 
{
	private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private String musictoplay;
    private Clip clp;
    private long dat;
    private Boolean playing=false;
	
	
	ArrayList<String> uio = new ArrayList<>();
	// to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 
    
    	
	public ArrayList<String> getsongs()
	{
		File dir = new File("music");
			File[] list = dir.listFiles();
			for(File file : list)
			{
				if(file.isDirectory())
				{
					
				}
				else
				{
					if(file.getName().endsWith(".wav"))
					{
						uio.add(file.getName());
						
					}
					
				}
			}
			
			
			return uio;
	}
	
	public void play(String fileName) 
    {
    	
    	if(playing == false)
    	{
    			musictoplay = fileName;
				try {
				File soundFile = new File(musictoplay);
				AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
			
			  DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			  clip = (Clip) AudioSystem.getLine(info);
			  clip.open(sound);
			  clip.start();
				}
			catch (LineUnavailableException | IOException
                    | UnsupportedAudioFileException e) {
                
            }
            playing = true;
    	}
    	
    	else
    	{
    		
    	}
		
	}
		
	public void stop()
	{
		clip.stop();
		dat=0;
		playing=false;
	}
	
	public void pause(){
		dat = clip.getMicrosecondPosition();
		clip.stop();
		
	}
	
	public void continua()
	{
		clip.setMicrosecondPosition(dat);
		clip.start();
	}
	
}
