import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;
import java.awt.event.MouseListener.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.tools.JavaFileManager.Location;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent.*;



public class GT5
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();
		
		playAudio("sng.au");
		
		Bgrd k=new Bgrd();
		j.setSize(1324, 870);
		j.add(k);
		j.addMouseListener(k);
		j.addKeyListener(k);
		k.setVisible(true);
		
		j.setVisible(true);
		while(k.isready()!=true) //and kirb or yosh and lin or mari
		{
			Integer m=new Integer(3);
		}
			
		
		SSB mod=new SSB();
		
  		Kirby l = new Kirby(300,10,0);
		//j.setSize(l.getSize());
		j.add(l);
		j.addKeyListener(l);
		l.setVisible(true);
		

		Yoshi h = new Yoshi(800,10);
		//j.setSize(l.getSize());
		j.add(h);
		j.addKeyListener(h);
		h.setVisible(true);

		
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

class Bgrd extends JPanel implements KeyListener, MouseListener
{
	boolean ready;
	boolean kirb;
	boolean yosh;
	boolean mari;
	boolean lin;
	
	public Bgrd()
	{
		this.setPreferredSize(new Dimension(500, 500));
		ready=false;
		setSize(1324, 870);
		setVisible(true);
	}
	
	public boolean isready()
	{
		return ready;
	}
	public boolean mari()
	{
		return mari;
	}
	public boolean yosh()
	{
		return yosh;
	}
	public boolean lin()
	{
		return lin;
	}
	public boolean kirb()
	{
		return kirb;
	}
	
	public void mouseClicked(MouseEvent p) {
		System.out.println("a");
		ready=true;
	}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	public void keyTyped(KeyEvent e){}

	public void keyPressed(KeyEvent e)
	{
	 	System.out.println(e.getKeyCode());
		if(e.getKeyCode()==32)
	 		ready=true;
		//if(e.getKeyCode()==Mario2)
		//if(e.getKeyCode()==Link2)
		//if(e.getKeyCode()==Yoshi1)
		//if(e.getKeyCode()==Kirby1)
	 	repaint();
	}
	public void keyReleased(KeyEvent e)
	{
	}

	public void paintComponent(Graphics g)
	{

		if(ready)
		{
		try
		{
			Image car = ImageIO.read(new File("stage1.jpg"));
			g.drawImage(car, 0, 0, null);
		}
		catch(Exception e)	{}
		}
		else
		{
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 1324, 870);
			try
			{
				Image ras = ImageIO.read(new File("ss1.gif"));
				g.drawImage(ras, 100, 100, null);
			}
			catch(Exception e)	{}
		}
	}
}

class Loc
{
	int x;
	int y;
	
	public Loc(int k,int p)
	{
		x=k;
		y=p;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
}



class SSB extends JPanel implements KeyListener, ActionListener
{
	protected Timer time;
	protected int startX, startY;
	protected int add;
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	boolean att;
	int hp;
	//ArrayList<Loc> af;
	int wsd;
	Loc [] af;
	int jmp;
	
	public SSB()
	{
		this.setPreferredSize(new Dimension(500, 500));
		hp=100;
		af=new Loc[5];
		startX =10;
		startY=10;
		wsd=0;
		jmp=0;
		time = new Timer(60, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}
	
	
	public void addloc(int x,int y, int k)
	{
		Loc ag=new Loc(x,y);
		af[k]=ag;
	}

	public void keyTyped(KeyEvent e){}

	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=true;
	 	if(key==m.VK_RIGHT)
	 		ri=true;
	 	if(key==m.VK_UP)
	 		u=true;
	 	if(key==m.VK_DOWN)
	 		dow=true;
	 	if(key==16)
	 		att=true;
		m=e;
	 	repaint();
	}
	public void keyReleased(KeyEvent e)
	{
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=false;
	 	if(key==m.VK_RIGHT)
	 		ri=false;
	 	if(key==m.VK_UP)
	 	{	u=false;t=0;}
	 	if(key==m.VK_DOWN)
	 		dow=false;
	 	if(key==16)
	 		att=false;
		m=e;
	 	repaint();
	}

	public void dash()
	 {
		 if(le==true)
		 {
			 left();left();left();
		 }
		 else if(ri==true)
		 {
			 right();right();right();
		 }
	 }

	public void jump()
	{
		if(jmp<2)
		{
		while(t<15)
		{	up();t++;}
		jmp++;
		}
	}


	public void right()
	{
		if(startX!=1320)
			startX+=add;
		//repaint();
	}

	public void left()
	{
		if(startX!=10)
			startX-=add;
		//repaint();
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		//repaint();
	}

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		//repaint();
		
	}
	
	public void kill(int sdv)
	{
		
	}
	
	public void gethit()
	{
		hp-=10;
	}

	/*public void closeenough(int a, int b)
	{
		if((Math.abs(af.get(a).getY() - af.get(b).getY())<20) && (Math.abs(af.get(a).getX() - af.get(b).getX())<100))
			gethit();
	}*/

	public void down()
	{
		if(!(startY==520 && (startX>200 &&startX<1020)) && !(startY==390 && (startX>270 &&startX<480)) && !(startY==390 && (startX>730 &&startX<950)) && !(startY==290 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		else
			jmp=0;
		//repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(dow==true)
	 		dash();
	 	if(att==true)
	 		attack();
	 	down();
	//	repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			AttPart(g);
		if(att==false)
			MattPart(g);
		setLocation(startX,startY);
	}
	
	public void MattPart(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,5,25,5);
	}
	
	public void AttPart(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,5,25,5);
	}
}


class Kirby extends SSB implements KeyListener, ActionListener
{
	protected Timer time;
	protected int startX, startY;
	protected int add;
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	boolean att;
	int hp;
	int wsd;
	boolean dead;
	int jmp;
	int plyr;

	public Kirby(int sx,int sy, int k)
	{
		super();
		plyr=k;
		addloc(10,10,0);
		this.setPreferredSize(new Dimension(500, 500));
		hp=100;
		startX =sx;
		startY=sy;
		dead=false;
		wsd=0;
		int jmp;
		time = new Timer(100, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}
	
	//public pickkeys

	public void moveTo(int startX,int startY)
	{
		setLocation(startX,startY);
		//repaint();
	}

	 public void keyTyped(KeyEvent e){}

	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=true;
	 	if(key==m.VK_RIGHT)
	 		ri=true;
	 	if(key==m.VK_UP)
	 		u=true;
	 	if(key==m.VK_DOWN)
	 		dow=true;
	 	if(key==16)
	 		att=true;
		m=e;
	 	repaint();
	 }


	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==m.VK_LEFT)
	 		le=false;
	 	if(key==m.VK_RIGHT)
	 		ri=false;
	 	if(key==m.VK_UP)
	 	{	u=false;t=0;}
	 	if(key==m.VK_DOWN)
	 		dow=false;
	 	if(key==16)
	 		att=false;
		m=e;
	 	repaint();
	 }
	 
	 public void dash()
	 {
		 if(le==true)
		 {
			 left();left();left();
		 }
		 else if(ri==true)
		 {
			 right();right();right();
		 }
	 }

	public void jump()
	{
		if(jmp<2)
		{
			while(t<15)
			{	up();t++;}
			jmp++;
		}
	}


	public void right()
	{
		if(startX!=1320)
			startX+=add;
		//repaint();
	}

	public void left()
	{
		if(startX!=10)
			startX-=add;
		//repaint();
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		//repaint();
	}

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		//repaint();
		
	}
	
	public void gethit()
	{
		hp-=10;
		if(hp==0)
			dead=true;
	}

	public void down()
	{
		if(!(startY==520 && (startX>200 &&startX<1020)) && !(startY==390 && (startX>270 &&startX<480)) && !(startY==390 && (startX>730 &&startX<950)) && !(startY==290 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		else
			jmp=0;
		//repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(dow==true)
	 		dash();
	 	if(att==true)
	 		attack();
	 	down();
		//repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(dead)
			MP(g);
		else
		{
		if(att==true)
			AttPart(g);
		if(att==false)
			MattPart(g);
		}
		setLocation(startX,startY);
	}

	public void MP(Graphics g)
	{

	}


	public void MattPart(Graphics g)
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

	public void AttPart(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(10,5,70,5);
		g.fillRect(5,10,75,5);
		g.fillRect(5,15,75,5);
		g.fillRect(5,20,75,5);
		g.fillRect(10,25,70,5);
		g.fillRect(10,30,70,5);
		g.fillRect(10,35,70,5);
		g.fillRect(10,40,70,5);
		g.fillRect(10,45,70,5);
		g.fillRect(10,50,65,5);
		g.fillRect(10,55,65,5);
		g.fillRect(20,60,50,5);

		g.setColor(new Color(0,0,0)); //Black
		g.fillRect(10,0,5,5);
		g.fillRect(15,0,5,5);
		g.fillRect(20,0,5,5);
		g.fillRect(25,5,5,5);
		g.fillRect(30,0,35,5);
		g.fillRect(65,5,5,5);
		g.fillRect(70,0,10,5);
		g.fillRect(70,10,5,5);
		g.fillRect(5,5,5,5);
		g.fillRect(80,5,5,25);
		g.fillRect(75,30,5,20);
		g.fillRect(70,50,5,10);
		g.fillRect(65,60,5,5);
		g.fillRect(0,10,5,15);
		g.fillRect(5,25,5,25);
		g.fillRect(10,30,5,5);
		g.fillRect(10,45,5,15);
		g.fillRect(15,55,5,5);
		g.fillRect(20,60,5,5);
		g.fillRect(5,60,5,15);
		g.fillRect(10,75,10,5);
		g.fillRect(20,70,5,5);
		g.fillRect(25,65,40,5);
		g.fillRect(30,70,5,5);
		g.fillRect(35,75,10,5);
		g.fillRect(45,70,5,5);

		g.fillRect(45,20,5,15);
		g.fillRect(55,20,5,15);
		g.fillRect(50,45,5,5);

		g.setColor(new Color(219,112,147)); //Darker Pink
		g.fillRect(10,60,10,5);
		g.fillRect(10,65,15,5);
		g.fillRect(10,70,10,5);
		g.fillRect(35,70,10,5);

	}
}

class Link extends SSB implements KeyListener, ActionListener
{
	protected Timer time;
	protected int startX, startY;
	protected int add;
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	boolean att;
	int wsd;
	int hp;

	public Link(int sx,int sy)
	{
		addloc(sx,sy,1);
		this.setPreferredSize(new Dimension(500, 500));
		hp=100;
		startX =sx;
		startY=sy;
		wsd=0;
		time = new Timer(100, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}

	public void moveTo(int startX,int startY)
	{
		setLocation(startX,startY);
		//repaint();
	}

	 public void keyTyped(KeyEvent e){}

	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==65)
	 		le=true;
	 	if(key==68)
	 		ri=true;
	 	if(key==87)
	 		u=true;
	 	if(key==83)
	 		dow=true;
	 	if(key==32)
	 		att=true;
		m=e;
	 	repaint();
	 //	moveTo(startX,startY);
	 }


	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==65)
	 		le=false;
	 	if(key==68)
	 		ri=false;
	 	if(key==87)
	 	{	u=false;t=0;}
	 	if(key==83)
	 		dow=false;
	 	if(key==32)
	 		att=false;
		m=e;
	 	repaint();
	 	//moveTo(startX,startY);
	 }

	public void jump()
	{
		while(t<15)
		{	up();t++;}
		//while(t>10 && t<20)
		//{	down();t++;}

	}


	public void right()
	{
		if(startX!=1320)
			startX+=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void left()
	{
		if(startX!=10)
			startX-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void down()
	{
		if(!(startY==490 && (startX>200 &&startX<1020)) && !(startY==360 && (startX>270 &&startX<480)) && !(startY==360 && (startX>730 &&startX<950)) && !(startY==260 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		//repaint();
		//moveTo(startX,startY);
	}
	
	 public void dash()
	 {
		 if(le==true)
		 {
			 left();left();left();
		 }
		 else if(ri==true)
		 {
			 right();right();right();
		 }
	 }
	 
	public void gethit()
	{
		hp-=10;
		if(hp==0)
			super.kill(2);
	}


	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(dow==true)
	 		dash();
	 	if(att==true)
	 		attack();
	 	down();
		//repaint();
		//moveTo(startX,startY);
	}

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		//repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			AttPart(g);
		else
			JeremyPart(g);
		setLocation(startX,startY);
	}

	public void MP(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,20,25,20);
	}

	public void JeremyPart(Graphics g)
	{
		g.setColor(new Color(0,102,0)); //Green
		g.fillRect(10,40,20,5);
		g.fillRect(15,35,15,5);
		g.fillRect(10,45,5,5);
		g.fillRect(20,45,10,5);
		g.fillRect(20,50,5,5);
		g.fillRect(25,30,25,5);
		g.fillRect(35,35,10,5);
		g.fillRect(35,25,20,5);
		g.fillRect(30,60,20,5);
		g.fillRect(25,65,35,5);
		g.fillRect(30,70,5,5);
		g.fillRect(50,70,15,10);
		g.fillRect(45,80,15,5);
		g.fillRect(35,85,10,5);
		g.fillRect(20,85,5,5);
		g.fillRect(15,90,45,5);

		g.setColor(new Color(0,0,153)); //Blue
		g.fillRect(60,50,5,5); //eye
		g.fillRect(80,45,5,45); //Shield


		g.setColor(new Color(255,255,255)); //White
		g.fillRect(60,45,5,5);

		g.setColor(new Color(170,170,0)); //Yellow
		g.fillRect(50,30,20,5);
		g.fillRect(45,35,30,5);
		g.fillRect(40,40,30,5);
		g.fillRect(45,45,5,10);
		g.fillRect(25,50,10,5);
		g.fillRect(25,55,15,5);

		g.setColor(new Color(102,51,0)); //Dark Brown
		g.fillRect(60,65,15,5);
		g.fillRect(65,70,10,10);
		g.fillRect(60,80,5,5);
		g.fillRect(45,85,20,5);
		g.fillRect(30,95,15,10);
		g.fillRect(45,100,10,5);
		g.fillRect(20,65,5,5);
		g.fillRect(15,70,15,15);
		g.fillRect(30,75,5,15);
		g.fillRect(25,85,5,5);

		g.setColor(new Color(255,178,102)); //Skin
		g.fillRect(35,70,15,10);
		g.fillRect(35,80,10,5);
		g.fillRect(75,65,5,10); //left hand
		g.fillRect(70,50,5,5);
		g.fillRect(65,45,5,20);
		g.fillRect(50,55,15,10);
		g.fillRect(50,45,10,10);
		g.fillRect(30,35,5,15);
		g.fillRect(35,40,5,15);
		g.fillRect(40,45,5,15);
		g.fillRect(45,55,5,5);
	}

	public void AttPart(Graphics g)
	{
		g.setColor(new Color(0,102,0)); //Green
		g.fillRect(10,40,20,5);
		g.fillRect(15,35,15,5);
		g.fillRect(10,45,5,5);
		g.fillRect(20,45,10,5);
		g.fillRect(20,50,5,5);
		g.fillRect(25,30,25,5);
		g.fillRect(35,35,10,5);
		g.fillRect(35,25,20,5);
		g.fillRect(30,60,20,5);
		g.fillRect(25,65,35,5);
		g.fillRect(30,70,5,5);
		g.fillRect(50,70,15,10);
		g.fillRect(45,80,15,5);
		g.fillRect(35,85,10,5);
		g.fillRect(20,85,5,5);
		g.fillRect(15,90,45,5);

		g.setColor(new Color(0,0,153)); //Blue
		g.fillRect(60,50,5,5); //eye
		g.fillRect(80,60,5,20); //Shield
		g.fillRect(85,55,5,10);
		g.fillRect(85,75,5,10);

		g.setColor(new Color(192,192,192));
		g.fillRect(85,65,30,10);
		g.fillRect(115,70,5,5);


		g.setColor(new Color(255,255,255)); //White
		g.fillRect(60,45,5,5);

		g.setColor(new Color(170,170,0)); //Yellow
		g.fillRect(50,30,20,5);
		g.fillRect(45,35,30,5);
		g.fillRect(40,40,30,5);
		g.fillRect(45,45,5,10);
		g.fillRect(25,50,10,5);
		g.fillRect(25,55,15,5);

		g.setColor(new Color(102,51,0)); //Dark Brown
		g.fillRect(60,65,15,5);
		g.fillRect(65,70,10,10);
		g.fillRect(60,80,5,5);
		g.fillRect(45,85,20,5);
		g.fillRect(30,95,15,10);
		g.fillRect(45,100,10,5);
		g.fillRect(20,65,5,5);
		g.fillRect(15,70,15,15);
		g.fillRect(30,75,5,15);
		g.fillRect(25,85,5,5);

		g.setColor(new Color(255,178,102)); //Skin
		g.fillRect(35,70,15,10);
		g.fillRect(35,80,10,5);
		g.fillRect(75,65,5,10); //left hand
		g.fillRect(70,50,5,5);
		g.fillRect(65,45,5,20);
		g.fillRect(50,55,15,10);
		g.fillRect(50,45,10,10);
		g.fillRect(30,35,5,15);
		g.fillRect(35,40,5,15);
		g.fillRect(40,45,5,15);
		g.fillRect(45,55,5,5);
	}
}

class Yoshi extends SSB implements KeyListener, ActionListener
{
	protected Timer time;
	protected int startX, startY;
	protected int add;
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	boolean att;
	int wsd;
	int hp;

	public Yoshi(int sx,int sy)
	{
		addloc(sx,sy,1);
		this.setPreferredSize(new Dimension(500, 500));
		startX =sx;
		startY=sy;
		wsd=0;
		hp=100;
		time = new Timer(100, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}

	public void moveTo(int startX,int startY)
	{
		setLocation(startX,startY);
		//repaint();
	}

	 public void keyTyped(KeyEvent e){}

	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==65)
	 		le=true;
	 	if(key==68)
	 		ri=true;
	 	if(key==87)
	 		u=true;
	 	if(key==83)
	 		dow=true;
	 	if(key==32)
	 		att=true;
		m=e;
	 	repaint();
	 //	moveTo(startX,startY);
	 }


	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==65)
	 		le=false;
	 	if(key==68)
	 		ri=false;
	 	if(key==87)
	 	{	u=false;t=0;}
	 	if(key==83)
	 		dow=false;
	 	if(key==32)
	 		att=false;
		m=e;
	 	repaint();
	 	//moveTo(startX,startY);
	 }

	public void jump()
	{
		while(t<15)
		{	up();t++;}
		//while(t>10 && t<20)
		//{	down();t++;}

	}


	public void right()
	{
		if(startX!=1320)
			startX+=add;
	//	repaint();
		//moveTo(startX,startY);
	}
	
	public void gethit()
	{
		hp-=10;
		if(hp==0)
			super.kill(1);
	}

	
	public void left()
	{
		if(startX!=10)
			startX-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void down()
	{
		if(!(startY==490 && (startX>80 &&startX<860)) && !(startY==360 && (startX>140 &&startX<330)) && !(startY==360 && (startX>600 &&startX<800)) && !(startY==260 && (startX>340 &&startX<590)))
		{
			if(startY!=730)
				startY+=add;
		}
		//repaint();
		//moveTo(startX,startY);
	}
	
	 public void dash()
	 {
		 if(le==true)
		 {
			 left();left();left();
		 }
		 else if(ri==true)
		 {
			 right();right();right();
		 }
	 }


	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(dow==true)
	 		dash();
	 	if(att==true)
	 		attack();
	 	down();
		//repaint();
		//moveTo(startX,startY);
	}

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		//repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			AttPart(g);
		else
			JeremyPart(g);
		setLocation(startX,startY);
	}

	public void MP(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,20,25,20);
	}

	public void JeremyPart(Graphics g)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(200,25,15,5);
		g.fillRect(195,30,5,5);
		g.fillRect(190,35,5,10);
		g.fillRect(185,40,5,5);
		g.fillRect(180,45,5,15);
		g.fillRect(185,60,5,10);
		g.fillRect(175,70,10,5);
		g.fillRect(170,75,5,5);
		g.fillRect(165,70,5,25);
		g.fillRect(170,95,5,5);
		g.fillRect(175,85,30,5);
		g.fillRect(175,90,5,10);
		g.fillRect(175,100,45,5);
		g.fillRect(200,90,10,5);
		g.fillRect(205,95,5,5);
		g.fillRect(220,95,5,5);
		g.fillRect(225,80,5,15);
		g.fillRect(220,70,5,10);
		g.fillRect(195,50,5,5);
		g.fillRect(200,55,10,5);
		g.fillRect(210,60,20,5);
		g.fillRect(225,65,15,5);
		g.fillRect(240,50,5,15);
		g.fillRect(230,45,10,5);
		g.fillRect(220,40,10,5);
		g.fillRect(215,30,5,5);
		g.fillRect(210,40,5,10);

		g.setColor(new Color(255,0,0));
		g.fillRect(190,95,5,5);
		g.fillRect(180,90,10,10);

		g.setColor(new Color(250,164,96));
		g.fillRect(190,90,10,5);
		g.fillRect(195,95,5,5);

		g.setColor(new Color(255,255,255));
		g.fillRect(200,95,5,5);
		g.fillRect(205,65,15,25);
		g.fillRect(205,60,5,5);
		g.fillRect(220,65,5,5);
		g.fillRect(220,80,5,15);
		g.fillRect(210,90,10,10);
		g.fillRect(200,70,5,15);
		g.fillRect(195,75,5,10);
		g.fillRect(190,80,5,5);
		g.fillRect(195,45,15,5);
		g.fillRect(200,50,15,5);
		g.fillRect(200,40,10,5);
		g.fillRect(205,35,15,5);
		g.fillRect(215,40,5,10);
		g.fillRect(230,50,5,5);
		g.fillRect(170,90,5,5);

		g.setColor(new Color(50,205,50));
		g.fillRect(175,80,15,5);
		g.fillRect(185,75,10,5);
		g.fillRect(190,70,10,5);
		g.fillRect(195,60,10,10);
		g.fillRect(195,55,5,5);
		g.fillRect(210,55,25,5);
		g.fillRect(215,50,15,5);
		g.fillRect(230,60,5,5);

		g.setColor(new Color(0,160,0));
		g.fillRect(235,50,5,15);
		g.fillRect(220,45,10,5);
		g.fillRect(200,30,15,5);
		g.fillRect(195,35,10,5);
		g.fillRect(195,40,5,5);
		g.fillRect(185,45,10,15);
		g.fillRect(190,60,5,10);
		g.fillRect(185,70,5,5);
		g.fillRect(175,75,10,5);
		g.fillRect(170,80,5,10);
	}

	public void AttPart(Graphics g)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(200,25,15,5);
		g.fillRect(195,30,5,5);
		g.fillRect(190,35,5,10);
		g.fillRect(185,40,5,5);
		g.fillRect(180,45,5,15);
		g.fillRect(185,60,5,10);
		g.fillRect(175,70,10,5);
		g.fillRect(170,75,5,5);
		g.fillRect(165,70,5,25);
		g.fillRect(170,95,5,5);
		g.fillRect(175,85,30,5);
		g.fillRect(175,90,5,10);
		g.fillRect(175,100,45,5);
		g.fillRect(200,90,10,5);
		g.fillRect(205,95,5,5);
		g.fillRect(220,95,5,5);
		g.fillRect(225,80,5,15);
		g.fillRect(220,70,5,10);
		g.fillRect(195,50,5,5);
		g.fillRect(200,55,10,5);
		g.fillRect(210,60,20,5);
		g.fillRect(225,70,15,5); //lip
		g.fillRect(240,50,5,15);
		g.fillRect(230,45,10,5);
		g.fillRect(220,40,10,5);
		g.fillRect(215,30,5,5);
		g.fillRect(210,40,5,10);

		g.setColor(new Color(255,0,0));
		g.fillRect(190,95,5,5);
		g.fillRect(180,90,10,10);

		g.setColor(new Color(250,164,96));
		g.fillRect(190,90,10,5);
		g.fillRect(195,95,5,5);

		g.setColor(new Color(255,255,255));
		g.fillRect(200,95,5,5);
		g.fillRect(205,65,15,25);
		g.fillRect(205,60,5,5);
		g.fillRect(220,65,5,5);
		g.fillRect(220,80,5,15);
		g.fillRect(210,90,10,10);
		g.fillRect(200,70,5,15);
		g.fillRect(195,75,5,10);
		g.fillRect(190,80,5,5);
		g.fillRect(195,45,15,5);
		g.fillRect(200,50,15,5);
		g.fillRect(200,40,10,5);
		g.fillRect(205,35,15,5);
		g.fillRect(215,40,5,10);
		g.fillRect(230,50,5,5);
		g.fillRect(170,90,5,5);


		g.setColor(new Color(50,205,50));
		g.fillRect(175,80,15,5);
		g.fillRect(185,75,10,5);
		g.fillRect(190,70,10,5);
		g.fillRect(195,60,10,10);
		g.fillRect(195,55,5,5);
		g.fillRect(210,55,25,5);
		g.fillRect(215,50,15,5);
		g.fillRect(230,60,5,5);

		g.setColor(new Color(0,160,0));
		g.fillRect(235,50,5,15);
		g.fillRect(220,45,10,5);
		g.fillRect(200,30,15,5);
		g.fillRect(195,35,10,5);
		g.fillRect(195,40,5,5);
		g.fillRect(185,45,10,15);
		g.fillRect(190,60,5,10);
		g.fillRect(185,70,5,5);
		g.fillRect(175,75,10,5);
		g.fillRect(170,80,5,10);

		g.setColor(new Color(255,0,0));
		g.fillRect(230,60,45,5);
		g.fillRect(270,55,15,15);

		g.setColor(new Color(225,0,0));
		g.fillRect(225,65,45,5);

		g.setColor(new Color(255,255,255));
		g.fillRect(280,65,5,5);
	}
}

class Mario extends SSB implements KeyListener, ActionListener
{
	protected Timer time;
	protected int startX, startY;
	protected int add;
	int key;
	KeyEvent m;
	boolean le;
	boolean ri;
	boolean u;
	boolean dow;
	int t;
	boolean att;
	int wsd;
	int hp;

	public Mario(int sx,int sy)
	{
		addloc(sx,sy,1);
		this.setPreferredSize(new Dimension(500, 500));
		startX =sx;
		startY=sy;
		wsd=0;
		hp=100;
		time = new Timer(60, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}

	public void moveTo(int startX,int startY)
	{
		setLocation(startX,startY);
		//repaint();
	}

	 public void keyTyped(KeyEvent e){}

	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==65)
	 		le=true;
	 	if(key==68)
	 		ri=true;
	 	if(key==87)
	 		u=true;
	 	if(key==83)
	 		dow=true;
	 	if(key==32)
	 		att=true;
		m=e;
	 	repaint();
	 //	moveTo(startX,startY);
	 }


	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==65)
	 		le=false;
	 	if(key==68)
	 		ri=false;
	 	if(key==87)
	 	{	u=false;t=0;}
	 	if(key==83)
	 		dow=false;
	 	if(key==32)
	 		att=false;
		m=e;
	 	repaint();
	 	//moveTo(startX,startY);
	 }

	public void jump()
	{
		while(t<15)
		{	up();t++;}
		//while(t>10 && t<20)
		//{	down();t++;}

	}


	public void right()
	{
		if(startX!=1320)
			startX+=add;
		//repaint();
		//moveTo(startX,startY);
	}
	
	public void gethit()
	{
		hp-=10;
		if(hp==0)
			super.kill(1);
	}

	
	public void left()
	{
		if(startX!=10)
			startX-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		//repaint();
		//moveTo(startX,startY);
	}

	public void down()
	{
		if(!(startY==510 && (startX>200 &&startX<1020)) && !(startY==380 && (startX>270 &&startX<480)) && !(startY==380 && (startX>730 &&startX<950)) && !(startY==280 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		//repaint();
		//moveTo(startX,startY);
	}
	
	 public void dash()
	 {
		 if(le==true)
		 {
			 left();left();left();
		 }
		 else if(ri==true)
		 {
			 right();right();right();
		 }
	 }


	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(dow==true)
	 		dash();
	 	if(att=true)
	 		attack();
	 	down();
	 	
		//repaint();
		//moveTo(startX,startY);
	}

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		//repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			MattPart(g);
		else
			AttPart(g);
		setLocation(startX,startY);
	}

	public void MP(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,20,25,20);
	}

	public void MattPart(Graphics g)
	{
		g.setColor(new Color(255,255,255)); //White
		g.fillRect(0,50,60,5);
		g.fillRect(0,50,60,5);
		g.fillRect(0,55,60,5);
		g.fillRect(0,60,60,5);
		
		g.setColor(new Color(225,0,0)); //Red
		g.fillRect(15,0,25,5);
		g.fillRect(10,5,45,5);
		g.fillRect(10,35,40,5);
		g.fillRect(5,40,50,5);
		g.fillRect(0,45,60,5);
		g.fillRect(10,50,40,5);
			
		g.setColor(new Color(139,69,19)); //Brown
		g.fillRect(10,10,15,5);
		g.fillRect(5,15,15,5);
		g.fillRect(5,20,20,5);
		g.fillRect(10,25,5,5);
	
		g.setColor(new Color(255,222,173)); //Skin
		g.fillRect(10,15,5,10);
		g.fillRect(25,10,20,5);
		g.fillRect(20,15,35,5);
		g.fillRect(20,20,40,5);
		g.fillRect(15,25,40,5);
		g.fillRect(15,30,30,5);
		
		g.setColor(new Color(0,0,0)); //Black
		g.fillRect(35,10,5,10);
		g.fillRect(40,20,5,5);
		g.fillRect(35,25,20,5);
		
		g.setColor(new Color(0,0,220)); //Blue
		g.fillRect(20,35,5,40);
		g.fillRect(35,35,5,40);
		g.fillRect(25,45,5,25);
		g.fillRect(30,45,5,25);
		g.fillRect(15,50,5,25);
		g.fillRect(40,50,5,25);
		g.fillRect(10,65,5,10);
		g.fillRect(45,65,5,10);
		
		g.setColor(new Color(255,255,0)); //Yellow
		g.fillRect(35,50,5,5);
		g.fillRect(20,50,5,5);
		
		g.setColor(new Color(149,79,29)); //Dark Brown
		g.fillRect(5,75,15,5);
		g.fillRect(40,75,15,5);
		g.fillRect(0,80,20,5);
		g.fillRect(40,80,20,5);
	}

	public void AttPart(Graphics g)
	{
		g.setColor(new Color(255,255,255)); //White
		g.fillRect(0,50,35,5);
		g.fillRect(0,50,35,5);
		g.fillRect(0,55,35,5);
		g.fillRect(0,60,35,5);
		g.fillRect(65,30,5,5);
		g.fillRect(60,35,15,5);
		g.fillRect(60,40,15,5);
		g.fillRect(60,45,15,5);
		g.fillRect(65,50,5,5);
		
		g.setColor(new Color(225,0,0)); //Red
		g.fillRect(15,0,25,5);
		g.fillRect(10,5,45,5);
		g.fillRect(10,35,50,5);
		g.fillRect(5,40,55,5);
		g.fillRect(0,45,60,5);
		g.fillRect(10,50,5,5);
			
		g.setColor(new Color(139,69,19)); //Brown
		g.fillRect(10,10,15,5);
		g.fillRect(5,15,15,5);
		g.fillRect(5,20,20,5);
		g.fillRect(10,25,5,5);
	
		g.setColor(new Color(255,222,173)); //Skin
		g.fillRect(10,15,5,10);
		g.fillRect(25,10,20,5);
		g.fillRect(20,15,35,5);
		g.fillRect(20,20,40,5);
		g.fillRect(15,25,40,5);
		g.fillRect(15,30,30,5);
		
		g.setColor(new Color(0,0,0)); //Black
		g.fillRect(35,10,5,10);
		g.fillRect(40,20,5,5);
		g.fillRect(35,25,20,5);
		
		g.setColor(new Color(0,0,220)); //Blue
		g.fillRect(20,35,5,40);
		g.fillRect(35,35,5,40);
		g.fillRect(25,45,5,25);
		g.fillRect(30,45,5,25);
		g.fillRect(15,50,5,25);
		g.fillRect(40,50,5,25);
		g.fillRect(10,65,5,10);
		g.fillRect(45,65,5,10);
		
		g.setColor(new Color(255,255,0)); //Yellow
		g.fillRect(35,50,5,5);
		g.fillRect(20,50,5,5);
		
		g.setColor(new Color(149,79,29)); //Dark Brown
		g.fillRect(5,75,15,5);
		g.fillRect(40,75,15,5);
		g.fillRect(0,80,20,5);
		g.fillRect(40,80,20,5);
	}
}
