import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Bgrd extends JPanel
{
	public Bgrd()
	{
		this.setPreferredSize(new Dimension(500, 500));

		setSize(1324, 870);
		setVisible(true);
	}


	public void paintComponent(Graphics g)
	{
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, 1324, 870);
		try
		{
			Image car = ImageIO.read(new File("stage1.jpg"));
			g.drawImage(car, 0, 0, null);
		}
		catch(Exception e)	{}

		System.out.println("HI");
	}
}