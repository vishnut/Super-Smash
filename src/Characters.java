import java.awt.*;
import javax.swing.*;

public class Characters
{
	public static void main(String...args)
	{
		JFrame k = new JFrame();
		Kirby m = new Kirby();
		k.setSize(100,110);
		m.setSize(k.getSize());
		k.add(m);
		
		k.setVisible(true);
		m.setVisible(true);
	}
}

class Kirby extends JPanel
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

/*class Link extends JPanel
{
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.PINK);
		g.fillRect(10, 10, 200, 200);
		g.setColor(Color.BLACK);
		g.fillRect(55,55,50,50);
	}
}*/