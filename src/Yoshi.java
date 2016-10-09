import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

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

	public Yoshi(int sx,int sy)
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
