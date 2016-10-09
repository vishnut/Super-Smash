import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;
import java.util.ArrayList;


public class JT4
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();

		ArrayList<SSB> characters=new ArrayList<SSB>();
		Bgrd k=new Bgrd();
		j.setSize(1324, 870);
		j.add(k);
		k.setVisible(true);

		playAudio("sng.au");


  		Kirby l = new Kirby(10,10);
		//j.setSize(l.getSize());
		j.add(l);
		j.addKeyListener(l);
		l.setVisible(true);
		characters.add(l);

		Yoshi h = new Yoshi(800,10);
		//j.setSize(l.getSize());
		j.add(h);
		j.addKeyListener(h);
		h.setVisible(true);
		characters.add(h);

		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void playAudio(String filename)
	{
		InputStream in = null;
		AudioStream as = null;
		try
		{
			//create audio data source
			in = new FileInputStream(filename);
		}
		catch(FileNotFoundException fnfe){System.out.println("The audio file was not found");}
		try
		{
		//create audio stream from file stream
		as = new AudioStream(in);
		}
		catch(IOException ie){System.out.println("Audio stream could not be created");}

		AudioPlayer.player.start(as);

	}
}










