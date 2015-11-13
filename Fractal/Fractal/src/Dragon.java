import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Dragon extends JFrame implements KeyListener
{
	ArrayList<Integer> c1;
	int pivotX1,pivotY1;
	int length=10;
	int iteration=1;
	Color[] spectrum;
	public Dragon()
	{
		setTitle("Dragon Curve");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setBackground(Color.blue);
		
		addKeyListener(this);
		
		c1=new ArrayList<Integer>();
		c1.add(getWidth()/2+getWidth()/8);
		c1.add(getHeight()/4);
		c1.add(c1.get(0)+length);
		c1.add(c1.get(1));
		
		spectrum=new Color[360];
		for(int i=0;i<60;i++)
		{
			spectrum[i]=new Color((float)1.0,(float)(i/60.0),(float)0.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+60]=new Color((float)((60-i)/60.0),(float)1.0,(float)0.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+120]=new Color((float)0.0,(float)1.0,(float)(i/60.0));
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+180]=new Color((float)0.0,(float)((60-i)/60.0),(float)1.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+240]=new Color((float)(i/60),(float)0.0,(float)1.0);
		}
		for(int i=0;i<60;i++)
		{
			spectrum[i+300]=new Color((float)1.0,(float)0.0,(float)((60-i)/60.0));
		}
	}
	
	public void paint(Graphics g)
	{
		for(int i=0;i<c1.size()-2;i+=2)
		{
			g.setColor(spectrum[(int)(i*360.0/c1.size())]);
			g.drawLine(c1.get(i), c1.get(i+1), c1.get(i+2), c1.get(i+3));
		}
		for(int i=0;i<10;i++)
		{
			g.setColor(spectrum[i]);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			g.fillArc(100, 100, 50, 50, i, 1);
			
			//g.fillArc(100, 100, 50, 50, 15, 10);
		}
	}
	
	public static void main(String[] args)
	{
		new Dragon();
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==e.VK_SPACE && iteration<20)
		{
			pivotX1=c1.get(c1.size()-2);
			pivotY1=c1.get(c1.size()-1);
			for(int i=c1.size()-3;i>=0;i-=2)
			{
				int y1=c1.get(i);
				int x1=c1.get(i-1);
				x1=x1-pivotX1;
				y1=y1-pivotY1;
				int temp=x1;
				x1=y1;
				y1=-temp;
				x1=x1+pivotX1;
				y1=y1+pivotY1;
				c1.add(x1);
				c1.add(y1);
			}
			repaint();
			iteration++;
			System.out.println(c1);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
