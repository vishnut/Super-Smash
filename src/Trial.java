import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;

public class Trial
{
	public static void main(String...args) 
	{
		JFrame j = new JFrame();
		SuperSmashObjs m = new SuperSmashObjs();
		j.setSize(m.getSize());
		j.add(m);
  		j.addKeyListener(m);
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
	
	public SuperSmashObjs() 
	{
		this.setPreferredSize(new Dimension(500, 500));
		
		startX = startY = 10; 
		time = new Timer(15, this);
		setSize(1440, 870);
		setVisible(true); 
		time.start();
		add = 5; 
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
	 		u=false;
	 	else if(key==m.VK_DOWN)
	 		dow=false;
		m=e;
	 	repaint();
	 }
	 	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 2000, 1000);
		g.setColor(Color.MAGENTA);
		g.fillRect(startX, startY, 100, 100);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(le==true)
	 		left();
	 	else if(ri==true)
	 		right();
	 	else if(u==true)
	 		up();
	 	else if(dow==true)
	 		down();
		repaint();
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
		if(startY!=730)
			startY+=add;
		repaint();
	}
}

