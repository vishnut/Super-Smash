import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

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

	public Kirby(int sx,int sy)
	{
		this.setPreferredSize(new Dimension(500, 500));
		hp=100;
		startX =sx;
		startY=sy;
		wsd=0;
		time = new Timer(10, this);
		setSize(1324, 870);
		setVisible(true);
		time.start();
		add = 10;
	}

	public void moveTo(int startX,int startY)
	{
		setLocation(startX,startY);
		repaint();
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

	public void jump()
	{
		while(t<15)
		{	up();t++;}
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

	public void attack()
	{
		if(wsd%2==0)
		left();
		else
		right();
		wsd++;
		repaint();
	}

	public void down()
	{
		if(!(startY==520 && (startX>200 &&startX<1020)) && !(startY==390 && (startX>270 &&startX<480)) && !(startY==390 && (startX>730 &&startX<950)) && !(startY==290 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(att==true)
	 		attack();

	 	down();
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		if(att==true)
			AttPart(g);
		if(att==false)
			MattPart(g);
		setLocation(startX,startY);
	}

	public void MP(Graphics g)
	{
		g.setColor(new Color(255,192,203)); //Main Pink
		g.fillRect(35,20,25,20);
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