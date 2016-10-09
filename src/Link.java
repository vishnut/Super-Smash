import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

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

	public Link(int sx,int sy)
	{
		this.setPreferredSize(new Dimension(500, 500));
		wsd=0;
		startX =sx;
		startY=sy;
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
		repaint();
		//moveTo(startX,startY);
	}

	public void left()
	{
		if(startX!=10)
			startX-=add;
		repaint();
		//moveTo(startX,startY);
	}

	public void up()
	{
		if(startY!=10)
			startY-=add;
		repaint();
		//moveTo(startX,startY);
	}

	public void down()
	{
		if(!(startY==490 && (startX>200 &&startX<1020)) && !(startY==360 && (startX>270 &&startX<480)) && !(startY==360 && (startX>730 &&startX<950)) && !(startY==260 && (startX>470 &&startX<740)))
		{
			if(startY!=730)
				startY+=add;
		}
		repaint();
		//moveTo(startX,startY);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(le==true)
	 		left();
	 	if(ri==true)
	 		right();
	 	if(u==true)
	 		jump();
	 	if(att=true)
	 		attack();
	 	down();
		repaint();
		//moveTo(startX,startY);
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

	public void paintComponent(Graphics g)
	{
		if(att==true)
			JeremyPart(g);
		else
			AttPart(g);
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