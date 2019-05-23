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

public class audioPlayerjtaAD
{
	private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private String musictoplay;
	private ArrayList<String> uio = new ArrayList<>();
	private Clip clp;
    private Boolean playing=false;
    AudioInputStream audioInputStream; 
    	Clip clip; 
	
	public ArrayList<String> getsongs()
	{
		File dir = new File("music");
			File[] list = dir.listFiles();
			for(File file : list)
			{
				if(file.getName().endsWith(".wav"))
					{
						uio.add(file.getName());
						
					}
			}
			
			
			return uio;
	}
	
	public String search(String fileName)
	{
		String ans="";
           for (String string : uio) {
               if(string.matches(fileName)){
                   ans = string;
                   break;
               }
               
           }
		return ans;
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
		playing=false;
	}
}