import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

abstract class SSB extends JPanel implements KeyListener, ActionListener
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
	ArrayList af;

//	public SSB(ArrayList<SSB> k)
//	{
//		af=k;
//	}

	public void keyTyped(KeyEvent e){}

	public void keyPressed(KeyEvent e)
	{}
	public void keyReleased(KeyEvent e)
	{}

	public void jump()
	{}

	public void right()
	{}

	public void left()
	{}

	public void up()
	{}


	public boolean closeenough(SSB a)
	{
		//SSB=characters.get(0);
		if(Math.abs(getLocation().x - a.getLocation().x)<20)
			return true;
		return false;
	}

	public void attack()
	{

	}
}
