package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Paint extends JPanel 
{
	BufferedImage image=new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
	private static final long serialVersionUID = 1L;
	public Paint() 
	{
		setPreferredSize(new Dimension(400,400));
	}
	public void paint(Graphics g)
	{
	      super.paint(g);
	      Graphics2D g2 = (Graphics2D)g;
	      Graphics2D g2im = image.createGraphics();
	      Color c=Color.white;
	      Color c0=Color.black;
	      Color c1=Color.red;
	      Color c2=Color.blue;
	      Color c3=Color.yellow;
	      Color c4=Color.green;
	      Rectangle2D tlo=new Rectangle2D.Double(0,0,400,400);
	      g2im.setPaint(Color.white);
	      g2im.fill(tlo);
	      List<int[]> a=Animation.pC;
	      for(int j=0;j<4;j++)
	      {
	    	  	int[] b=new int[3];
	    	  	b=a.get(j);
	    	  	Ellipse2D circle=new Ellipse2D.Double(b[0], b[1], 10, 10);
	    	  	if(b[2]==0)
	    	  	g2im.setPaint(c);
	    	  	if(b[2]==1)
		    	g2im.setPaint(c0);
	    	  	else if(b[2]%4==1&&b[2]>1)
	    	  	g2im.setPaint(c1);
	    	  	else if(b[2]%4==2&&b[2]>1)
	    	  	g2im.setPaint(c2);
	    	  	else if(b[2]%4==3&&b[2]>1)
	    	  	g2im.setPaint(c3);
	    	  	else if(b[2]%4==0&&b[2]>1)
		    	g2im.setPaint(c4);
				g2im.fill(circle);
				repaint();
	      }
	      g2.drawImage(image, null, 0, 0);
	}
	
	public Paint(LayoutManager layout) 
	{
		super(layout);
	}

	public Paint(boolean isDoubleBuffered) 
	{
		super(isDoubleBuffered);
	}

	public Paint(LayoutManager layout, boolean isDoubleBuffered) 
	{
		super(layout, isDoubleBuffered);
	}
}
