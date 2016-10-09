import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener.*;

public class Trial2 extends JFrame implements KeyListener 
{

	JLabel label;

    public Trial2(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Super Smash Bros");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(1000, 1000);
        setVisible(true);

    }
    
    public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.MAGENTA);
		g.fillRect(startX, startY, 100, 100);
	}

    
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }

    }

    
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
        }

    }

    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key Released");
        }
    }
    
    public static void main(String...args) 
	{
		JFrame j = new JFrame();
		/*import objects here*/
		new Trial2("Key Listener Tester");
		SuperSmashObjs m = new SuperSmashObjs();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency. 
		
		j.setVisible(true); //allows the frame to be shown.
			
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button. 
		
	} 
		

}

class SuperSmashObjs extends MyPanel implements ActionListener
{
	private Timer time; 
	private int startX, startY;
	private int add; 
	int key;
	KeyEvent m;
	
	public SuperSmashObjs() 
	{
		startX = startY = 10; 
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class. 
		setSize(1000, 1000);
		setVisible(true); //it's like calling the repaint method. 
		time.start();
		add = 2; 
	}
		 	
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.MAGENTA);
		g.fillRect(startX, startY, 100, 100);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		startX+=add;
		startY+=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
		repaint();
	}
	
	public void right() 
	{
		startX+=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
			add*=-1;
		
		repaint();
	}
	
	public void left() 
	{
		startX-=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
			add*=-1;
		
		repaint();
	}
	
	public void up() 
	{
		startY+=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
			add*=-1;
		
		repaint();
	}
	
	public void down() 
	{
		startY-=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
			add*=-1;
		
		repaint();
	}
}

/*

class MyPanel extends JPanel implements ActionListener  
	private Timer time; 
	private int startX, startY;
	private int add; 
	
	
	MyPanel() 
	{
		startX = startY = 10; 
		time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class. 
		setSize(500, 500);
		setVisible(true); //it's like calling the repaint method. 
		time.start();
		add = 5; 
	}
		
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.BLUE);
		g.fillRect(startX, startY, 50, 50);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		startX+=add;
		//startY+=add;
		if(startX==200 || startY==200)
			add*=-1;
		if(startX==10 && startY==10)
			add*=-1;
		
		repaint();
	}
	
	
} */

