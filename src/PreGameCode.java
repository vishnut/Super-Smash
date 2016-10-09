import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class PreGameCode
{
	public static void main(String...args) 
	{
		JFrame j = new JFrame();
		SuperSmashObjs m = new SuperSmashObjs();
		j.setSize(m.getSize());
		j.add(m);
  		j.addKeyListener(m);
  		
  		Kirby l = new Kirby();	
		l.setSize(j.getSize());
		j.add(l);
		l.setVisible(true);
  		
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}

class SuperSmashObjs extends JPanel implements KeyListener, ActionListener
{
	private Timer time; 
	private int startX, startY;
	private int add; 
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	
	public SuperSmashObjs() 
	{
		this.setPreferredSize(new Dimension(500, 500));
		
		startX = startY = 10; 
		time = new Timer(5, this);
		setSize(1324, 870);
		setVisible(true); 
		time.start();
		add = 10; 
	}
		
	 public void keyTyped(KeyEvent e)
	 {
		//System.out.println(e.getKeyCode());
		//key=e.getKeyCode();
		//m=e;
		//repaint();
	 } 
	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=true;
	 	else if(key==m.VK_RIGHT)
	 		ri=true;
	 	else if(key==m.VK_UP)
	 		u=true;
	 	else if(key==m.VK_DOWN)
	 		dow=true;
		m=e;
	 	repaint();
	 }
	 
	 
	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=false;
	 	else if(key==m.VK_RIGHT)
	 		ri=false;
	 	else if(key==m.VK_UP)
	 	{	u=false;t=0;}
	 	else if(key==m.VK_DOWN)
	 		dow=false;
		m=e;
	 	repaint();
	 }
	 	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 2000, 1000);
		try	
		{
			Image car = ImageIO.read(new File("stage1.jpg"));
			g.drawImage(car, 0, 0, null);
		}
		catch(Exception e)	{}
		
		 
		g.setColor(Color.MAGENTA);
		g.fillRect(startX, startY, 100, 100);
		this.setLocation(startX,startY);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	//if(dow==true)
	 		down();
		repaint();
	}
	
	public void jump() 
	{
		while(t<30)
		{	up();t++;}
		//while(t>10 && t<20)
		//{	down();t++;}	
		
	}
	
	
	public void right() 
	{
		if(startX!=1320)
			startX+=add;
		repaint();
	}
	
	public void left() 
	{
		if(startX!=10)
			startX-=add;
		repaint();
	}
	
	public void up() 
	{
		if(startY!=10)
			startY-=add;
		repaint();
	}
	
	public void down() 
	{
		if(!(startY==500 && (startX>200 &&startX<1020)) && !(startY==370 && (startX>270 &&startX<480)) && !(startY==370 && (startX>730 &&startX<950)) && !(startY==270 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		repaint();
	}
}

class Kirby extends SuperSmashObjs
{
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,5,25,5); 
		g.fillRect(25,10,45,5); 
		g.fillRect(20,15,20,5); g.fillRect(50,15,5,5); g.fillRect(65,15,10,5);
		g.fillRect(15,20,25,5); g.fillRect(50,20,5,5); g.fillRect(65,20,10,5);
		g.fillRect(15,25,25,5); g.fillRect(50,25,5,5); g.fillRect(65,25,10,5);
		g.fillRect(20,30,20,5); g.fillRect(50,30,5,5); g.fillRect(65,30,10,5);
		g.fillRect(10,30,5,5);
		g.fillRect(5,35,25,5); g.fillRect(50,40,25,5); g.fillRect(5,35,25,5); g.fillRect(50,35,10,5); g.fillRect(75,35,5,5);
		g.fillRect(0,40,75,5); 
		g.fillRect(5,45,5,5);
		g.fillRect(20,45,35,5); g.fillRect(60,45,15,5);
		g.fillRect(25,45,50,5);
		g.fillRect(30,50,45,5);
		g.fillRect(35,55,40,5);
		g.fillRect(40,60,15,5);
		g.fillRect(55,40,5,5);
		g.fillRect(40,15,5,20);
		g.fillRect(55,15,5,20);
		g.fillRect(25,40,20,5);
		g.fillRect(30,35,60,5);
		g.fillRect(40,30,50,5);
		g.fillRect(60,25,25,5);
		g.fillRect(60,20,25,5);
		g.fillRect(0,45,25,5);
		g.fillRect(5,50,25,5);
		g.fillRect(25,40,70,5);
		g.fillRect(25,45,70,5);
		g.fillRect(25,50,70,5);
		g.fillRect(35,60,30,5);
		
		
		g.setColor(new Color(0,0,0)); //Black
		g.fillRect(0,35,5,5);
		g.fillRect(70,10,5,5);
		g.fillRect(85,50,5,5);
		g.fillRect(10,55,5,5); g.fillRect(10,20,5,5);
		g.fillRect(80,55,5,5);
		g.fillRect(35,0,25,5); g.fillRect(60,5,10,5);
		g.fillRect(25,5,10,5);
		g.fillRect(20,10,5,5);
		g.fillRect(15,15,5,5);
		g.fillRect(10,25,5,5);
		g.fillRect(5,30,5,5); g.fillRect(15,30,5,5);
		g.fillRect(0,40,5,5); g.fillRect(0,45,5,5);
		g.fillRect(5,50,5,5); g.fillRect(15,50,5,5);
		g.fillRect(10,50,5,5);
		
		g.fillRect(75,15,5,5);
		g.fillRect(80,20,5,5);
		g.fillRect(80,25,5,5);
		g.fillRect(85,30,5,5);
		g.fillRect(90,35,5,5);
		g.fillRect(95,40,5,10);
		g.fillRect(90,50,5,5);
		g.fillRect(85,60,5,5);
		g.fillRect(90,65,5,10);
		g.fillRect(55,70,35,5);
		g.fillRect(55,65,5,5);
		g.fillRect(60,65,5,5);
		g.fillRect(65,60,5,5);
		g.fillRect(70,55,5,5);
		g.fillRect(75,55,5,5);
		g.fillRect(40,65,15,5);
		g.fillRect(0,70,45,5);
		g.fillRect(0,65,5,5);
		g.fillRect(5,60,5,5);
		g.fillRect(20,50,5,5);
		g.fillRect(25,55,5,5);
		g.fillRect(30,55,5,5);
		g.fillRect(35,60,5,5);
		g.fillRect(45,15,5,20);
		g.fillRect(60,15,5,20);
		
		g.fillRect(55,40,5,5);
		
		
		g.setColor(new Color(219,112,147)); //Darker Pink
		g.fillRect(15,55,10,5);
		g.fillRect(10,60,25,5);
		g.fillRect(5,65,35,5);
		g.fillRect(70,60,15,5);
		g.fillRect(65,65,25,5);
		
	}
}


