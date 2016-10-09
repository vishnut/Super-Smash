import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game
{
	  
	public static void main(String...args)
	{
		JFrame j = new JFrame();
		
		int bg=(int)(Math.random()*3)+1;
		
		String mus;
		if(bg==1)
			mus="sng.au";
		else if(bg==2)
			mus="Lost Woods.wav";
		else
			mus="Kirby's Dreamland.wav";
		
		
		Clip music=null;
		try
	    {
	        music = AudioSystem.getClip();
	        music.open(AudioSystem.getAudioInputStream(new File(mus)));
	        music.start();
	    }
	    catch (Exception exc)
	    { exc.printStackTrace(System.out);}
		
		Bgrd k=new Bgrd(bg);
		j.setSize(1324, 870);
		j.add(k);
		j.addMouseListener(k);
		j.addKeyListener(k);
		k.setVisible(true);
		j.setVisible(true);
		
		while(k.isready()!=true)
		{
			System.out.println("w");
		}
			
		Link l=new Link(300,10,0,bg);
  		l.setDoubleBuffered(true);
  		l.setOpaque(false);
		k.add(l);
		j.addKeyListener(l);
		l.setVisible(true);
		

		Mario h = new Mario(800,10,1,bg);
		h.setDoubleBuffered(true);
		h.setOpaque(false);
		k.add(h);
		j.addKeyListener(h);
		h.setVisible(true);
		
		while(k.l1>0 && k.l2>0)
		{
			System.out.println(l.hits+" "+h.hits+" "+l.spl+" "+h.spl);
			
			int mx=Math.max(h.startX, l.startX);
			int mn=Math.min(h.startX, l.startX);
			
			if(h.atk && (mx-mn<120 || mn-mx>-60) && Math.abs(h.startY-l.startY)<60 && !l.shield)
			{	l.hits++;h.atk=false;}
			if(l.atk && (mx-mn<120 || mn-mx>-60) && Math.abs(l.startY-h.startY)<60 && !h.shield)
			{	h.hits++;l.atk=false;}
			if(h.spl) 
			{	
				k.spl(h.startY,0);
				if(Math.abs(h.startY-l.startY)<60 && !l.shield)
				l.hits+=9;h.spl=false;
			}
			if(l.spl)
			{	
				k.spl(l.startY,1);
				if(Math.abs(l.startY-h.startY)<60 && !h.shield)
				h.hits+=9;l.spl=false;
			}

			k.uh(l.hits,h.hits);
			k.up(l.pow,h.pow);
			if(h.hits>10)
				h.dead=true;
			if(l.hits>10)
				l.dead=true;
			
			if(l.dead)
			{
				l.dead=false;
				l.hits=0;
				k.l1--;
				if(!l.dntfly)
					l.flyoff();
				else
				{	l.dntfly=false;k.repaint();}
			}
			if(h.dead)
			{
				h.dead=false;
				h.hits=0;
				k.l2--;
				if(!h.dntfly)
					h.flyoff();
				else
				{	h.dntfly=false;k.repaint();}
			}
			
		}
		
		j.remove(h);j.remove(l);j.remove(k);
		System.out.println("GAME OVER");
		
		int win=0;
		
		if(k.l1==k.l2)
			win=0;
		else if(k.l1>k.l2)
			win=1;
		else
			win=2;
		
		boolean w1=false;boolean tie=false;
		if(win==1)
			w1=true;
		if(win==0)
			tie=true;
		
		Fin z= new Fin(win);
		z.setBackground(Color.BLACK);
		z.setVisible(true);
		j.add(z);
		z.repaint();
		
		music.close();
		
		try
		
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File("Fine Dining.wav")));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
		
		try
		
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File("gameover.wav")));
	        clip.start();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
		
		EndScreen end=new EndScreen(w1,tie);
		end.setSize(j.getSize());
		j.add(end);
		j.addKeyListener(end);
		
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
}

class EndScreen extends JPanel implements ActionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	Timer time;
	int t;int y;boolean p1w;
	int change;boolean tie;int width;int height;
	String fin;
	
	public EndScreen(boolean p,boolean ti)
	{
		time = new Timer(20, this);
		time.start();	
		setLocation(0,0);
		t=0;
		p1w=p;
		y=740;
		tie=ti;
		change=3;
		width=0;height=0;
		fin="End Screen 1.png";
		int r=(int)(Math.random()*2);
		if(r!=0)
			fin="End Screen 2.png";
	}
	
	public void keyPressed(KeyEvent e)
	{if(e.getKeyCode()<60)
		change+=5;
	else
		change-=5;
	}
	
	public void keyTyped(KeyEvent e)
	{}
	
	public void keyReleased(KeyEvent e)
	{if(e.getKeyCode()<60)
		change+=1;
	else
		change-=1;}
	
	public void actionPerformed(ActionEvent e) {

		if(t==100)
		{
			String winner;
			if(tie)
				winner="tie.wav";
			else if(p1w)
				winner="p1wins.wav";
			else
				winner="p2wins.wav";
			
			try
		    {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File(winner)));
		        clip.start();
		    }
		    catch (Exception exc)
		    {
		        exc.printStackTrace(System.out);
		    }
			t++;
		}
		else if(t<200)
			t++;
		else if(t==200)
		{
			try
		    {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File("gg.wav")));
		        clip.start();
		    }
		    catch (Exception exc)
		    {exc.printStackTrace(System.out);}
			t++;
			this.setVisible(true);repaint();
		}
		else if(t==270)
		{
			change+=7;t++;
		}
		else if(t==315)
		{
			change+=5;t++;
		}
		else
		{	y-=change;repaint();t++;System.out.println(t);}
	}
	
	public void paintComponent(Graphics g)
	{
		if(t>50 && y>-2670 && y<900)
		{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1500,1000);
		
		try
		{
			Image i=ImageIO.read(new File("creditsk.png"));
			g.drawImage(i,-100,y,null);
		}
		catch(Exception e){}
		}
		else if(y<-2670)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0,0,1500,1000);
			try
			{
				Image i=ImageIO.read(new File("PortalScene.jpg"));
				if(y>-3500)
					g.drawImage(i, -150, 0, (y*-1-2600)*18/9, y*-1-2600, null);
				else
					if(change<35)
						change=-35;
					else
						change*=-1;
				y-=change;
			}
			catch(Exception e){}
		}
		else if(y==-2670)
		{
			width=0;height=0;
		}
		else
		{
			g.fillRect(0,0,1500,1000);
			try
			{
				Image i=ImageIO.read(new File(fin));
				width+=8;height+=5;
				if(width<616)
					g.drawImage(i, 455-width, 385-height, width*2, height*2, null);
				else
					g.drawImage(i, -161, 0, 1232, 770, null);
			}
			catch(Exception e){}
		}
			
	}
	
}
		  
class Fin extends JPanel		  
{
		  	private static final long serialVersionUID = 1L;
		  	int w;
		  	public Fin(int win)
		  	{
		  		setSize(1324, 870);
		  		w=win;
		  	}
		  	
		  	public void paintComponent(Graphics g)
		  	{
		  		System.out.println("END SCREEN");
		  		if(w==0)
		  		{
		  			try
		  			{
		  				Image i=ImageIO.read(new File("tie.png"));
		  				g.drawImage(i,0,-100,1324,870,null);
		  			}
		  			catch(Exception e){}
		  		}
		  		else if(w==1)
		  		{
		  			try
		  			{
		  				Image i=ImageIO.read(new File("p1.png"));
		  				g.drawImage(i,0,-100,1324,870,null);
		  			}
		  			catch(Exception e){}
		  		}
		  		else
		  		{
		  				try
		  				{
		  					Image i=ImageIO.read(new File("p2.png"));
		  					g.drawImage(i,0,-100,1324,870,null);
		  				}
		  				catch(Exception e){}
		  		}
		  	}  	
}


class Bgrd extends JPanel implements KeyListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	boolean ready;
	boolean kirb;
	boolean yosh;
	boolean mari;
	boolean lin;
	boolean fin;
	int h1;int h2;
	int l1;int l2;
	int p1;int p2;
	int f1;int f2;
	Image back;
	
	public Bgrd(int k)
	{
		this.setPreferredSize(new Dimension(500, 500));
		ready=false;
		fin=false;
		setSize(1324, 870);
		setVisible(true);
		l1=3;l2=3;
		h1=0;h2=0;
		p1=100;p2=100;
		f1=0;f2=0;
		try
		{
			if(k!=3)
			back = ImageIO.read(new File("stage"+k+".jpg"));
			else
			back = ImageIO.read(new File("stage3.png"));
		}
		catch(Exception e)	{}
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
	
	public void spl(int sy,int pl)
	{
		if(pl==0)
			f1=sy;
		else
			f2=sy;
	}
	
	public void mouseClicked(MouseEvent p) {
		System.out.println("a");
		ready=true;
		repaint();
	}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	public void keyTyped(KeyEvent e){}

	public void keyPressed(KeyEvent e)
	{
	 	System.out.println(e.getKeyCode());
	 	ready=true;
		repaint();
	}
	public void keyReleased(KeyEvent e)
	{
		repaint();
	}
	
	public void uh(int hh1,int hh2)
	{
		boolean r=false;
		if(h1!=hh1 || h2!=hh2)
			r=true;
		h1=hh1;h2=hh2;
		if(r)
			repaint();
	}
	
	public void up(int hh1,int hh2)
	{
		boolean r=false;
		if(p1!=hh1 || p2!=hh2)
			r=true;
		p1=hh1;p2=hh2;
		if(r)
			repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(ready)
		{			
		
		g.drawImage(back, -20, 0,1350,870,null);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(105,25,230,30);
		g.fillRect(945,25,230,30);
		g.fillRect(105,55,230,30);
		g.fillRect(945,55,230,30);
		g.setColor(Color.RED);
		g.fillRect(110,30,(11-h1)*20,20);
		g.fillRect(950,30,(11-h2)*20,20);
		g.setColor(Color.BLUE);
		g.fillRect(110,60,p1*220/100,20);
		g.fillRect(950,60,p2*220/100,20);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Stencil",1,57));
		
		g.drawString("X"+l1, 25, 70);
		
		g.drawString("X"+l2, 1195, 70);

		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Kino MT",3,77));
		g.drawString("SUPER SMASH BROS", 368, 60);
		
		if(f1!=0)
		{
			try
			{
				Image c= ImageIO.read(new File("fire.gif"));
				g.drawImage(c,-100,f1+20,1724,60,null);
			}
			catch(Exception e){}
			f1=0;
		}
		if(f2!=0)
		{
			try
			{
				Image c= ImageIO.read(new File("bluefire.png"));
				g.drawImage(c,-100,f2+20,1724,60,null);
			}
			catch(Exception e){}
			f2=0;
		}
		
		}
		else
		{
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 1324, 870);
			try
			{
				Image ras = ImageIO.read(new File("Control Screen.png"));
				g.drawImage(ras, 0, 0, 1324,770,null);
			}
			catch(Exception e)	{}
			
		}

	
	}
}


class SSB extends JPanel implements KeyListener, ActionListener
{
	private static final long serialVersionUID = 1L;
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
	boolean shield;
	int hits;
	int lkey;int rkey;int akey;int skey;int ukey;int dkey;
	boolean atk;
	boolean ldash;boolean rdash;
	int z;boolean dntfly;
	boolean spl;int spkey;
	int pow;
	int b;
	
	public SSB(int sx,int sy, int k, int bg)
	{
		plyr=k;
		hits=0;
		pow=100;
		b=bg;
		dntfly=false;
		z=0;
		atk=false;
		this.setPreferredSize(new Dimension(100, 100));
		startX =sx;
		startY=sy;
		spl=false;
		shield=false;
		dead=false;
		wsd=0;
		pickkeys();
		ldash=false;rdash=false;
		time = new Timer(80, this);
		setSize(100,100);
		setVisible(true);
		time.start();
		add = 10;
	}
	
	public void flyoff()
	{
		if(plyr==0)
			ldash=true;
		else
			rdash=true;
		z=0;
	}
	
	public void pickkeys()
	{
		if(plyr==0)
		{
			lkey=37;
			rkey=39;
			ukey=38;
			dkey=40;
			skey=47;
			akey=16;
			spkey=46;
		}
		else
		{
			lkey=65;
			rkey=68;
			ukey=87;
			dkey=83;
			skey=69;
			akey=32;
			spkey=70;
		}
	}
	
	public boolean dead()
	{
		if(hits>3)
			dead=true;
		return dead;
	}
	
	 public void keyTyped(KeyEvent e){}

	 public void keyPressed(KeyEvent e)
	 {
		System.out.println(e.getKeyCode());
		key=e.getKeyCode();
		if(key==lkey)
			le=true;
		if(key==rkey)
			ri=true;
		if(key==ukey)
			u=true;
		if(key==dkey)
			dow=true;
		if(key==skey)
			shield=true;
		if(key==akey && !shield)
			att=true;
		if(key==spkey && pow==100)
		{	spl=true;pow=0;}
		m=e;
	 	repaint();
	 }


	 public void keyReleased(KeyEvent e)
	 {
	 	System.out.println(e.getKeyCode());
	 	key=e.getKeyCode();
		if(key==lkey)
			le=false;
		if(key==rkey)
			ri=false;
 		if(key==ukey)
 		{	u=false;t=0;}
 		if(key==dkey)
 			dow=false;
 		if(key==skey)
 			shield=false;
 		if(key==akey)
 			att=false;
		if(key==spkey)
			spl=false;
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
	}

	public void left()
	{
		if(startX!=10)
			startX-=add;
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
	}

	public void attack()
	{
		if(wsd%2==0)
		{left();atk=true;}
		else
		{right();atk=false;}
		wsd++;
	}

	public void down()
	{
		
		if(b==1)
			if(!(startY==520 && (startX>200 &&startX<1020)) && !(startY==390 && (startX>270 &&startX<480)) && !(startY==390 && (startX>730 &&startX<950)) && !(startY==290 && (startX>470 &&startX<740)))
			{
				if(startY!=730)
					startY+=add;
			}
			else
				jmp=0;
		else if(b==2)
			if(!(startY==550 && (startX>200 &&startX<950)))
			{
				if(startY!=730)
					startY+=add;
			}
			else
				jmp=0;
		else
			if(!(startY==650 && !(startX>500 &&startX<670)) && !(startY==370 && (startX>250 &&startX<940)) && !(startY==100 && (startX>420 &&startX<760)))
			{
				if(startY!=730)
					startY+=add;
			}
			else
				jmp=0;
		
		
		
		if(startY>720)
		{	dead=true;		
			if(plyr==0)
			startX=300;
			else
			startX=800;
			startY=10;
			dntfly=true;
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
	 	if(ldash && z<10)
	 	{	left();left();left();left();left();z++;}
	 	else if(ldash)
	 	{	ldash=false;startX=300;startY=10;}
	 	if(rdash && z<10)
	 	{	right();right();right();right();right();z++;}
	 	else if(rdash)
	 	{	rdash=false;startX=800;startY=10;}
	 	if(pow<100)
	 		pow++;
	 	down();
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			AttPart(g);
		if(att==false)
			MattPart(g);
		if(shield)
		{
			shield(g);
		}
		setLocation(startX,startY);
	}
	
	public void shield(Graphics g)
	{
		g.setColor(new Color(0f,0f,1f,.5f));
		g.fillOval(0,0,100,80);
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
	private static final long serialVersionUID = 1L;

	public Kirby(int sx,int sy, int k, int bg)
	{
		super(sx,sy,k,bg);
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

	private static final long serialVersionUID = 1L;


	public Link(int sx,int sy, int k, int bg)
	{
		super(sx,sy,k,bg);
		this.setPreferredSize(new Dimension(120, 100));
		setSize(120,100);
	}

	public void shield(Graphics g)
	{
		g.setColor(new Color(0f,0f,1f,.5f));
		g.fillOval(5,0,85,90);
	}

	public void MattPart(Graphics g)
	{
		g.setColor(new Color(0,102,0)); //Green
		g.fillRect(10,40-18,20,5);
		g.fillRect(15,35-18,15,5);
		g.fillRect(10,45-18,5,5);
		g.fillRect(20,45-18,10,5);
		g.fillRect(20,50-18,5,5);
		g.fillRect(25,30-18,25,5);
		g.fillRect(35,35-18,10,5);
		g.fillRect(35,25-18,20,5);
		g.fillRect(30,60-18,20,5);
		g.fillRect(25,65-18,35,5);
		g.fillRect(30,70-18,5,5);
		g.fillRect(50,70-18,15,10);
		g.fillRect(45,80-18,15,5);
		g.fillRect(35,85-18,10,5);
		g.fillRect(20,85-18,5,5);
		g.fillRect(15,90-18,45,5);

		g.setColor(new Color(0,0,153)); //Blue
		g.fillRect(60,50-18,5,5); //eye
		g.fillRect(80,45-18,5,45); //Shield


		g.setColor(new Color(255,255,255)); //White
		g.fillRect(60,45-18,5,5);

		g.setColor(new Color(170,170,0)); //Yellow
		g.fillRect(50,30-18,20,5);
		g.fillRect(45,35-18,30,5);
		g.fillRect(40,40-18,30,5);
		g.fillRect(45,45-18,5,10);
		g.fillRect(25,50-18,10,5);
		g.fillRect(25,55-18,15,5);

		g.setColor(new Color(102,51,0)); //Dark Brown
		g.fillRect(60,65-18,15,5);
		g.fillRect(65,70-18,10,10);
		g.fillRect(60,80-18,5,5);
		g.fillRect(45,85-18,20,5);
		g.fillRect(30,95-18,15,10);
		g.fillRect(45,100-18,10,5);
		g.fillRect(20,65-18,5,5);
		g.fillRect(15,70-18,15,15);
		g.fillRect(30,75-18,5,15);
		g.fillRect(25,85-18,5,5);

		g.setColor(new Color(255,178,102)); //Skin
		g.fillRect(35,70-18,15,10);
		g.fillRect(35,80-18,10,5);
		g.fillRect(75,65-18,5,10); //left hand
		g.fillRect(70,50-18,5,5);
		g.fillRect(65,45-18,5,20);
		g.fillRect(50,55-18,15,10);
		g.fillRect(50,45-18,10,10);
		g.fillRect(30,35-18,5,15);
		g.fillRect(35,40-18,5,15);
		g.fillRect(40,45-18,5,15);
		g.fillRect(45,55-18,5,5);
	}

	public void AttPart(Graphics g)
	{
		g.setColor(new Color(0,102,0)); //Green
		g.fillRect(10,40-18,20,5);
		g.fillRect(15,35-18,15,5);
		g.fillRect(10,45-18,5,5);
		g.fillRect(20,45-18,10,5);
		g.fillRect(20,50-18,5,5);
		g.fillRect(25,30-18,25,5);
		g.fillRect(35,35-18,10,5);
		g.fillRect(35,25-18,20,5);
		g.fillRect(30,60-18,20,5);
		g.fillRect(25,65-18,35,5);
		g.fillRect(30,70-18,5,5);
		g.fillRect(50,70-18,15,10);
		g.fillRect(45,80-18,15,5);
		g.fillRect(35,85-18,10,5);
		g.fillRect(20,85-18,5,5);
		g.fillRect(15,90-18,45,5);

		g.setColor(new Color(0,0,153)); //Blue
		g.fillRect(60,50-18,5,5); //eye
		g.fillRect(80,60-18,5,20); //Shield
		g.fillRect(85,55-18,5,10);
		g.fillRect(85,75-18,5,10);

		g.setColor(new Color(192,192,192));
		g.fillRect(85,65-18,30,10);
		g.fillRect(115,70-18,5,5);


		g.setColor(new Color(255,255,255)); //White
		g.fillRect(60,45-18,5,5);

		g.setColor(new Color(170,170,0)); //Yellow
		g.fillRect(50,30-18,20,5);
		g.fillRect(45,35-18,30,5);
		g.fillRect(40,40-18,30,5);
		g.fillRect(45,45-18,5,10);
		g.fillRect(25,50-18,10,5);
		g.fillRect(25,55-18,15,5);

		g.setColor(new Color(102,51,0)); //Dark Brown
		g.fillRect(60,65-18,15,5);
		g.fillRect(65,70-18,10,10);
		g.fillRect(60,80-18,5,5);
		g.fillRect(45,85-18,20,5);
		g.fillRect(30,95-18,15,10);
		g.fillRect(45,100-18,10,5);
		g.fillRect(20,65-18,5,5);
		g.fillRect(15,70-18,15,15);
		g.fillRect(30,75-18,5,15);
		g.fillRect(25,85-18,5,5);

		g.setColor(new Color(255,178,102)); //Skin
		g.fillRect(35,70-18,15,10);
		g.fillRect(35,80-18,10,5);
		g.fillRect(75,65-18,5,10); //left hand
		g.fillRect(70,50-18,5,5);
		g.fillRect(65,45-18,5,20);
		g.fillRect(50,55-18,15,10);
		g.fillRect(50,45-18,10,10);
		g.fillRect(30,35-18,5,15);
		g.fillRect(35,40-18,5,15);
		g.fillRect(40,45-18,5,15);
		g.fillRect(45,55-18,5,5);
	}
}

class Yoshi extends SSB implements KeyListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	public Yoshi(int sx,int sy, int k, int bg)
	{
		super(sx,sy,k,bg);
	}

	public void MattPart(Graphics g)
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
	private static final long serialVersionUID = 1L;

	public Mario(int sx,int sy, int k, int bg)
	{
		super(sx,sy,k,bg);
	}

	public void shield(Graphics g)
	{
		g.setColor(new Color(0f,0f,1f,.5f));
		g.fillOval(0,0,70,85);
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
