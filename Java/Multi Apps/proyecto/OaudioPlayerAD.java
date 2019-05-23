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

public class OaudioPlayerAD
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
    Clip clip;       
    AudioInputStream audioInputStream;
    
    public String play(String name){
    	String song = "music/" + name;
    	String res;
    			String musictoplay = song;
				try {
				File soundFile = new File(musictoplay);
				AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
			
			  DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
			  clip = (Clip) AudioSystem.getLine(info);
			  clip.open(sound);
			  clip.start();
			  res="Reproduciendo" + name;  
				}
			catch (LineUnavailableException | IOException
                    | UnsupportedAudioFileException e) { 
                    	res="	No existe esa canción.";    
            }
            return res;
    }
}